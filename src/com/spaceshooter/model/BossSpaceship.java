package com.spaceshooter.model;

import com.spaceshooter.model.interfaces.ObjectObserver;
import com.spaceshooter.view.ImageHandler;

public class BossSpaceship extends EnemySpaceship{
    private int frame;
    private final int numberOfEnergyBalls = 15;
    private final int distanceBetweenEnergyBalls;
    public BossSpaceship(float x, float y, int width, int height, ObjectObserver observer) {
        super(x, y, width, height, observer, 1000);
        this.health = 1000;
        this.enemySpaceshipImage = ImageHandler.getBossSpaceshipImage();
        frame = 0;
        distanceBetweenEnergyBalls = Game.WIDTH / numberOfEnergyBalls;
        this.moveX = 1;
    }

    @Override
    public void onTick() {
        this.x += this.moveX;

        moveTowardsPlayer();
        assureObjectWithinBorders();
        checkIfDestroyed();
        shootLasers();
    }

    private void moveTowardsPlayer() {
        Player player = Player.createInstance(); // singleton

        if(frame % 60 == 0) {
           if(this.x < player.spaceshipX()){
               this.moveX = 1;
           }
           else{
               this.moveX = -1;
           }
        }
    }

    private void checkIfDestroyed() {
        if(this.health <= 0){
            int explosionWidth = Game.creator.getBigExplosionWidth();

            Game.creator.createSpaceObject("bigexplosion",this.leftBorder() + explosionWidth/8, this.y );
            Game.creator.createSpaceObject("bigexplosion", this.x, this.y );
            Game.creator.createSpaceObject("bigexplosion", this.rightBorder() - explosionWidth/8 , this.y);

            notifyObserver();
        }
    }

    private void shootLasers() {
        frame = (frame + 1) % 180;

        if (frame % 180 == 0) {
            int directionOffset = (int) (this.x - Game.WIDTH / 2);

            for (int i = 0; i < numberOfEnergyBalls; i++) {
                Laserbeam laser = (Laserbeam) Game.creator.createSpaceObject("enemylaserbeam", this.x - 7,
                        this.bottomBorder());
                laser.calculateDirection(directionOffset + i * distanceBetweenEnergyBalls,
                        Game.HEIGHT - Game.HEIGHT / 4);
            }
        }
    }

    @Override
    public void notifyObserver() {
        this.observer.objectStateChanged(this);
    }
}
