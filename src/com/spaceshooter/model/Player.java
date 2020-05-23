package com.spaceshooter.model;

import com.spaceshooter.controller.LaserbeamManager;

import java.awt.*;

public class Player {
    private static int count;
    private int playerScore;
    private int playerHealth;
    private LaserbeamManager playerLasers;
    private PlayerSpaceship playerSpaceship;
    private Player instance;

    private Player() {

    }

    public static createInstance(){
    return Player;
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

    private void updatePlyaerPosition(int x,int y){

    }

    private void addPlayerLaserbeam(){

    }
}
