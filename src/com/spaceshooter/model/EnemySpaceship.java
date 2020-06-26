package com.spaceshooter.model;

import com.spaceshooter.view.ImageHandler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class EnemySpaceship extends SpaceObject{
    public BufferedImage enemySpaceshipImage;
    protected int health;
    protected final int MAX_HEALTH;
    public EnemySpaceship(float x, float y, int width, int height, ObjectObserver observer) {
        super(x, y, width, height, observer);
        this.enemySpaceshipImage = ImageHandler.getEnemySpaceshipImage();
        this.MAX_HEALTH = 100;
        this.health = MAX_HEALTH;
    }

    protected EnemySpaceship(float x, float y, int width, int height, ObjectObserver observer, int maxHealth){
        super(x, y, width, height, observer);
        this.MAX_HEALTH = maxHealth;
    }
    @Override
    public void draw(Graphics graphics) {
        float healthRatio = this.health / (float)this.MAX_HEALTH;
        float healthBarFillWidth = healthRatio * this.width;

        graphics.setColor(Color.RED);
        graphics.drawRect((int) this.leftBorder(), (int) this.topBorder() - 15, this.width, 8);
        graphics.fillRect((int) this.leftBorder(), (int) this.topBorder() - 15, (int) healthBarFillWidth, 8);
        graphics.drawImage(enemySpaceshipImage, (int) this.leftBorder(), (int) this.topBorder(), null);
    }

    @Override
    public void onTick() {
        if(this.health <= 0){
            notifyObserver();
            Game.creator.createSpaceObject("smallexplosion", this.x, this.y);
        }

        Random random = new Random();

        if(random.nextInt(1000) < 10){
            Game.creator.createSpaceObject("enemylaserbeam", this.x, this.y);
        }
    }

    public int getHealth() {
        return health;
    }

    @Override
    public void notifyObserver() {
        observer.objectStateChanged(this);
    }
    
    public void hit(int hitpoints){
        this.health -= hitpoints;
    }
}