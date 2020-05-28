package com.spaceshooter.controller;

import com.spaceshooter.model.Game;
import com.spaceshooter.model.Star;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StarManager {
    private final int NUMBER_OF_STARS = 80;
    private List<Star> stars;

    public StarManager() {
        this.stars = new ArrayList<Star>(NUMBER_OF_STARS);

        createStars();
    }

    private void createStars() {
        Random random = new Random();

        for (int i = 0; i < NUMBER_OF_STARS; i++) {
            int starX = random.nextInt(Game.WIDTH);
            int starY = random.nextInt(Game.HEIGHT);

            Star starToAdd = new Star(starX, starY, 24, 24);

            while(checkStarIntersectionWithAll(starToAdd) == true){
                starToAdd.setX(random.nextInt(Game.WIDTH));
                starToAdd.setY( random.nextInt(Game.HEIGHT));
            }

            this.stars.add(starToAdd);
        }
    }

    public void onTick(){
        for (Star star : this.stars) {
            star.onTick();
        }
    }

    public void draw(Graphics graphics){
        for (Star star : this.stars) {
            star.draw(graphics);
        }
    }

    public boolean checkStarIntersectionWithAll(Star starToCheck){
        boolean starIntersects = false;

        // check if current star that needs to be added intersects with already existing stars
        for (Star star: this.stars) {
            if(starToCheck.intersects(star)) {
                starIntersects = true;
            }
        }

        return starIntersects;
    }
}
