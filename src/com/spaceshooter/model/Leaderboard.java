package com.spaceshooter.model;

import java.awt.*;
import java.util.*;
import java.lang.*;
import java.util.List;

public class Leaderboard {
    private String leaderboardFilename;
    private static HashMap<String,Integer> leaderboardsUsers = new HashMap<String, Integer>();

    public Leaderboard() {
        leaderboardsUsers.put("Eliad",250);
        leaderboardsUsers.put("Yuval",350);
        leaderboardsUsers.put("Oron",1450);
        leaderboardsUsers.put("Alex",550);
        leaderboardsUsers.put("a",150);
        leaderboardsUsers.put("b",170);
        leaderboardsUsers.put("c",0);
        leaderboardsUsers.put("d",15);
        leaderboardsUsers.put("bb",150);
        leaderboardsUsers.put("dsad",150);
        leaderboardsUsers.put("aqwe",150);
        leaderboardsUsers.put("vcxvr",150);
        leaderboardsUsers.put("vcbcvb",150);
        leaderboardsUsers.put("Valorant",150);
        leaderboardsUsers = sortByValue(leaderboardsUsers);
        System.out.println(leaderboardsUsers.toString());
    }

    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
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

    public static HashMap<String,Integer> getLeaderboardsUsers() {
        return leaderboardsUsers;
    }

    public void draw(Graphics graphics){

    }

    public void updateLeaderboard(int score){

    }
}
