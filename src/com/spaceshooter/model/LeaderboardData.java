package com.spaceshooter.model;

import java.io.Serializable;

public class LeaderboardData implements Comparable, Serializable {
    private String username;
    private int score;

    public LeaderboardData(String username, int score) {
        this.username = username;
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Object o) {
        LeaderboardData leaderboardData = (LeaderboardData) o;

        return leaderboardData.score - this.score;
    }
}
