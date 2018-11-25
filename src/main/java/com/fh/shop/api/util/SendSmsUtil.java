package com.fh.shop.api.util;

import com.fh.shop.api.common.SystemContext;
import org.apache.commons.lang.RandomStringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SendSmsUtil {

    public static String SendSms(String mobile){
        Map parmas =new HashMap();
        parmas.put("mobile",mobile);
//        parmas.put("templateid",SystemContext.TEMPLATEID);
        parmas.put("codelen",SystemContext.CODELEN);

        Map headers = new HashMap();
        headers.put("AppKey",SystemContext.APPKEY);
        String alphanumeric = RandomStringUtils.randomAlphanumeric(10);
        headers.put("Nonce",alphanumeric);
        String time = new Date().getTime() + "";
        headers.put("CurTime",time);
        headers.put("CheckSum",CheckSumBuilder.getCheckSum(SystemContext.APPSECRET,alphanumeric,time));
        String result = HttpUilt.httpPost(SystemContext.SMSURL, parmas, headers);
        return result;
    }
}
