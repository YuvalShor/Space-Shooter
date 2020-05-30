package com.spaceshooter.controller;

import com.spaceshooter.model.*;

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
        EnemySpaceship[] enemySpaceships = this.enemySpaceships.toArray(new EnemySpaceship[this.enemySpaceships.size()]);

        for (EnemySpaceship enemy : enemySpaceships) {
            enemy.onTick();
        }

        this.enemyLaserbeamManager.onTick();
    }

    public void draw(Graphics graphics) {
        EnemySpaceship[] enemySpaceships = this.enemySpaceships.toArray(new EnemySpaceship[this.enemySpaceships.size()]);

        for (EnemySpaceship enemy : enemySpaceships) {
            enemy.draw(graphics);
        }

        this.enemyLaserbeamManager.draw(graphics);
    }

    public void addEnemySpaceship(EnemySpaceship spaceship) {
        this.enemySpaceships.add(spaceship);
    }

    public void removeEnemySpaceship(EnemySpaceship spaceship) {
        this.enemySpaceships.remove(spaceship);
    }

    public List<Laserbeam> getEnemyLasers() {
        return this.enemyLaserbeamManager.getLasers();
    }

    public LaserbeamManager getEnemyLaserbeamManager() {
        return this.enemyLaserbeamManager;
    }

    @Override
    public void objectStateChanged(ObservableObject observable) {
        EnemySpaceship enemySpaceship = (EnemySpaceship) observable;
        removeEnemySpaceship(enemySpaceship);
    }

    public void createEnemies() {
        int enemyWidth = Game.creator.getEnemySpaceshipWidth();
        int enemyHeight = Game.creator.getEnemySpaceshipHeight();

        for (int i = 1; i <= 5; i++) {
            Game.creator.createSpaceObject("enemyspaceship", i*enemyWidth + i*100, 200);
        }
    }

    public List<EnemySpaceship> getEnemySpaceships(){
        return this.enemySpaceships;
    }
}