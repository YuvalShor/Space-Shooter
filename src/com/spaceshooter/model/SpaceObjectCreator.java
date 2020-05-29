package com.spaceshooter.model;

import com.spaceshooter.controller.EnemySpaceshipManager;
import com.spaceshooter.controller.ExplosionManager;
import com.spaceshooter.controller.LaserbeamManager;

public class SpaceObjectCreator implements SpaceObjectFactory {

    private final int laserbeamWidth = 3;
    private final int laserbeamHeight = 32;
    private final int smallStarWidth = 2;
    private final int smallStarHeight = 2;
    private final int bigStarWidth = 16;
    private final int bigStarHeight = 16;
    private final int enemySpaceshipWidth = 0;
    private final int enemySpaceshipHeight = 0;
    private final int explosionWidth = 100;
    private final int explosionHeight = 100;
    private final boolean isStarSmall = true;
    private  EnemySpaceshipManager enemySpaceshipManager;
    private  ExplosionManager explosionManager;
    private  LaserbeamManager playerLaserbeamManager;
    private  LaserbeamManager enemyLaserbeamManager;

    @Override
    public SpaceObject createSpaceObject(String nameOfObject, int objectX, int objectY) {
        SpaceObject spaceObjectToCreate;

        if(nameOfObject == "playerspaceship"){
            spaceObjectToCreate = createPlayerSpaceship();
        }
        else if(nameOfObject == "enemyspaceship"){
            spaceObjectToCreate = createEnemySpaceship(objectX, objectY);
        }
        else if(nameOfObject == "enemylaserbeam"){
            spaceObjectToCreate = createEnemyLaserbeam(objectX, objectY);
        }
        else if(nameOfObject == "playerlaserbeam"){
            spaceObjectToCreate = createPlayerLaserbeam(objectX, objectY);
        }
        else if(nameOfObject == "smallstar"){
            spaceObjectToCreate = createSmallStar(objectX, objectY);
        }
        else if(nameOfObject == "bigstar"){
            spaceObjectToCreate = createBigStar(objectX, objectY);
        }
        else if(nameOfObject == "explosion"){
            spaceObjectToCreate = createExplosion(objectX, objectY);
        }
        else{
            throw new IllegalArgumentException("Object name does not exist");
        }

        return spaceObjectToCreate;
    }

    private Star createSmallStar(int starX, int starY){
        return new Star(starX, starY, smallStarWidth, smallStarHeight, this.isStarSmall);
    }

    private Star createBigStar(int starX, int starY){
        return new Star(starX, starY, bigStarWidth, bigStarHeight, !this.isStarSmall);
    }

    private PlayerSpaceship createPlayerSpaceship(){
        return PlayerSpaceship.createInstance();
    }

    private Laserbeam createPlayerLaserbeam(int laserX, int laserY){
        return new Laserbeam(laserX, laserY, laserbeamWidth, laserbeamHeight, playerLaserbeamManager);
    }

    private Laserbeam createEnemyLaserbeam(int laserX, int laserY){
        return new Laserbeam(laserX, laserY, laserbeamWidth, laserbeamHeight, enemyLaserbeamManager);
    }

    private EnemySpaceship createEnemySpaceship(int enemyX, int enemyY){
        // to implement
        return null;
    }

    private Explosion createExplosion(int explosionX, int explosionY){
        return new Explosion(explosionX, explosionY, explosionWidth, explosionHeight, explosionManager);
    }

    public void setEnemyManager(EnemySpaceshipManager enemySpaceshipManager) {
        this.enemySpaceshipManager = enemySpaceshipManager;
    }

    public void setExplosionManager(ExplosionManager explosionManager) {
        this.explosionManager = explosionManager;
    }

    public void setPlayerLaserbeamManager(LaserbeamManager laserbeamManager) {
        this.playerLaserbeamManager = laserbeamManager;
    }

    public void setEnemyLaserbeamManager(LaserbeamManager enemyLaserbeamManager) {
        this.enemyLaserbeamManager = enemyLaserbeamManager;
    }
}
