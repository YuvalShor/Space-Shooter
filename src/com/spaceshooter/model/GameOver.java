package com.spaceshooter.model;

import com.spaceshooter.controller.LeaderboardsManager;

import java.awt.*;

public class GameOver{
    LeaderboardsManager leaderboardsManager;
    String gameOver;
    String returnToMainMenuText;
    Font gameOverFont;
    Font mainMenuMessageFont;

    public GameOver(){
        leaderboardsManager = new LeaderboardsManager();
        gameOver = "Game over!";
        returnToMainMenuText = "Press enter to update the leaderboard and get back to the menu...";
        gameOverFont = new Font("Arial", Font.BOLD, 100);
        mainMenuMessageFont = new Font("Arial", Font.BOLD, 20);
    }

    public void onTick(){

    }

    public void draw(Graphics graphics){
        graphics.setFont(gameOverFont);
        FontMetrics fontMetrics = graphics.getFontMetrics();
        int textX = (Game.WIDTH - fontMetrics.stringWidth(gameOver)) / 2;
        int textY = ((Game.HEIGHT - fontMetrics.getHeight()) / 2) + fontMetrics.getAscent();
        graphics.drawString("Game over", textX, textY);

        graphics.setFont(mainMenuMessageFont);
        graphics.setColor(Color.GREEN);
        fontMetrics = graphics.getFontMetrics();
        textX = (Game.WIDTH - fontMetrics.stringWidth(returnToMainMenuText)) / 2;
        textY = Game.HEIGHT - Game.HEIGHT / 4;
        graphics.drawString(returnToMainMenuText, textX, textY);
    }
}
