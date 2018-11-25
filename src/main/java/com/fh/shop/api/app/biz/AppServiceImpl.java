package com.fh.shop.api.app.biz;

import com.fh.shop.api.app.mapper.IAppMapper;
import com.fh.shop.api.util.RedisUtil;
import com.opensymphony.oscache.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;


@Service("appService")
public class AppServiceImpl implements IAppService{
    @Resource
    private IAppMapper appMapper;

    @Override
    public String findUser(String appkey) {
        String app = RedisUtil.get(appkey);
        if(!StringUtil.isEmpty(app)){
            return app;
        }
         app = appMapper.findUser(appkey);
        System.out.println(app+"5555555555555555555");
        if(StringUtil.isEmpty(app)){
            return "";
        }
        RedisUtil.set(appkey,app);
        return app;
    }

    public static void main(String[] args) {
//        String replace = UUID.randomUUID().toString().replace("-", "");
//        String replace1 = UUID.randomUUID().toString().replace("-", "");
//        System.out.println(replace+":::::::"+""+replace1);
        long time = new Date().getTime();
        System.out.println(time);
    }
}
