package com.fh.shop.api.http;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.transfer.TransferManager;
import org.junit.Test;

import javax.swing.plaf.synth.Region;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpCos {

    static String bucketName = "wan-gu-1257664014"; //桶的名称
    static String key = "/img";         //上传到云上路径
    static String region = "ap-beijing";//区域北京则  beijing
    static String appId = "1257664014"; //APPID
    static COSCredentials cred = null;
    static TransferManager transferManager = null;
    static COSClient cosClient = null;



    /**
     * 上传
     */
    @Test
    public  void picCOS() throws Exception {

        COSCredentials cred = new BasicCOSCredentials("AKIDWt1va2YFzUlogImogIky1pPlskNnQ0nK", "UnqfEXdT5TfcPzPdbJl12oKdmjeLm47z");
        ClientConfig clientConfig = new ClientConfig(new com.qcloud.cos.region.Region("ap-beijing"));
        COSClient cosclient = new COSClient(cred, clientConfig);
        String bucketName = "wan-gu-1257664014";
        File localFile = new File("C:/Users/lenovo/Desktop/图片/9a70b08842a3cf5f8cd981ca5750de4b.jpg");
        String key = "111.jpg";
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        PutObjectResult putObjectResult = cosclient.putObject(putObjectRequest);
    }
}