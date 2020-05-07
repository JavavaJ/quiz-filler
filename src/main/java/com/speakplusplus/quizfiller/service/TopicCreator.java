package com.speakplusplus.quizfiller.service;

import com.speakplusplus.quizfiller.core.entity.Topic;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class TopicCreator {

    public Topic create(String title, String token) {
        Topic topic = new Topic();
        topic.setTitle(title);

        RestTemplate restTemplate = new RestTemplate();
        String topicsUrl = "https://quiz-api.force.fm/topics";

        HttpHeaders headers = WebUtils.buildHeaders();
        HttpEntity<Topic> httpEntity = new HttpEntity<>(topic, headers);

        ResponseEntity<Topic> responseEntity = restTemplate.exchange(topicsUrl, HttpMethod.POST, httpEntity, Topic.class);
        Topic topicReturned = responseEntity.getBody();
        System.out.println("Topic: " + topicReturned);
        return topicReturned;
    }

}
