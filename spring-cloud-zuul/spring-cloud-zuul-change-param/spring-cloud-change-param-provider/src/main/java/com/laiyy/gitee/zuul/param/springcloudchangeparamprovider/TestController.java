package com.laiyy.gitee.zuul.param.springcloudchangeparamprovider;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api
public class TestController {

	@PostMapping("/change-params")
    @ApiImplicitParam
	public Map<String, Object> modifyRequestEntity (HttpServletRequest request) {
        Map<String, Object> bodyParams = new HashMap<>();
        Enumeration enu = request.getParameterNames();  
        while (enu.hasMoreElements()) {  
	        String paraName = (String)enu.nextElement();  
	        bodyParams.put(paraName, request.getParameter(paraName));
        }

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();
            String value = request.getHeader(header);
            System.out.println(header + " ---> " + value);
        }
        return bodyParams;
	}
}