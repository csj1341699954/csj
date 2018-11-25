package com.fh.shop.api.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpUilt {


    public static String   httpPost(String url, Map<String,String> parmas,Map<String,String> headers){
        //创建浏览器
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        //获得路径
        HttpPost post = new HttpPost(url);
        //是否有参数信息
        List<NameValuePair> pairList=new ArrayList<NameValuePair>();
        if(parmas!=null && parmas.size()>0){
            Iterator<Map.Entry<String, String>> iterator = parmas.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<String, String> next = iterator.next();
                String key = next.getKey();
                String value = next.getValue();
                pairList.add(new BasicNameValuePair(key,value));
            }
            try {
                UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(pairList,"utf-8");
                post.setEntity(urlEncodedFormEntity);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        if(headers!=null && headers.size()>0){
            Iterator<Map.Entry<String, String>> iterator = headers.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<String, String> next = iterator.next();
                String key = next.getKey();
                String value = next.getValue();
                post.addHeader(key,value);
            }
        }
        //敲回车
        CloseableHttpResponse execute = null;
        String string="";
        try {
            execute = httpClient.execute(post);
            //获取内容
            HttpEntity entity = execute.getEntity();
            string  = EntityUtils.toString(entity, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(execute!=null){
                try {
                    execute.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }if(post!=null){
                post.releaseConnection();
            }if(httpClient!=null){
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
         return string;
    }
}
