package com.spaceshooter.controller;

import com.spaceshooter.model.Game;
import com.spaceshooter.model.Star;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StarManager {
    private final int NUNMBER_OF_STARS = 20;
    private final int NUMBER_OF_BIG_STARS = 50;

    private List<Star> stars;

    public StarManager() {
        this.stars = new ArrayList<Star>(NUNMBER_OF_STARS);

        createStars();
    }

    public void createStars() {
        Random random = new Random();

        // small stars
        for (int i = 0; i < NUMBER_OF_BIG_STARS; i++) {
            int starX = random.nextInt(Game.WIDTH);
            int starY = random.nextInt(Game.HEIGHT);

            Star starToAdd = (Star) Game.creator.createSpaceObject("star", starX, starY);
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
