package com.spaceshooter.controller;

import com.spaceshooter.model.EnemySpaceship;
import com.spaceshooter.model.Laserbeam;
import com.spaceshooter.model.ObjectObserver;
import com.spaceshooter.model.ObservableObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EnemySpaceshipManager implements ObjectObserver {
    private List<EnemySpaceship> enemySpaceships;
    private LaserbeamManager enemyLaserbeamManager;

    public EnemySpaceshipManager() {
        this.enemySpaceships = new ArrayList<EnemySpaceship>();
        this.enemyLaserbeamManager = new LaserbeamManager();
    }

    public void onTick() {

    }

    public void draw(Graphics graphics) {

    }

    public void addEnemySpaceship(EnemySpaceship spaceship) {

    }

    public void destroyEnemySpaceship(EnemySpaceship spaceship) {

    }

    public List<Laserbeam> getEnemyLasers() {
        return this.enemyLaserbeamManager.getLasers();
    }

    public LaserbeamManager getEnemyLaserbeamManager() {
        return this.enemyLaserbeamManager;
    }

    @Override
    public void objectStateChanged(ObservableObject observable) {

    }
}