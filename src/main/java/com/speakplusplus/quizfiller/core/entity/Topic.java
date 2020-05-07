package com.speakplusplus.quizfiller.core.entity;

public class Topic {
    private Long id;
    private String title;

    public Topic() {
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

    @Override
    public String toString() {
        return "Topic{" +
            "title='" + title + '\'' +
            '}';
    }
}

