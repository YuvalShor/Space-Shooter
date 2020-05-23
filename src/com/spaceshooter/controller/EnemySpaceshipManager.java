package com.spaceshooter.controller;

import com.spaceshooter.model.EnemySpaceship;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EnemySpaceshipManager {
    public List<EnemySpaceship> enemySpaceships;
    private LaserbeamManager enemyLasers;

    public EnemySpaceshipManager(LaserbeamManager enemyLasers) {
        this.enemySpaceships = new ArrayList<EnemySpaceship>();
        this.enemyLasers = enemyLasers;
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
