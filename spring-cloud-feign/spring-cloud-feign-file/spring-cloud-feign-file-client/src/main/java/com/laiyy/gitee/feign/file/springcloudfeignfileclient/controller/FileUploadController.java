package com.laiyy.gitee.feign.file.springcloudfeignfileclient.controller;

import com.laiyy.gitee.feign.file.springcloudfeignfileclient.feign.FileUploadFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.ws.Response;

/**
 * @author laiyy
 * @date 2019/1/25 10:18
 * @description
 */
@RestController
public class FileUploadController {

    private final FileUploadFeignClient feignClient;

    @Autowired
    public FileUploadController(FileUploadFeignClient feignClient) {
        this.feignClient = feignClient;
    }

    @PostMapping(value = "/upload")
    public String upload(MultipartFile file){
        return feignClient.fileUpload(file);
    }

    @GetMapping(value = "/get-img")
    public ResponseEntity<byte[]> getImage(){
        return feignClient.getImage();
    }

}
