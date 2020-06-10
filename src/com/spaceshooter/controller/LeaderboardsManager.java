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
        /*leaderboardsData.put("Eliad",250);
        leaderboardsData.put("Yuval",350);
        leaderboardsData.put("Oron",1450);
        leaderboardsData.put("Alex",550);
        leaderboardsData.put("a",150);
        leaderboardsData.put("b",170);
        leaderboardsData.put("c",0);
        leaderboardsData.put("d",15);
        leaderboardsData.put("bb",150);
        leaderboardsData.put("dsad",150);
        leaderboardsData.put("aqwe",150);
        leaderboardsData.put("vcxvr",150);
        leaderboardsData.put("vcbcvb",150);
        leaderboardsData.put("Valorant",150);*/

        try {
            leaderboardsData = (ArrayList<LeaderboardData>) FileHandler.readObjectFromFile(leaderboardFilename);
        } catch (EOFException e) {
            leaderboardsData = new ArrayList<>();
        }
    }

  /*  public ArrayList<LeaderboardData> sortByValue(Map<String, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer>> list =
                new LinkedList<>(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                    Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }

        return temp;
    }
*/
    public ArrayList<LeaderboardData> getLeaderboardsData() {
        return leaderboardsData;
    }

    public void addUserScore(String username, int score){
        leaderboardsData.add(new LeaderboardData(username, score));
        Collections.sort(leaderboardsData);
        FileHandler.writeObjectToFile(leaderboardsData, leaderboardFilename);
    }
}
