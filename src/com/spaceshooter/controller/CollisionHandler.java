package com.spaceshooter.controller;
import com.spaceshooter.model.Laserbeam;
import com.spaceshooter.model.Player;

import java.util.List;

public class CollisionHandler {
    private EnemySpaceshipManager enemyManager;
    private List<Laserbeam> enemyLasers;
    private List<Laserbeam> playerLasers;
    private Player player;
    private ExplosionManager explosionManager;

    public CollisionHandler(EnemySpaceshipManager enemyManager, Player player, ExplosionManager explosionManager) {
        this.enemyManager = enemyManager;
        this.player = player;
        this.explosionManager = explosionManager;
        this.playerLasers =  player.getPlayerLaserbeamManager();
        this.enemyLasers = enemyManager.getEnemyLasers();
    }

    public void onTick() {

    }
}
