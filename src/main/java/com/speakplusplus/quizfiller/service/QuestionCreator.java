package com.speakplusplus.quizfiller.service;

import com.speakplusplus.quizfiller.core.entity.*;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuestionCreator {

    public Question create(String token) {
        AnswerCreator answerCreator = new AnswerCreator();

        Answer answer1 = answerCreator.createAnswer("blow", token);
        Answer correctAnswer = answerCreator.createAnswer("crash", token);
        Answer answer2 = answerCreator.createAnswer("shock", token);
        Answer answer3 = answerCreator.createAnswer("hit", token);

        List<Answer> allAnswers = Arrays.asList(answer1, correctAnswer, answer2, answer3);

        Set<Long> answersIds = allAnswers.stream()
            .map(Answer::getId)
            .collect(Collectors.toCollection(HashSet::new));

        Set<Long> correctAnsIds = Stream.of(correctAnswer)
            .map(Answer::getId)
            .collect(Collectors.toCollection(HashSet::new));

        TagCreator tagCreator = new TagCreator();
        Tag tag = tagCreator.create("vocabulary");
        Set<Long> tags = new HashSet<>(Arrays.asList(tag.getId()));

        TopicCreator topicCreator = new TopicCreator();
        Topic topic = topicCreator.create("English-lang", token);
        Set<Long> topics = new HashSet<>(Arrays.asList(topic.getId()));

        QuestionPatchDTO questionPatchDTO = new QuestionPatchDTO();
        questionPatchDTO.setText("He was killed in a car ______.");
        questionPatchDTO.setTitle("Choose the correct Answer");
        questionPatchDTO.setHelp("No help here");
        questionPatchDTO.setAnswers(answersIds);
        questionPatchDTO.setCorrectAnswers(correctAnsIds);
        questionPatchDTO.setTags(tags);
        questionPatchDTO.setTopics(topics);

        RestTemplate restTemplate = new RestTemplate();

        String questionsUrl = "https://quiz-api.force.fm/questions";
        HttpHeaders headers = WebUtils.buildHeaders(); // TODO that is not what was intended
        HttpEntity<QuestionPatchDTO> httpEntity = new HttpEntity<>(questionPatchDTO, headers);

        ResponseEntity<Question> entity = restTemplate.exchange(questionsUrl, HttpMethod.POST, httpEntity, Question.class);
        HttpStatus statusCode = entity.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        if (statusCode.equals(HttpStatus.CREATED)) {
            return entity.getBody();
        } else {
            return null;
        }
    }

}

