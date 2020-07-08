package com.spaceshooter.controller;

import com.spaceshooter.model.LeaderboardData;

import java.util.ArrayList;
import java.util.Collections;

public class LeaderboardsManager {
    final private String leaderboardFilename = "scores.dat";
    private ArrayList<LeaderboardData> leaderboardsData;

    public LeaderboardsManager() {
        leaderboardsData = (ArrayList<LeaderboardData>) FileHandler.readObjectFromFile(leaderboardFilename);

        if (leaderboardsData == null) {
            leaderboardsData = new ArrayList<>();
        }
    }

    public ArrayList<LeaderboardData> getLeaderboardsData() {
        return leaderboardsData;
    }

    public void addUserScore(String username, int score) {
        leaderboardsData.add(new LeaderboardData(username, score));
        Collections.sort(leaderboardsData);
        FileHandler.writeObjectToFile(leaderboardsData, leaderboardFilename);
    }
}
