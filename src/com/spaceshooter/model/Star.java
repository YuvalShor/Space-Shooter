package com.spaceshooter.model;

import com.spaceshooter.view.BufferedImageLoader;
import com.spaceshooter.view.ImageHandler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Star extends SpaceObject{
    private static BufferedImage starImage;

    public Star(int x, int y, int width, int height) {
        super(x, y, width, height);
        starImage = ImageHandler.getStarImage();

        this.moveY = 3; // speed of fall
    }
  
    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(starImage, this.leftBorder(), this.topBorder(), null);
    }

    @Override
    public void onTick() {
        this.y += this.moveY;

        if(this.y > Game.HEIGHT){
            restartPosition();
        }
    }

    private void restartPosition() {
        Random random = new Random();
        this.x = random.nextInt(Game.WIDTH);
        this.y = 0;
    }

    private void spark() {

    }

    private void fade() {

    }
}