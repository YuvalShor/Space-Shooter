package com.spaceshooter.model;

import com.spaceshooter.view.ImageHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Explosion extends SpaceObject{

    private BufferedImage[] explosionAnimation;
    private int currentFrame;
//    private int frames;

    public Explosion(float x, float y, int width, int height, ObjectObserver observer) {
        super(x, y, width, height, observer);
        currentFrame = -1;
        explosionAnimation = ImageHandler.getSmallExplosionAnimation();
//        frames = 0;
    }

    @Override
    public void draw(Graphics graphics) {

        graphics.drawImage(this.explosionAnimation[currentFrame], (int) this.leftBorder(), (int) this.topBorder(),
                    null);

    }

    @Override
    public void onTick() {

//        frames = (frames + 1) % 60;
        currentFrame++;

        if(currentFrame >= explosionAnimation.length){
            notifyObserver();
        }
    }

    @Override
    public void notifyObserver() {
        observer.objectStateChanged(this);
    }

    public void setAnimation(BufferedImage[] smallExplosionAnimation) {
        this.explosionAnimation = smallExplosionAnimation;
    }
}
