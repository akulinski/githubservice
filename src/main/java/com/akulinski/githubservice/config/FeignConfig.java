package com.akulinski.githubservice.config;

import com.akulinski.githubservice.core.feign.RepositoryClient;
import feign.Feign;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Value("${feignconf.username}")
    private String username;

    @Value("${feignconf.password}")
    private String password;

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor(username, password);
    }

    @Bean
    public RepositoryClient getRepositoryClient() {
        return Feign.builder().client(new OkHttpClient())
                .requestInterceptor(basicAuthRequestInterceptor())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(RepositoryClient.class))
                .logLevel(Logger.Level.FULL)
                .target(RepositoryClient.class, "https://api.github.com");
    }

}
