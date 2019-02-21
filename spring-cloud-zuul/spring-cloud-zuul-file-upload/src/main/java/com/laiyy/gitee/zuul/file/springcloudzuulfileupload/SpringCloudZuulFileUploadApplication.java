package com.laiyy.gitee.zuul.file.springcloudzuulfileupload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@RestController
public class SpringCloudZuulFileUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZuulFileUploadApplication.class, args);
    }


    @PostMapping(value = "/upload")
    public String uploadFile(@RequestParam(value = "file") MultipartFile file) throws Exception {
        byte[] bytes = file.getBytes();
        File fileToSave = new File(file.getOriginalFilename());
        FileCopyUtils.copy(bytes, fileToSave);
        return fileToSave.getAbsolutePath();
    }

}
