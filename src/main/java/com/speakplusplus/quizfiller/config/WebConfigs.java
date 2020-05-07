package com.speakplusplus.quizfiller.config;

import com.speakplusplus.quizfiller.core.entity.TokenBundle;
import com.speakplusplus.quizfiller.service.LoginProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Component
public class WebConfigs {

    @Bean
    @PostConstruct
    public RestTemplate template() {
        RestTemplate template = new RestTemplate();
        return template;
    }

    @Bean
    @PostConstruct
    public HttpHeaders buildHeaders() {
        LoginProcessor loginProcessor = new LoginProcessor();
        TokenBundle tokenBundle = loginProcessor.login();
        String token = loginProcessor.getRefreshedAccess(tokenBundle);

        HttpHeaders headers = new HttpHeaders();
        String authorizationVal = "Bearer " + token;
        headers.set("Authorization", authorizationVal);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

}
