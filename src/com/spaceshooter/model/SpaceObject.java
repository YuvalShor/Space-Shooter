package com.spaceshooter.model;

import java.awt.*;

public abstract class SpaceObject implements ObservableObject {
    protected float x;
    protected float y;
    protected int width;
    protected int height;
    protected float moveX;
    protected float moveY;
    protected ObjectObserver observer;

    public SpaceObject(float x, float y, int width, int height) {
        this.setX(x);
        this.setY(y);
        this.setWidth(width);
        this.setHeight(height);
        this.setMoveX(0);
        this.setMoveY(0);
    }

    public SpaceObject(float x, float y, int width, int height, ObjectObserver observer) {
        this(x, y, width, height);
        this.observer = observer;
    }

    public float getMoveX() {
        return moveX;
    }

    public void setMoveX(float moveX) {
        this.moveX = moveX;
    }

    public float getMoveY() {
        return moveY;
    }

    public void setMoveY(float moveY) {
        this.moveY = moveY;
    }

    public abstract  void draw(Graphics graphics);
    public abstract  void onTick();

    public float leftBorder(){
        return this.x - this.width / 2;
    }

    public float rightBorder(){
        return this.x + this.width / 2;
    }

    public float topBorder(){
        return this.y - this.height / 2;
    }

    public float bottomBorder(){
        return this.y + this.height / 2;
    }

    public float getX() {
        return x;
    }

    public  void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public  void setY(float y) {
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

    public boolean isWithinBorders(){
        boolean isWithinBorders = true;

        if(this.leftBorder() < 0){
            isWithinBorders = false;
        }

        if(this.rightBorder() > Game.WIDTH){
            isWithinBorders = false;
        }

        if(this.topBorder() < 0){
            isWithinBorders = false;
        }

        if(this.bottomBorder() > Game.HEIGHT){
            isWithinBorders = false;
        }

        return isWithinBorders;
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