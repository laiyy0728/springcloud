package com.laiyy.gitee.feign.springcloudfeignfileserver.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author laiyy
 * @date 2019/1/25 10:21
 * @description
 */
@RestController
public class FileUploadController {

    @PostMapping(value = "/upload-file")
    public String fileUpload(MultipartFile file) {
        return file.getOriginalFilename();
    }

    @GetMapping(value = "/get-img")
    public ResponseEntity<byte[]> getImages() throws IOException {
        FileSystemResource resource = new FileSystemResource(getClass().getResource("/").getPath() + "Spring-Cloud.png");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", MediaType.APPLICATION_OCTET_STREAM_VALUE);
        headers.add("Content-Disposition", "attachment; filename=Spring-Cloud.png");
        return  ResponseEntity.status(HttpStatus.OK).headers(headers).body(FileCopyUtils.copyToByteArray(resource.getInputStream()));
    }

}
