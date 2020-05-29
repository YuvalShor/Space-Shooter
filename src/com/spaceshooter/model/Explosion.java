package com.spaceshooter.model;

import com.spaceshooter.controller.ExplosionManager;
import com.spaceshooter.view.ImageHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Explosion extends SpaceObject{

    private BufferedImage[] explosionImages;
    private int currentFrame;

    public Explosion(int x, int y, int width, int height, ObjectObserver observer) {
        super(x, y, width, height, observer);
        currentFrame = -1;
        explosionImages = ImageHandler.getExplosionAnimation();
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(this.explosionImages[currentFrame], this.leftBorder(), this.topBorder(), null);
    }

    @Override
    public void onTick() {
        currentFrame++;

        if(currentFrame >= explosionImages.length){
            notifyObserver();
        }
    }

    @Override
    public void notifyObserver() {
        observer.objectStateChanged(this);
    }
}
