package com.spaceshooter.model;

import java.awt.*;

public abstract class SpaceObject {
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
        this.setMoveX(0);
        this.setMoveY(0);
    }

    public int getMoveX() {
        return moveX;
    }

    public void setMoveX(int moveX) {
        this.moveX = moveX;
    }

    public int getMoveY() {
        return moveY;
    }

    public void setMoveY(int moveY) {
        this.moveY = moveY;
    }

    public abstract void draw(Graphics graphics);
    public abstract void onTick();

    public int leftBorder(){
        return this.x - this.width / 2;
    }

    public int rightBorder(){
        return this.x + this.width / 2;
    }

    public int topBorder(){
        return this.y - this.height / 2;
    }

    public int bottomBorder(){
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