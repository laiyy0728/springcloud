package com.laiyy.gitee.eureka.springcloudeurekaclienthttps;

import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.shared.transport.jersey.EurekaJerseyClientImpl;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/**
 * @author laiyy
 * @date 19-1-20
 * @infomation
 */
@Configuration
public class EurekaHttpsClientConfiguration {

    @Value("${eureka.client.ssl.key-store}")
    private String ketStoreFileName;

    @Value("${eureka.client.ssl.key-store-password}")
    private String ketStorePassword;

    @Bean
    public DiscoveryClient.DiscoveryClientOptionalArgs discoveryClientOptionalArgs() throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException, KeyManagementException {
        EurekaJerseyClientImpl.EurekaJerseyClientBuilder builder = new EurekaJerseyClientImpl.EurekaJerseyClientBuilder();
        builder.withClientName("eureka-https-client");
        URL url = this.getClass().getClassLoader().getResource(ketStoreFileName);
        SSLContext sslContext = new SSLContextBuilder()
                .loadTrustMaterial(url, ketStorePassword.toCharArray()).build();
        builder.withCustomSSL(sslContext);
        builder.withMaxTotalConnections(10);
        builder.withMaxConnectionsPerHost(10);

        DiscoveryClient.DiscoveryClientOptionalArgs optionalArgs = new DiscoveryClient.DiscoveryClientOptionalArgs();
        optionalArgs.setEurekaJerseyClient(builder.build());

        return optionalArgs;
    }

}
