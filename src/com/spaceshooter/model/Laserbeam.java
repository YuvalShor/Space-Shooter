package com.spaceshooter.model;

import com.spaceshooter.model.interfaces.ObjectObserver;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Laserbeam extends SpaceObject {
    private BufferedImage laserbeamImage;

    public Laserbeam(float x, float y, int width, int height, ObjectObserver observer) {
        super(x, y, width, height, observer);
        this.moveY = -5;
    }

    @Override
    public void draw(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;

        AffineTransform affineTransform = new AffineTransform();

        affineTransform.translate(this.leftBorder(), this.topBorder());
        affineTransform.scale(1, 1);
        g2d.drawImage(laserbeamImage, affineTransform, null);
    }

    @Override
    public void onTick() {
        this.x += this.moveX;
        this.y += this.moveY;

        if (!isWithinBorders()) {
            notifyObserver();
        }
    }

    @Override
    public void notifyObserver() {
        this.observer.objectStateChanged(this);
    }

    public void calculateDirection(float x, float y) {
        double distanceX = x - this.x;
        double distanceY = y - this.y;
        double realDistance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);

        this.moveX = (float) (distanceX / realDistance);
        this.moveY = (float) (distanceY / realDistance);
    }

    public void setImage(BufferedImage imageToSet) {
        this.laserbeamImage = imageToSet;
    }
}