package com.speakplusplus.quizfiller.service;

import com.speakplusplus.quizfiller.core.entity.Answer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AnswerCreator {

    public Answer createAnswer(String text, String token) {
        Answer answer = new Answer();
        answer.setText(text);

        RestTemplate restTemplate = new RestTemplate();

        String answersUrl = "https://quiz-api.force.fm/answers";

        HttpHeaders headers = WebUtils.buildHeaders();
        HttpEntity<Answer> httpEntity = new HttpEntity<>(answer, headers);

        ResponseEntity<Answer> responseEntity = restTemplate.exchange(answersUrl, HttpMethod.POST, httpEntity, Answer.class);
        Answer answerReturned = responseEntity.getBody();
        System.out.println("Answer: " + answerReturned);
        return answerReturned;
    }

}
