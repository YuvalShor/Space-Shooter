package com.spaceshooter.model;

import java.awt.*;

public class HUD {
    private Player player;
    private Game game;
    private Font font;

    public HUD(Player player, Game game) {
        this.player = player;
        this.game = game;
        font = new Font("Arial", Font.BOLD, 30);
    }

    public void draw(Graphics graphics){
        drawPlayerHealthBar(graphics);

        graphics.setFont(font);
        graphics.setColor(Color.WHITE);

        String levelMessage;
        if(game.getLevel() <= 10){
            levelMessage = "Level: " + game.getLevel();
        }
        else{
            levelMessage = "Level: BOSS";
        }
        FontMetrics fontMetrics = graphics.getFontMetrics();
        int messageX = Game.WIDTH - fontMetrics.stringWidth(levelMessage) - 30;
        int messageY = fontMetrics.getHeight();
        graphics.drawString(levelMessage, messageX, messageY);

        graphics.drawString("Score: " + player.getPlayerScore(), 30, messageY);
    }

    private void drawPlayerHealthBar(Graphics graphics) {
        graphics.setColor(Color.GREEN);
        graphics.fillRoundRect(30, Game.HEIGHT - 30, player.getHealth(), 15, 15, 30);
        graphics.setColor(Color.BLUE);
        graphics.drawRoundRect(30, Game.HEIGHT - 30, 100, 15, 15, 30);
    }
}
