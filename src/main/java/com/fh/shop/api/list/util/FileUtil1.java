package com.fh.shop.api.list.util;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;


public class FileUtil1 {

    public static  String upFile(CommonsMultipartFile partFile, String realPath) throws IOException {
        String oldFileName = partFile.getOriginalFilename();
        String suffix = oldFileName.substring(oldFileName.lastIndexOf("."));
        String newFileName = System.currentTimeMillis()+suffix;
        File file = new File(realPath);
        if(!file.exists()){
            file.mkdirs();
        }
        partFile.transferTo(new File(realPath+"//"+newFileName));
        return  newFileName;
    }

    public static  String upFile2(MultipartFile partFile, String realPath) throws IOException {
        String oldFileName = partFile.getOriginalFilename();
        String suffix = oldFileName.substring(oldFileName.lastIndexOf("."));
        String newFileName = System.currentTimeMillis()+suffix;
        File file = new File(realPath);
        if(!file.exists()){
            file.mkdirs();
        }
        partFile.transferTo(new File(realPath+"//"+newFileName));
        return  newFileName;
    }

    public static ResponseEntity<byte[]> FileDown(String filename,String realPath) throws IOException {
        File file = new File(realPath+"//"+filename);
        if(file.exists()){
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment",filename);
            byte[] bytes = FileUtils.readFileToByteArray(file);
            return new  ResponseEntity<byte[]>(bytes,headers, HttpStatus.CREATED);
        }else{
            return  null;
        }
    }
}
