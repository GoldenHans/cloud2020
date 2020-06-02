package com.hans.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
    // 将RestTemplate注入到容器中,不能少了@Configuration,@Bean,注入之后其他类才可以注入
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
