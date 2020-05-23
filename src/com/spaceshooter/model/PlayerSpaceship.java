package com.spaceshooter.model;

import java.awt.*;

public class PlayerSpaceship extends SpaceObject{
    private static int count;
    private PlayerSpaceship instance;
    private Image image;

    private PlayerSpaceship(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(new Color(255, 0, 0));
        graphics2D.fillRect(this.leftBorder(), this.topBorder(),this.width, this.height);
    }

    @Override
    public void onTick() {

    }

    public static PlayerSpaceship createInstance() {

    }

    private void fireLaserbeam() {

    }
}