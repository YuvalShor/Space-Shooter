package com.spaceshooter.model;

import java.awt.*;

public class PlayerSpaceship extends SpaceObject{
    public static int count;
    private static PlayerSpaceship instance;
    private Image image;

    private PlayerSpaceship(int x, int y, int width, int height) {
        super(x, y, width, height);
        count = 1;
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

    public static synchronized PlayerSpaceship createInstance(int x, int y, int width, int height) {
        if (count == 1) {
            return instance;
        }
        else {
            return new PlayerSpaceship(x, y, width, height);
        }
    }

    private void fireLaserbeam() {

    }
}