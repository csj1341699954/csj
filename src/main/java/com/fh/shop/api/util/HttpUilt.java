package com.fh.shop.api.util;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpUilt {

    private static void buidheader(Map<String, String> headers, HttpUriRequest request) {
        if(null!=headers && !headers.isEmpty()){
            Iterator<Map.Entry<String, String>> iterator = headers.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<String, String> next = iterator.next();
                String key = next.getKey();
                String value = next.getValue();
                request.addHeader(key,value);
            }
        }
    }

    public static  String  sendDelete(String url,Integer id, Map<String, String> headers) {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        url+="/"+id;
        HttpDelete httpDelete = new HttpDelete(url);
        buidheader(headers, httpDelete);
        String string="";
        CloseableHttpResponse execute=null;
        try {
            execute  = client.execute(httpDelete);
            HttpEntity entity = execute.getEntity();
            string = EntityUtils.toString(entity, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(null != execute) {
                    execute.close();
                    execute=null;
                }
                if(null != httpDelete) {
                    httpDelete.releaseConnection();
                }
                if(null != client) {
                    client.close();
                    client=null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return string;
    }

    public  static  String httpPut(String url, Map<String,String> parmas,Map<String,String> headers){
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPut httpPut = new HttpPut(url);
        if(null!=parmas && !parmas.isEmpty()){
            Gson gson = new Gson();
            String json = gson.toJson(parmas);
            StringEntity stringEntity = new StringEntity(json, "utf-8");
            stringEntity.setContentType("application/json");
            httpPut.setEntity(stringEntity);
        }
        buidheader(headers, httpPut);
        String string="";
        CloseableHttpResponse execute=null;
        try {
            execute  = client.execute(httpPut);
            HttpEntity entity = execute.getEntity();
            string = EntityUtils.toString(entity, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(null != execute) {
                    execute.close();
                    execute=null;
                }
                if(null != httpPut) {
                    httpPut.releaseConnection();
                }
                if(null != client) {
                    client.close();
                    client=null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return string;
    }


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
         }
            buidheader(headers, post);
            UrlEncodedFormEntity urlEncodedFormEntity=null;
            try {
                urlEncodedFormEntity   = new UrlEncodedFormEntity(pairList,"utf-8");
                post.setEntity(urlEncodedFormEntity);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
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


    public static String   httpGet(String url, Map<String,String> parmas,Map<String,String> headers){
        //创建浏览器
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        //获得路径
        HttpGet httpGet = null;
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
        }
          buidheader(headers, httpGet);
          String result=null;
        try {
            result   = EntityUtils.toString(new UrlEncodedFormEntity(pairList, "utf-8"));
                httpGet = new HttpGet(url+"?"+result);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        //敲回车
        CloseableHttpResponse execute = null;
        String string="";
        try {
            execute = httpClient.execute(httpGet);
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
            }if(httpGet!=null){
                httpGet.releaseConnection();
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
