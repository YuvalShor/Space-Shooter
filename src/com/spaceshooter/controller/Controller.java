package com.spaceshooter.controller;

import com.spaceshooter.model.Game;
import com.spaceshooter.view.GameWindow;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Controller implements Runnable{
    private GameWindow gameWindow;
    private Game game;

    @Override
    public void run() {
        BufferStrategy bufferStrategy = gameWindow.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();

        while(true){
            game.onTick();
            game.checkCollisions();
            game.draw(graphics);
        }

    }
}
