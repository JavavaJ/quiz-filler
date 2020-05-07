package com.speakplusplus.quizfiller.core.entity;

public class TagPatchDTO {
    private String name;

    public TagPatchDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TagPatchDTO{" +
            "name='" + name + '\'' +
            '}';
    }
}
