package com.spaceshooter.controller;

import com.spaceshooter.model.Explosion;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class ExplosionManager {
    private List<Explosion> explosionList;

    public ExplosionManager() {
        explosionList = new ArrayList<Explosion>();

        explosionList.add(new Explosion(200, 200));
    }
    
    public void onTick(){
        Iterator<Explosion> iterator = explosionList.iterator();

        while(iterator.hasNext()){
            Explosion currentExplosion = iterator.next();

            currentExplosion.onTick();

            if(currentExplosion.isKillable()){
                iterator.remove();
            }
        }
    }
    
    public void draw(Graphics graphics){
        for (Explosion explosion : this.explosionList) {
            explosion.draw(graphics);
        }
    }
}
