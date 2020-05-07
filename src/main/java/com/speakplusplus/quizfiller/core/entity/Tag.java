package com.speakplusplus.quizfiller.core.entity;

public class Tag {
    private Long id;
    private String name;
    private String slug;
    private User owner;

    public Tag() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Tag{" +
            "name='" + name + '\'' +
            ", slug='" + slug + '\'' +
            '}';
    }
}

