package com.spaceshooter.model;

import com.spaceshooter.view.ImageHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Explosion extends SpaceObject{

    private BufferedImage[] explosionImages;
    private int currentImageIndex;

    public Explosion(int x, int y) {
        super(x, y);
        this.width = 100;
        this.height = 100;

        currentImageIndex = 0;
        explosionImages = ImageHandler.getExplosionAnimation();
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(this.explosionImages[currentImageIndex], this.leftBorder(), this.topBorder(), null);
    }

    @Override
    public void onTick() {
        currentImageIndex++;
    }

    public int getCurrentImageIndex() {
        return currentImageIndex;
    }

    public boolean isKillable() {
        return currentImageIndex >= explosionImages.length;
    }
}
