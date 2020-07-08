package com.spaceshooter.controller;

import com.spaceshooter.model.EnemySpaceship;
import com.spaceshooter.model.Laserbeam;
import com.spaceshooter.model.Player;
import com.spaceshooter.model.PlayerSpaceship;

public class CollisionHandler {
    private final EnemySpaceshipManager enemyManager;
    private final Player player;

    public CollisionHandler(EnemySpaceshipManager enemyManager, Player player) {
        this.enemyManager = enemyManager;
        this.player = player;
    }

    public void onTick() {
        LaserbeamManager playerLaserbeamManager = player.getLaserbeamManager();
        LaserbeamManager enemyLaserbeamsManager = enemyManager.getEnemyLaserbeamManager();
        Laserbeam[] playerLaserbeams = playerLaserbeamManager.getLasers().toArray(
                new Laserbeam[playerLaserbeamManager.getLasers().size()]);
        Laserbeam[] enemyLaserbeams = enemyLaserbeamsManager.getLasers().toArray(
                new Laserbeam[enemyLaserbeamsManager.getLasers().size()]);

        // player laserbeams intersection with enemy spaceships
        for (Laserbeam laser : playerLaserbeams) {

            for (EnemySpaceship enemy : enemyManager.getEnemySpaceships()) {
                if (laser.intersects(enemy)) {
                    enemy.hit(20);
                    laser.notifyObserver();
                }
            }
        }

        PlayerSpaceship playerSpaceship = player.getPlayerSpaceship();

        // enemy laserbeams intersection with player spaceship
        for (Laserbeam laser : enemyLaserbeams) {
            if (laser.intersects(playerSpaceship)) {
                player.hit(2);
                enemyLaserbeamsManager.remove(laser);
            }
        }

        // enemy spaceships intersection with player spaceship
        for (EnemySpaceship enemySpaceship : enemyManager.getEnemySpaceships()) {
            if (enemySpaceship.intersects(playerSpaceship)) {
                player.hit(25);
                enemySpaceship.hit(100);
            }
        }
    }
}
