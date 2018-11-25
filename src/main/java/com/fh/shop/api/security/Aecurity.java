package com.fh.shop.api.security;

import com.fh.shop.api.app.biz.IAppService;
import com.fh.shop.api.common.ServerResponse;
import com.fh.shop.api.common.SystemEnum;
import com.fh.shop.api.limit.Limit;
import com.fh.shop.api.util.CheckSumBuilder;
import com.fh.shop.api.util.RedisUtil;
import com.fh.shop.api.util.WebContext;
import com.opensymphony.oscache.util.StringUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

public class Aecurity {


    private  static  final  long EXPIRE=30*1000;

    @Resource(name ="appService")
    private IAppService appService;
    public    Object security(ProceedingJoinPoint pjp){

        HttpServletRequest reuqest = WebContext.getReuqest();
        String appkey = reuqest.getHeader("appkey");
        String time = reuqest.getHeader("time");
        String sign = reuqest.getHeader("sign");
        String nonce = reuqest.getHeader("nonce");

        //验证头信息
        if (StringUtil.isEmpty(appkey)|| StringUtil.isEmpty(time) || StringUtil.isEmpty(sign)|| StringUtils.isEmpty(nonce)){
            return ServerResponse.error(SystemEnum.HEADR_NOT_MISS);
        }
        long resultTime = Long.parseLong(time);
        //验证超时
        if(EXPIRE < System.currentTimeMillis()-resultTime){
            return ServerResponse.error(SystemEnum.TIME_NOT_OVERDUE);
        }
        //验证次数
        Boolean setNxExpire = RedisUtil.setNxExpire(nonce,"1",30);
        if(!setNxExpire){
            return ServerResponse.error(SystemEnum.ATTACKED);
        }
        //验证appkey
        String appsecret = appService.findUser(appkey);
        if(StringUtil.isEmpty(appsecret)){
            return ServerResponse.error(SystemEnum.APPKEY_NOT_MISS);
        }

        String checkSum = CheckSumBuilder.getCheckSum(appsecret, nonce, time);
        System.err.println(appsecret+"***"+nonce+"***"+time);
        System.out.println(checkSum+"++++++++++++++++++++++");
        if (!checkSum.equals(sign)){
            return ServerResponse.error(SystemEnum.SIGN_NOT_MISS);
        }



         MethodSignature signature= (MethodSignature) pjp.getSignature();

        Method method = signature.getMethod();

        if(method.isAnnotationPresent(Limit.class)){
            Limit annotation = method.getAnnotation(Limit.class);
            int maxCount = annotation.maxCount();
            int seconds = annotation.seconds();
            String key =appkey+":"+reuqest.getMethod()+":"+reuqest.getRequestURI();
            if(RedisUtil.incrExpire(key,seconds)>maxCount){
              return ServerResponse.error(SystemEnum.THE_NUMBER_OF_CAPS);
            }
        }


        Object proceed=null;
        try {
            proceed = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return  ServerResponse.error(null);
        }
        return proceed;
    }



    public static void main(String[] args) {
      String   nonce = UUID.randomUUID().toString().toUpperCase() + ":" + RandomStringUtils.random(10) + "" +System.currentTimeMillis();
        long time = new Date().getTime();
        System.out.println(time+":"+CheckSumBuilder.getCheckSum("375d2d6e866c4686922e52ba4fd534f7",nonce,time+""));
    }
}
