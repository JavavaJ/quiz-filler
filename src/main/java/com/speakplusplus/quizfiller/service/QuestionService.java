package com.speakplusplus.quizfiller.service;

import com.speakplusplus.quizfiller.constants.Urls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class QuestionService {

//    @Autowired
//    RestTemplate template;

//    @Autowired
//    HttpHeaders headers;

    public Object getAllQuestions() {
        HttpHeaders headers = WebUtils.buildHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        RestTemplate template = new RestTemplate();
        ResponseEntity<Object> responseEntity = template.exchange(
            Urls.QUESTIONS_GET,
            HttpMethod.GET,
            httpEntity,
            Object.class);
        return responseEntity.getBody();
    }

}

