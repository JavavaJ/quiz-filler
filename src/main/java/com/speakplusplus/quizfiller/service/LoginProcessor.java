package com.speakplusplus.quizfiller.service;

import com.speakplusplus.quizfiller.constants.Urls;
import com.speakplusplus.quizfiller.core.entity.RefreshedResponse;
import com.speakplusplus.quizfiller.core.entity.TokenBundle;
import com.speakplusplus.quizfiller.core.entity.User;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class LoginProcessor {

    public TokenBundle login() {
        RestTemplate restTemplate = new RestTemplate();

        String myLogin = "alberto88@mail.ru";
        String myPass = "testpass";

        User myUser = new User(myLogin, myPass);

        ResponseEntity<TokenBundle> tokenBundleResponseEntity = restTemplate.postForEntity(Urls.LOGIN, myUser, TokenBundle.class);
        HttpStatus statusCode = tokenBundleResponseEntity.getStatusCode();

        if (statusCode.equals(HttpStatus.OK)) {
            return tokenBundleResponseEntity.getBody();
        } else {
            return null;
        }
    }

    public String getRefreshedAccess(TokenBundle tokenBundle) {
        String refreshUrl = "https://quiz-api.force.fm/auth/refresh";

        HttpHeaders headers = new HttpHeaders();
        String refreshCookie = new StringBuilder("Refresh-Token=").append(tokenBundle.getRefreshToken())
            .toString();
        headers.set("cookie", refreshCookie);

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RefreshedResponse> responseEntity = restTemplate.exchange(refreshUrl, HttpMethod.POST, httpEntity, RefreshedResponse.class);
        System.out.println("Refreshed access token: " + responseEntity.getBody());

        if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
            return responseEntity.getBody().getAccessToken();
        } else {
            return null;
        }
    }

}

