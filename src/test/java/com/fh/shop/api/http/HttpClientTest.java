package com.fh.shop.api.http;

import com.fh.shop.api.util.CheckSumBuilder;
import com.fh.shop.api.util.HttpUilt;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class HttpClientTest {
    private  static  final String APP_SECRET="f6488413cca9";

    @Test
    public  void  utilHttpClient(){

        Map parmas =new HashMap();
        parmas.put("mobile","15194422063");

        Map headers = new HashMap();
        headers.put("AppKey","6113782256210b22a333bc9a749bb976");
        String alphanumeric = RandomStringUtils.randomAlphanumeric(10);
        headers.put("Nonce",alphanumeric);
        String time = new Date().getTime() + "";
        headers.put("CurTime",time);
        headers.put("CheckSum",CheckSumBuilder.getCheckSum(APP_SECRET,alphanumeric,time));
        String s = HttpUilt.httpPost("https://api.netease.im/sms/sendcode.action", parmas, headers);
        System.out.println(s);
    }




    public  void   TestHttpClient(){
        //创建浏览器
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        //输入地址
        HttpPost httpPost = new HttpPost("https://api.netease.im/sms/sendcode.action");
        //是否有头信息
        httpPost.addHeader("AppKey","6113782256210b22a333bc9a749bb976");
        String alphanumeric = RandomStringUtils.randomAlphanumeric(10);
        httpPost.addHeader("Nonce",alphanumeric);
        String time = new Date().getTime() + "";
        httpPost.addHeader("CurTime",time);
        httpPost.addHeader("CheckSum",CheckSumBuilder.getCheckSum(APP_SECRET,alphanumeric,time));
        //请求的参数
        List<NameValuePair> params= new ArrayList<NameValuePair>();
        BasicNameValuePair mobile = new BasicNameValuePair("mobile", "15194422063");
        params.add(mobile);
        try {
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(params, "utf-8");
            httpPost.setEntity(urlEncodedFormEntity);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //敲回车
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            //获取内容
            HttpEntity entity = response.getEntity();
            String string = EntityUtils.toString(entity, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(response!=null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }if(httpPost!=null){
                httpPost.releaseConnection();
            }if(httpClient!=null){
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
