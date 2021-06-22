package com.example.product;

import com.example.common.config.ApiLoggingFilterConfig;
import com.example.common.config.OpenApiConfig;
import com.example.common.config.WebSecurityConfig;
import com.example.common.exception.ApiExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
@Import({
    OpenApiConfig.class,
    ApiLoggingFilterConfig.class,
    ApiExceptionHandler.class,
    WebSecurityConfig.class
})
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
