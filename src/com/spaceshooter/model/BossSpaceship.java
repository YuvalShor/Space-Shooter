package com.spaceshooter.model;

import com.spaceshooter.view.ImageHandler;

import java.awt.*;
import java.util.Random;

public class BossSpaceship extends EnemySpaceship{
    private int frame;

    public BossSpaceship(float x, float y, int width, int height, ObjectObserver observer) {
        super(x, y, width, height, observer, 1000);
        this.health = 1000;
        this.enemySpaceshipImage = ImageHandler.getBossSpaceshipImage();
        frame = 0;
    }

    @Override
    public void onTick() {
        if(this.health <= 0){
            int explosionWidth = Game.creator.getBigExplosionWidth();

            Game.creator.createSpaceObject("bigexplosion",this.leftBorder() + explosionWidth/8, this.y );
            Game.creator.createSpaceObject("bigexplosion", this.x, this.y );
            Game.creator.createSpaceObject("bigexplosion", this.rightBorder() - explosionWidth/8 , this.y);
        }

        frame = (frame + 1) % 120;
        if(frame % 120 == 0) {
            Random random = new Random();
            for (int i = 0; i < 100; i++) {
                Laserbeam laser = (Laserbeam) Game.creator.createSpaceObject("enemylaserbeam", this.x,
                        this.bottomBorder());
                laser.calculateDirection(random.nextInt(Game.WIDTH), Game.HEIGHT/2 );
            }
        }
    }
}
