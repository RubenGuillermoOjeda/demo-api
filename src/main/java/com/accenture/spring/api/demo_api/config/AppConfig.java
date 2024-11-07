package com.accenture.spring.api.demo_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class AppConfig {

    @Bean
    RestClient restClient() {
        return RestClient.create();
     }

}
