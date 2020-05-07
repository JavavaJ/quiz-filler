package com.speakplusplus.quizfiller;

import com.speakplusplus.quizfiller.service.QuestionService;
import com.speakplusplus.quizfiller.service.TagCreator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuizFillerApplication {

    public static void main(String[] args) {


//		QuestionCreator questionCreator = new QuestionCreator();
//		Question question = questionCreator.create(token);
//		System.out.println("Question: " + question);

		TagCreator tagCreator = new TagCreator();
		tagCreator.create("myTag");

        SpringApplication.run(QuizFillerApplication.class, args);

        // read all questions
        QuestionService questionService = new QuestionService();
        Object questions = questionService.getAllQuestions();
        System.out.println("Questions: " + questions);


    }

}
