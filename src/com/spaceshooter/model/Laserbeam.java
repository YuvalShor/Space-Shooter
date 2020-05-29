package com.spaceshooter.model;

import com.spaceshooter.controller.ExplosionManager;
import com.spaceshooter.view.ImageHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Laserbeam extends SpaceObject {
    public static Image image;
    private BufferedImage laserbeamImage;

    public Laserbeam(int x, int y, int width, int height, ObjectObserver observer) {
        super(x, y, width, height, observer);
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

        if(this.topBorder() < 0){
            notifyObserver();
        }
    }

    @Override
    public void notifyObserver() {
        this.observer.objectStateChanged(this);
    }
}