package com.speakplusplus.quizfiller.core.entity;

import java.util.Set;

public class Question {
    private Long id;
    private String title;
    private String text;
    private String help;
    private Set<Answer> answers;
    private Set<Answer> correctAnswers;
    private Set<Tag> tags;
    private Set<Topic> topics;
    private Integer difficulty;

    public Question() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

    public Set<Answer> getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(Set<Answer> correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Set<Topic> getTopics() {
        return topics;
    }

    public void setTopics(Set<Topic> topics) {
        this.topics = topics;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Question{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", text='" + text + '\'' +
            ", help='" + help + '\'' +
            ", answers=" + answers +
            ", correctAnswers=" + correctAnswers +
            ", tags=" + tags +
            ", topics=" + topics +
            ", difficulty=" + difficulty +
            '}';
    }
}

