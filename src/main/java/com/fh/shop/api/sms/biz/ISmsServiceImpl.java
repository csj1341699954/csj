package com.fh.shop.api.sms.biz;

import com.fh.shop.api.common.ServerResponse;
import com.fh.shop.api.common.SystemEnum;
import com.fh.shop.api.util.RedisUtil;
import com.fh.shop.api.util.SendSmsUtil;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("smsService")
public class ISmsServiceImpl implements ISmsService {


    @Override
    public ServerResponse smsHttp(String mobile) {
        if(StringUtils.isEmpty(mobile)){
            return ServerResponse.error(SystemEnum.SMS_MOBILE_NOT);
        }
        if(mobile.length()!=11){
            return ServerResponse.error(SystemEnum.SMS_MOBILE_INCORRECT);
        }
        String sendSms = SendSmsUtil.SendSms(mobile);
        Gson gson = new Gson();
        Map map = gson.fromJson(sendSms, Map.class);
        int code = ((Double) map.get("code")).intValue();
        String msg = (String) map.get("msg");
        String msgCode = (String) map.get("obj");
        if(code!=200){
            return ServerResponse.error(-1,"网易云接口出现异常"+msg);
        }
        //赋值
        RedisUtil.set(mobile,msgCode);
        //设置过期时间
        RedisUtil.expire(mobile,60);
        return ServerResponse.success();
    }
}
