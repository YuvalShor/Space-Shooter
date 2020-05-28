package com.spaceshooter.model;

import java.awt.*;

public class GameOver{

    Leaderboard leaderboard;

    public GameOver(){

    }

    public void onTick(){

    }

    public void draw(Graphics graphics){
        leaderboard.draw(graphics);
    }
}
