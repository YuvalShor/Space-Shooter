package com.spaceshooter.model;

import com.spaceshooter.view.ImageHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Laserbeam extends SpaceObject {
    public static Image image;
    private BufferedImage laserbeamImage;

    public Laserbeam(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.moveY = -5;
        laserbeamImage = ImageHandler.getLaserbeamImage();
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(laserbeamImage, this.leftBorder(), this.topBorder(), null);
    }

    @Override
    public void onTick() {
        this.y += this.moveY;
    }
}