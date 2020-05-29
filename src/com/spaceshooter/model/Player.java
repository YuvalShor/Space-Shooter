package com.spaceshooter.model;

import com.spaceshooter.controller.LaserbeamManager;

import java.awt.*;
import java.util.List;

public class Player {
    private static int count;
    private int playerScore;
    private int playerHealth;
    private LaserbeamManager playerLaserbeamManager;
    private PlayerSpaceship playerSpaceship;
    private static final Player instance = new Player();

    private Player() {
        playerSpaceship = PlayerSpaceship.createInstance();
        playerScore = 0;
        playerHealth = 100;
        playerLaserbeamManager = new LaserbeamManager();
    }

    public static Player createInstance(){
        return instance;
    }

    public void onTick() {
        playerSpaceship.onTick();
        playerLaserbeamManager.onTick();
    }

    public void draw(Graphics graphics) {
        playerSpaceship.draw(graphics);
        playerLaserbeamManager.draw(graphics);
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

        Laserbeam firstLaserbeamToAdd = (Laserbeam)Game.creator.createSpaceObject("playerlaserbeam", laserbeamX, laserbeamY);

        laserbeamX = playerSpaceship.rightBorder() - 8;

        Laserbeam secondLaserbeanToAdd = (Laserbeam)Game.creator.createSpaceObject("playerlaserbeam", laserbeamX, laserbeamY);

        playerLaserbeamManager.addLaserbeam(firstLaserbeamToAdd);
        playerLaserbeamManager.addLaserbeam(secondLaserbeanToAdd);
    }

    public List<Laserbeam> getPlayerLaserbeamManager() {
        return this.playerLaserbeamManager.getLasers();
    }

    public LaserbeamManager getLaserbeamManager() {
        return this.playerLaserbeamManager;
    }
}
