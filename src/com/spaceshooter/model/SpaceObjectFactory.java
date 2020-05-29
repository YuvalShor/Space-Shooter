package com.spaceshooter.model;

public interface SpaceObjectFactory {
    Object  createSpaceObject(String nameOfObject, int objectX, int objectY);
}
