package com.spaceshooter.controller;

import com.spaceshooter.model.Player;

public class CollisionHandler {
    private EnemySpaceshipManager enemyManager;
    private LaserbeamManager enemyLasers;
    private LaserbeamManager playerLasers;
    private Player player;

    public CollisionHandler(EnemySpaceshipManager enemyManager, Player player) {
        this.enemyManager = enemyManager;
        this.player = player;
    }

    public void onTick() {

    }
}
