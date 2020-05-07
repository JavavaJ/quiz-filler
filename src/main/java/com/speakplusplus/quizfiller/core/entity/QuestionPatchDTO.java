package com.speakplusplus.quizfiller.core.entity;

import java.util.Set;

public class QuestionPatchDTO {
    private String title;
    private String text;
    private String help;
    private Set<Long> answers;
    private Set<Long> correctAnswers;
    private Set<Long> tags;
    private Set<Long> topics;
    private Integer difficulty;

    public QuestionPatchDTO() {
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

    public Set<Long> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Long> answers) {
        this.answers = answers;
    }

    public Set<Long> getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(Set<Long> correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public Set<Long> getTags() {
        return tags;
    }

    public void setTags(Set<Long> tags) {
        this.tags = tags;
    }

    public Set<Long> getTopics() {
        return topics;
    }

    public void setTopics(Set<Long> topics) {
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
            "title='" + title + '\'' +
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

