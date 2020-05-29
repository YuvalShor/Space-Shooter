package com.spaceshooter.model;

import java.awt.*;

public class EnemySpaceship extends SpaceObject{
    public static Image image;
    private int health;

    public EnemySpaceship(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(Graphics graphics) {

    }

    @Override
    public void onTick() {

    }

    private void fireLaserbeam() {

    }

    public int getHealth() {
        return 0;
    }

    public void setHealth(int health) {

    }

    @Override
    public void notifyObserver() {

    }
}