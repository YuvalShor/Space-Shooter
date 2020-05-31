package com.spaceshooter.controller;
import com.spaceshooter.model.*;

import java.util.List;

public class CollisionHandler {
    private EnemySpaceshipManager enemyManager;
    private List<Laserbeam> enemyLasers;
    private List<Laserbeam> playerLasers;
    private Player player;

    public CollisionHandler(EnemySpaceshipManager enemyManager, Player player) {
        this.enemyManager = enemyManager;
        this.player = player;
        this.playerLasers =  player.getPlayerLaserbeamManager();
        this.enemyLasers = enemyManager.getEnemyLasers();
    }

    public void onTick() {
        Laserbeam[] playerLaserbeams = playerLasers.toArray(new Laserbeam[playerLasers.size()]);
        Laserbeam[] enemyLaserbeams = enemyLasers.toArray(new Laserbeam[enemyLasers.size()]);

        for (Laserbeam laser : playerLaserbeams) {

            for (EnemySpaceship enemy : enemyManager.getEnemySpaceships()) {
                if(laser.intersects(enemy)){
                    enemy.hit(5);
                    laser.notifyObserver();
                }
            }
        }

        PlayerSpaceship playerSpaceship = player.getPlayerSpaceship();

        for (Laserbeam laser : enemyLaserbeams) {
            if(laser.intersects(playerSpaceship)){
                player.hit(2);
                enemyLasers.remove(laser);
            }
        }
    }
}
