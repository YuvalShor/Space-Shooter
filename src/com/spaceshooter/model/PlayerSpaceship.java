package com.spaceshooter.model;

import com.spaceshooter.view.ImageHandler;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class PlayerSpaceship extends SpaceObject{
    public static int count;
    private static PlayerSpaceship instance;
    private BufferedImage playerSpaceshipImage;
    private int spaceshipSpeed;
    private float toX;
    private float toY;

    private PlayerSpaceship(int x, int y, int width, int height) {
        super(x, y, width, height);
        count = 1;
        this.moveX = 0;
        this.moveY = 0;
        spaceshipSpeed = 1000;
        playerSpaceshipImage = ImageHandler.getPlayerSpaceshipImage();
    }

    @Override
    public void  draw(Graphics graphics) {
        graphics.drawImage(playerSpaceshipImage, (int) this.leftBorder(), (int) this.topBorder(), null);    }

    @Override
    public void onTick() {
        assureObjectWithinBorders();
    }

    public static synchronized PlayerSpaceship createInstance() {
        if (count == 1) {
            return instance;
        }
        else {
            int halfWidthOfScreen = Game.WIDTH/2;
            int bottomOfScreen = Game.HEIGHT - 100;
            int widthOfSpaceship = 75, heightOfSpaceship = 50;
            return new PlayerSpaceship(halfWidthOfScreen, bottomOfScreen, widthOfSpaceship, heightOfSpaceship);
        }
    }

    public void reset(){
        this.x = Game.WIDTH / 2;
        this.y = Game.HEIGHT - 100;
    }

    @Override
    public void notifyObserver() {

    }

}