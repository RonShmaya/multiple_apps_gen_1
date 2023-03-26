package com.ron.common.utils;

public class UserScore implements Comparable<UserScore>  {

    private String name;
    private int score;

    public UserScore() {
    }

    public UserScore(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public UserScore setName(String name) {
        this.name = name;
        return this;
    }

    public int getScore() {
        return score;
    }

    public UserScore setScore(int score) {
        this.score = score;
        return this;
    }

    @Override
    public int compareTo(UserScore userScore) {
        return userScore.score - score ;
    }
}
