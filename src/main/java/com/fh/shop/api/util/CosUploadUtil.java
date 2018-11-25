package com.fh.shop.api.util;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.region.Region;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

public class CosUploadUtil {


    public static  void deleteFile(String key){
        COSClient cosClient = getCosClient();
        cosClient.deleteObject(SystemContext.BUCKET,key);

    }



    public  static  String   uploadFile(InputStream is) {
        COSClient cosClient = getCosClient();

        // bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
    String bucketName = SystemContext.BUCKET;
    // 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20M以下的文件使用该接口
    // 大文件上传请参照 API 文档高级 API 上传
        // 方法 2 从输入流上传(需提前告知输入流的长度, 否则可能导致 oom)
        // 指定要上传到 COS 上对象键
        // 对象键（Key）是对象在存储桶中的唯一标识。例如，在对象的访问域名 `bucket1-1250000000.cos.ap-guangzhou.myqcloud.com/doc1/pic1.jpg` 中，对象键为 doc1/pic1.jpg, 详情参考 [对象键](https://cloud.tencent.com/document/product/436/13324)
        Date date = new Date();
        String str = DateUtil.convertDate2Str(date, DateUtil.Y_M_D);
        UUID uuid = UUID.randomUUID();
        String key = str+"/"+uuid+".jsp";
        ObjectMetadata objectMetadata = new ObjectMetadata();
     // 设置输入流长度为 500
        try {
            objectMetadata.setContentLength(is.available());
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, is,objectMetadata);
            cosClient.putObject(putObjectRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(is!=null){
                try {
                    is.close();
                    is=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }if(cosClient!=null){
                cosClient.shutdown();
                cosClient=null;
            }
        }

     return  SystemContext.COS_URL+key;
    }

    private static COSClient getCosClient() {
        // 1 初始化用户身份信息(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials(SystemContext.SECRETID, SystemContext.SECRETKEY);
        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig中包含了设置region, https(默认http), 超时, 代理等set方法, 使用可参见源码或者接口文档FAQ中说明
        ClientConfig clientConfig = new ClientConfig(new Region(SystemContext.HTTP));
        // 3 生成cos客户端
        return new COSClient(cred, clientConfig);
    }
}
