package com.spaceshooter.model;

import java.awt.*;

public class Star{
    private List<Star> starsList=new Arraylist<>();

    public Star(int x, int y, int width, int height) {
        super(x, y, width, height);
    }


    public void addStar(Star star){
        this.starsList.add(star);

    }
    @Override
    public void draw(Graphics graphics) {

    }

    @Override
    public void onTick() {

    }

}
