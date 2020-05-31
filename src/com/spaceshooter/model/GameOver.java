package com.spaceshooter.model;

import java.awt.*;

public class GameOver{

    Leaderboard leaderboard;
    String gameOver;
    Font textFont;

    public GameOver(){
        leaderboard = new Leaderboard();
        gameOver = "Game over!";
        textFont = new Font("Arial", Font.BOLD, 100);
    }

    public void onTick(){

    }

    public void draw(Graphics graphics){
        graphics.setFont(textFont);
        FontMetrics fontMetrics = graphics.getFontMetrics();
        int textX = (Game.WIDTH - fontMetrics.stringWidth(gameOver)) / 2;
        int textY = ((Game.HEIGHT - fontMetrics.getHeight()) / 2) + fontMetrics.getAscent();
        graphics.drawString("Game over", textX, textY);
        leaderboard.draw(graphics);
    }
}
