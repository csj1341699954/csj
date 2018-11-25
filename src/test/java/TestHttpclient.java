import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.annotations.Insert;
import org.junit.Test;
import org.springframework.web.bind.annotation.InitBinder;

import javax.swing.plaf.basic.BasicTextUI;
import javax.xml.ws.Response;
import java.io.*;

public class TestHttpclient {

    public  void   testClient() {
        //打开浏览器
        CloseableHttpClient build = HttpClientBuilder.create().build();
        //输入地址
        HttpGet get = new HttpGet("https://baike.baidu.com/item/%E8%A1%A8%E5%AD%97/3493878");
        //敲回车
        CloseableHttpResponse response = null;
        String result=null;
        try {
            response = build.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            File f=new File("E://aaa.txt"); // 定位文件位置
            Writer out =new FileWriter(f); //创建字符输出流连接到文件
            out.write(result); //写操作
            out.close(); //关闭流
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null!=response){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }if(get!=null){
                get.releaseConnection();
            }if(build!=null){
                try {
                    build.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    public void   test(){
        //创建浏览器
        CloseableHttpClient build = HttpClientBuilder.create().build();
        //输入地址
        HttpGet httpGet = new HttpGet("https://www.booktxt.net/1_1213/405200.html");
        //敲回车
        CloseableHttpResponse execute = null;
        try {
            execute = build.execute(httpGet);
            HttpEntity executeEntity = execute.getEntity();
            String string = EntityUtils.toString(executeEntity, "utf-8");
            File f=new File("E://aaa.txt"); // 定位文件位置
            Writer out =new FileWriter(f); //创建字符输出流连接到文件
            out.write(string); //写操作
            out.close(); //关闭流
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
            }if(build!=null){
                try {
                    build.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    public  void  test1(){
        //创建浏览器
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        //输入地址
        HttpGet httpGet = new HttpGet("https://www.zhetian.org/1361/1.html");
        //敲回车
        CloseableHttpResponse execute = null;
        try {
            execute = httpClient.execute(httpGet);
            HttpEntity entity = execute.getEntity();
            String string = EntityUtils.toString(entity, "utf-8");
            System.out.println(string);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(execute!=null){
                try {
                    execute.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }if (httpGet!=null){
                httpGet.releaseConnection();
            }
            if(httpClient!=null){
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public  void  test2(){
        //创建浏览器
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        //输入地址
        HttpGet httpGet = new HttpGet("https://baike.baidu.com/item/%E6%AD%A6%E6%88%90%E7%8E%8B%E5%BA%99%E5%85%AD%E5%8D%81%E5%9B%9B%E5%B0%86/4452241?fromtitle=%E5%8F%A4%E4%BB%8A%E5%85%AD%E5%8D%81%E5%9B%9B%E5%90%8D%E5%B0%86&fromid=9483022");
       //敲回车
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            //获得内容
            HttpEntity entity = response.getEntity();
            String string = EntityUtils.toString(entity, "utf-8");
            System.out.println(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
