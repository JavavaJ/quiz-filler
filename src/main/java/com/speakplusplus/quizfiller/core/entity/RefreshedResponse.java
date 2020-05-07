package com.speakplusplus.quizfiller.core.entity;

public class RefreshedResponse {
    private String accessToken;

    public RefreshedResponse() {
    }

    public RefreshedResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public String toString() {
        return "RefreshedResponse{" +
            "accessToken='" + accessToken + '\'' +
            '}';
    }
}
