package com.laiyy.gitee.feign.file.springcloudfeignfileclient.feign;

import com.laiyy.gitee.feign.file.springcloudfeignfileclient.config.FeignMultipartConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.ws.Response;

/**
 * @author laiyy
 * @date 2019/1/25 10:10
 * @description
 */
@FeignClient(value = "spring-cloud-feign-file-server", configuration = FeignMultipartConfiguration.class)
public interface FileUploadFeignClient {

    /**
     * feign 上传图片
     *
     * produces、consumes 必填
     * 不要将 @RequestPart 写成 @RequestParam
     *
     * @param file 上传的文件
     * @return 上传的文件名
     */
    @RequestMapping(value = "/upload-file", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String fileUpload(@RequestPart(value = "file")MultipartFile file);

    /**
     * 获取图片
     * @return 图片
     */
    @RequestMapping(value = "/get-img")
    ResponseEntity<byte[]> getImage();
}
