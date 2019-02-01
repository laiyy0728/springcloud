//package com.laiyy.gitee.dashboard.springcloudhystrixdashboardexception.decoder;
//
//import com.netflix.hystrix.exception.HystrixBadRequestException;
//import feign.FeignException;
//import feign.Response;
//import feign.Util;
//import feign.codec.ErrorDecoder;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
///**
// * @author laiyy
// * @date 2019/2/1 11:38
// * @description
// */
//@Component
//public class BadRequestErrorDecoder implements ErrorDecoder {
//    @Override
//    public Exception decode(String methodKey, Response response) {
//        if (response.status() >= 400 && response.status() <= 499) {
//            String error = null;
//            try {
//                error = Util.toString(response.body().asReader());
//            } catch (IOException e) {
//                System.out.println("BadRequestErrorDecoder 出错了！" + e.getLocalizedMessage());
//            }
//            return new HystrixBadRequestException(error);
//        }
//        return FeignException.errorStatus(methodKey, response);
//    }
//}
