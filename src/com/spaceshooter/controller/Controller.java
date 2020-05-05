package com.spaceshooter.controller;

import com.spaceshooter.model.Game;
import com.spaceshooter.view.GameWindow;

import java.awt.*;

public class Controller implements Runnable{
    private GameWindow gameWindow;
    private Game game;

    @Override
    public void run() {
        Graphics graphics = gameWindow.getContentPane().getGraphics();

        while(true){
            game.onTick();
            game.checkCollisions();
            game.draw(graphics);
        }

    }
}
