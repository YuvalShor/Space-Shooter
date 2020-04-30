package com.spaceshooter.game;

public class SpaceObject {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int moveX;
    protected int moveY;

    public SpaceObject(int x, int y, int width, int height) {
        this.setX(x);
        this.setY(y);
        this.setWidth(width);
        this.setHeight(height);
    }

    public int left(){
        return this.x - this.width / 2;
    }

    public int right(){
        return this.x + this.width / 2;
    }

    public int top(){
        return this.y - this.height / 2;
    }

    public int bottom(){
        return this.y + this.height / 2;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}