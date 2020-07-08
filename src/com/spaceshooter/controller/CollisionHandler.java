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

        // player laserbeams intersection with enemy spaceships
        for (Laserbeam laser : playerLaserbeams) {

            for (EnemySpaceship enemy : enemyManager.getEnemySpaceships()) {
                if(laser.intersects(enemy)){
                    enemy.hit(20);
                    laser.notifyObserver();
                }
            }
        }

        PlayerSpaceship playerSpaceship = player.getPlayerSpaceship();

        // enemy laserbeams intersection with player spaceship
        for (Laserbeam laser : enemyLaserbeams) {
            if(laser.intersects(playerSpaceship)){
                player.hit(2);
                enemyLasers.remove(laser);
            }
        }

        // enemy spaceships intersection with player spaceship
        for (EnemySpaceship enemySpaceship : enemyManager.getEnemySpaceships()) {
            if(enemySpaceship.intersects(playerSpaceship)){
                player.hit(25);
                enemySpaceship.hit(100);
            }
        }
    }
}
