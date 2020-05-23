package com.spaceshooter.model;

import java.awt.*;

public class Star{
    private List<Star> starsList=new Arraylist<>();

    public Star(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
  
    @Override
    public void draw(Graphics graphics) {

    }

    @Override
    public void onTick() {

    }
 
    public void addStar(Star star) {
        this.starsList.add(star);
    }
  
    private void restartPosition() {

    }

    private void spark() {

    }

    private void fade() {

    }
}