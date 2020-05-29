package com.spaceshooter.model;

import java.awt.*;

public abstract class SpaceObject implements ObservableObject {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int moveX;
    protected int moveY;
    protected ObjectObserver observer;

    public SpaceObject(int x, int y, int width, int height) {
        this.setX(x);
        this.setY(y);
        this.setWidth(width);
        this.setHeight(height);
        this.setMoveX(0);
        this.setMoveY(0);
    }

    public SpaceObject(int x, int y, int width, int height, ObjectObserver observer) {
        this(x, y, width, height);
        this.observer = observer;
    }

    public SpaceObject(int x, int y){
        this.setX(x);
        this.setY(y);
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

    public abstract  void draw(Graphics graphics);
    public abstract  void onTick();

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

    public  void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public  void setY(int y) {
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

    protected void assureObjectWithinBorders(){
        if(this.leftBorder() < 0){
            this.x = 0 + this.width/2;
        }

        if(this.rightBorder() > Game.WIDTH){
            this.x = Game.WIDTH - this.width/2;
        }

        if(this.topBorder() < 0){
            this.y = 0 + this.height/2;
        }

        if(this.bottomBorder() > Game.HEIGHT){
            this.y = Game.HEIGHT - this.height/2;
        }
    }

    public boolean intersects(SpaceObject other){
        boolean areObjectsIntersecting = false;

        // interval intersection with x
        if(this.rightBorder() >= other.leftBorder() && this.leftBorder() <= other.rightBorder()){

            // interval intersection with y
            if(this.bottomBorder() >= other.topBorder() && this.topBorder() <= other.bottomBorder()){
                areObjectsIntersecting = true;
            }
        }

        return areObjectsIntersecting;
    }
}