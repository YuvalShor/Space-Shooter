package com.spaceshooter.controller;

import com.spaceshooter.controller.FileHandler;
import com.spaceshooter.model.LeaderboardData;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.List;

public class LeaderboardsManager {
    final private String leaderboardFilename = "scores.dat";
    private ArrayList<LeaderboardData> leaderboardsData;

    public LeaderboardsManager() {
        leaderboardsData = (ArrayList<LeaderboardData>) FileHandler.readObjectFromFile(leaderboardFilename);

        if(leaderboardsData == null){
            leaderboardsData = new ArrayList<>();
        }
    }

    public ArrayList<LeaderboardData> getLeaderboardsData() {
        return leaderboardsData;
    }

    public void addUserScore(String username, int score){
        leaderboardsData.add(new LeaderboardData(username, score));
        Collections.sort(leaderboardsData);
        FileHandler.writeObjectToFile(leaderboardsData, leaderboardFilename);
    }
}
