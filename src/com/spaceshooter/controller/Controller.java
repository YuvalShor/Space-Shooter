package com.spaceshooter.controller;

import com.spaceshooter.model.Game;
import com.spaceshooter.model.GameState;
import com.spaceshooter.view.GameWindow;
import com.spaceshooter.view.LoginRegisterFrame;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Controller implements Runnable{
    private GameWindow gameWindow;
    private LoginRegisterFrame loginRegisterFrame;
    private Game game;
    private Thread thread;

    public Controller(LoginRegisterFrame loginRegisterFrame, Game game) {
        this.loginRegisterFrame = loginRegisterFrame;
        this.game = game;
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        game.gameState = GameState.GameRunning;
    }

    @Override
    public void run() {
        BufferStrategy bufferStrategy = gameWindow.getGamePanelCanvasBufferStrategy();
        game.setStartTime(System.currentTimeMillis());
        long lastTime;
        double amountOfTicks = 60.0;
        double waitingTime = (1000000000) / amountOfTicks;
        long difference;

        while(game.isGameRunning()){
            lastTime = System.nanoTime();

            // prepare the ground
            Graphics graphics = bufferStrategy.getDrawGraphics();

            // update game
            game.update(graphics);

            // dispose of graphics and show
            graphics.dispose();
            bufferStrategy.show();

            long now = System.nanoTime();
            difference = now - lastTime;
            if(difference < waitingTime){
                try {
                    thread.sleep((long)((waitingTime - difference)/1000000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void updatePlayerPosition(int playerX, int playerY){
        game.updatePlayerPosition(playerX, playerY);
    }

    public void exitGame(){

    }

    public void playerMouseClicked() {
        game.playerMouseClicked();
    }

    public void register(String username, String password) {
        SecurityManager.register(username, password);
    }

    public void startGameWindow() {
        this.gameWindow = new GameWindow(Game.WIDTH, Game.HEIGHT);
        this.gameWindow.setController(this);
    }

    public boolean login(String username, String password) throws Exception {
        return SecurityManager.login(username, password);
    }
}