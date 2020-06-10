package com.spaceshooter.model;

import com.spaceshooter.view.ImageHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerSpaceship extends SpaceObject{
    public static int count;
    private static PlayerSpaceship instance;
    private BufferedImage playerSpaceshipImage;

    private PlayerSpaceship(int x, int y, int width, int height) {
        super(x, y, width, height);
        count = 1;
        playerSpaceshipImage = ImageHandler.getPlayerSpaceshipImage();
    }

    @Override
    public void  draw(Graphics graphics) {
        graphics.drawImage(this.playerSpaceshipImage, (int) this.leftBorder(), (int) this.topBorder(), null);
    }

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