package com.csh.cricket.aistats.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {


    @Bean
    public WebClient.Builder defaultWebClientBuilder() {
        return WebClient.builder();
    }

    @Bean
    @LoadBalanced
    public WebClient.Builder loadBalancedWebClientBuilder() {
        return WebClient.builder();
    }

    @Bean
    public WebClient playerServiceWebClient(WebClient.Builder loadBalancedWebClientBuilder, @Value("${cricket.stats.baseurl}") String baseUrl) {
        return loadBalancedWebClientBuilder.baseUrl(baseUrl).build();
    }

    @Bean
    public WebClient geminiServiceWebClient(WebClient.Builder defaultWebClientBuilder, @Value("${gemini.uri}") String geminiUrl, @Value("${gemini.key}") String geminiKey) {
        return defaultWebClientBuilder.baseUrl(geminiUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("x-goog-api-key", geminiKey)
                .build();
    }

}
