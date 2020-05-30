package com.spaceshooter.model;

public interface SpaceObjectFactory {
    Object  createSpaceObject(String nameOfObject, float objectX, float objectY);
}
