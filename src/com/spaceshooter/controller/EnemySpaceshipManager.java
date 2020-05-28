package com.spaceshooter.controller;

import com.spaceshooter.model.EnemySpaceship;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class EnemySpaceshipManager {
    private List<EnemySpaceship> enemySpaceships;
    private LaserbeamManager laserbeamManager;

    public EnemySpaceshipManager() {
        this.enemySpaceships = new ArrayList<EnemySpaceship>();
        this.laserbeamManager = new LaserbeamManager();
    }

    public void onTick() {

    }

    public void draw(Graphics graphics) {

    }

    public void addEnemySpaceship(EnemySpaceship spaceship) {

    }

    public void destroyEnemySpaceship(EnemySpaceship spaceship) {

    }
}