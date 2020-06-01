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

    public void createEnemies(int numberOfEnemies) {
        int enemyWidth = Game.creator.getEnemySpaceshipWidth();
        int enemyHeight = Game.creator.getEnemySpaceshipHeight();
        int enemyDistance = (Game.WIDTH - enemyWidth)/numberOfEnemies;

        for (int i = 0; i < numberOfEnemies; i++) {
            Game.creator.createSpaceObject("enemyspaceship",
                    i * enemyDistance + enemyWidth, Game.HEIGHT / 4);
        }
    }

    public List<EnemySpaceship> getEnemySpaceships(){
        return this.enemySpaceships;
    }

    public boolean isFleetAnnihilated(){
        return this.enemySpaceships.size() == 0;
    }

    public void clear() {
        this.enemySpaceships.clear();
        this.enemyLaserbeamManager.clear();
    }
}