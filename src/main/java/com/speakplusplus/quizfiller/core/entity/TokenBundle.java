package com.speakplusplus.quizfiller.core.entity;

public class TokenBundle {
    private String accessToken;
    private String refreshToken;

    public TokenBundle() {
    }

    public TokenBundle(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public String toString() {
        return "TokenBundle{" +
            "accessToken='" + accessToken + '\'' +
            ", refreshToken='" + refreshToken + '\'' +
            '}';
    }
}

