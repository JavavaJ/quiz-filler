package com.speakplusplus.quizfiller.service;

import com.speakplusplus.quizfiller.core.entity.TokenBundle;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class WebUtils {

    private static RestTemplate restTemplate = new RestTemplate();

    public static HttpHeaders buildHeaders() {
        LoginProcessor loginProcessor = new LoginProcessor();
        TokenBundle tokenBundle = loginProcessor.login();
        String token = loginProcessor.getRefreshedAccess(tokenBundle);

        HttpHeaders headers = new HttpHeaders();
        String authorizationVal = "Bearer " + token;
        headers.set("Authorization", authorizationVal);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    public static RestTemplate getTemplate() {
        return restTemplate;
    }

}
