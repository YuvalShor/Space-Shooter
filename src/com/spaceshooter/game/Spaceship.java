package com.spaceshooter.game;

import java.awt.*;

public class Spaceship extends SpaceObject{
    public Spaceship(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(new Color(255, 0, 0));
        graphics2D.fillRect(this.left(), this.top(),this.width, this.height);
    }
}
