package com.spaceshooter.model;

import com.spaceshooter.controller.LaserbeamManager;

import java.awt.*;

public class Player {
    private static int count;
    private int playerScore;
    private int playerHealth;
    private LaserbeamManager playerLasers;
    private PlayerSpaceship playerSpaceship;
    private static final Player instance = new Player();

    private Player() { }

    public static Player createInstance(){
        return instance;
    }

    public void onTick() {

    }

    public void draw(Graphics graphics) {

    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void updateScore(){

    }

    private void updateSpaceshipPosition(int x,int y){

    }

    private void addLaserbeam(){

    }
}
