package com.spaceshooter.model;

import com.spaceshooter.controller.EnemySpaceshipManager;
import com.spaceshooter.controller.ExplosionManager;
import com.spaceshooter.controller.LaserbeamManager;
import com.spaceshooter.view.ImageHandler;

import java.awt.image.BufferedImage;

public class SpaceObjectCreator implements SpaceObjectFactory {

    private final int playerLaserbeamWidth = 3;
    private final int playerLaserbeamHeight = 32;
    private final int enemyEnergyBallWidth = 8;
    private final int enemyEnergyBallHeight = 8;
    private final int starWidth = 2;
    private final int starHeight = 2;
    private final int enemySpaceshipWidth = 60;
    private final int enemySpaceshipHeight = 60;
    private final int bossSpaceshipWidth = 403;
    private final int bossSpaceshipHeight = 286;
    private final int smallExplosionWidth = 100;
    private final int smallExplosionHeight = 100;
    private final int bigExplosionWidth = 256;
    private final int bigExplosionHeight = 256;
    private  EnemySpaceshipManager enemySpaceshipManager;
    private  ExplosionManager explosionManager;
    private  LaserbeamManager playerLaserbeamManager;
    private  LaserbeamManager enemyLaserbeamManager;
    private Player player;

    @Override
    public SpaceObject createSpaceObject(String nameOfObject, float objectX, float objectY) {
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
        else if(nameOfObject == "star"){
            spaceObjectToCreate = createStar(objectX, objectY);
        }
        else if(nameOfObject == "smallexplosion"){
            spaceObjectToCreate = createSmallExplosion(objectX, objectY);
        }
        else if(nameOfObject == "bigexplosion"){
            spaceObjectToCreate = createBigExplosion(objectX, objectY);
        }
        else if(nameOfObject == "boss"){
            spaceObjectToCreate = createBoss(objectX, objectY);
        }
        else{
            throw new IllegalArgumentException("Object name does not exist");
        }

        return spaceObjectToCreate;
    }

    private BossSpaceship createBoss(float bossX, float bossY) {
        BossSpaceship bossSpaceship = new BossSpaceship(bossX, bossY, bossSpaceshipWidth, bossSpaceshipHeight, enemySpaceshipManager);
        enemySpaceshipManager.addEnemySpaceship(bossSpaceship);
        return bossSpaceship;
    }

    private Star createStar(float starX, float starY){
        return new Star(starX, starY, starWidth, starHeight);
    }

    private PlayerSpaceship createPlayerSpaceship(){
        return PlayerSpaceship.createInstance();
    }

    private Laserbeam createPlayerLaserbeam(float laserX, float laserY){
        BufferedImage playerLaserbeamImage = ImageHandler.getPlayerLaserbeamImage();
        Laserbeam playerLaserbeam = new Laserbeam(laserX, laserY, playerLaserbeamWidth, playerLaserbeamHeight, playerLaserbeamManager);
        playerLaserbeam.setImage(playerLaserbeamImage);
        playerLaserbeamManager.addLaserbeam(playerLaserbeam);

        return playerLaserbeam;
    }

    private Laserbeam createEnemyLaserbeam(float laserX, float laserY){
        BufferedImage enemyLaserbeamImage = ImageHandler.getEnemyLaserbeamImage();
        Laserbeam enemyLaserbeam = new Laserbeam(laserX, laserY, enemyEnergyBallWidth, enemyEnergyBallHeight, enemyLaserbeamManager);
        enemyLaserbeam.setImage(enemyLaserbeamImage);
        enemyLaserbeam.calculateDirection(player.spaceshipX(), player.spaceshipY());
        enemyLaserbeamManager.addLaserbeam(enemyLaserbeam);

        return enemyLaserbeam;
    }

    private EnemySpaceship createEnemySpaceship(float enemyX, float enemyY){
        EnemySpaceship enemySpaceship = new EnemySpaceship(enemyX, enemyY, enemySpaceshipWidth, enemySpaceshipHeight, enemySpaceshipManager);
        enemySpaceshipManager.addEnemySpaceship(enemySpaceship);
        return enemySpaceship;
    }

    private Explosion createSmallExplosion(float explosionX, float explosionY){
        Explosion explosion = new Explosion(explosionX, explosionY, smallExplosionWidth, smallExplosionHeight, explosionManager);
        explosionManager.addExplosion(explosion);
        explosion.setAnimation(ImageHandler.getSmallExplosionAnimation());
        return explosion;
    }


    private Explosion createBigExplosion(float explosionX, float explosionY){
        Explosion explosion = new Explosion(explosionX, explosionY, bigExplosionWidth, bigExplosionHeight, explosionManager);
        explosionManager.addExplosion(explosion);
        explosion.setAnimation(ImageHandler.getBigExplosionAnimation());

        return explosion;
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

    public void setPlayer(Player player){
        this.player = player;
    }

    public int getPlayerLaserbeamWidth() {
        return playerLaserbeamWidth;
    }

    public int getPlayerLaserbeamHeight() {
        return playerLaserbeamHeight;
    }

    public int getEnemyEnergyBallWidth() {
        return enemyEnergyBallWidth;
    }

    public int getEnemyEnergyBallHeight() {
        return enemyEnergyBallHeight;
    }

    public int getStarWidth() {
        return starWidth;
    }

    public int getStarHeight() {
        return starHeight;
    }

    public int getEnemySpaceshipWidth() {
        return enemySpaceshipWidth;
    }

    public int getEnemySpaceshipHeight() {
        return enemySpaceshipHeight;
    }

    public int getBossSpaceshipHeight() {
        return bossSpaceshipHeight;
    }

    public int getSmallExplosionWidth() {
        return smallExplosionWidth;
    }

    public int getSmallExplosionHeight() {
        return smallExplosionHeight;
    }

    public int getBigExplosionWidth() {
        return bigExplosionWidth;
    }

    public int getBigExplosionHeight() {
        return bigExplosionHeight;
    }
}
