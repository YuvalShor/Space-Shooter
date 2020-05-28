package com.spaceshooter.model;

import com.spaceshooter.controller.LaserbeamManager;

import java.awt.*;
import java.util.ArrayList;

public class Player {
    private static int count;
    private int playerScore;
    private int playerHealth;
    private LaserbeamManager playerLasers;
    private PlayerSpaceship playerSpaceship;
    private static final Player instance = new Player();

    private Player() {
        playerSpaceship = PlayerSpaceship.createInstance();
        playerScore = 0;
        playerHealth = 100;
        playerLasers = new LaserbeamManager();
    }

    public static Player createInstance(){
        return instance;
    }

    public void onTick() {
        playerSpaceship.onTick();
        playerLasers.onTick();
    }

    public void draw(Graphics graphics) {
        playerSpaceship.draw(graphics);
        playerLasers.draw(graphics);
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void updateScore(){

    }

    public void updateSpaceshipPosition(int playerSpaceshipX,int playerSpaceshipY){
        playerSpaceship.setX(playerSpaceshipX);
        playerSpaceship.setY(playerSpaceshipY);
        playerSpaceship.onTick();
    }

    public void addLaserbeam(Laserbeam laserbeam){

    }

    public void playerMouseClicked() {
        int laserbeamX = playerSpaceship.leftBorder() + 8;
        int laserbeamY = playerSpaceship.topBorder();

        Laserbeam firstLaserbeamToAdd = new Laserbeam(laserbeamX, laserbeamY, 3, 32);

        laserbeamX = playerSpaceship.rightBorder() - 8;

        Laserbeam secondLaserbeanToAdd = new Laserbeam(laserbeamX, laserbeamY, 3, 32);

        playerLasers.addLaserbeam(firstLaserbeamToAdd);
        playerLasers.addLaserbeam(secondLaserbeanToAdd);
    }
}
