package com.spaceshooter.controller;

import com.spaceshooter.model.Laserbeam;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LaserbeamManager {
    private List<Laserbeam> laserbeams;

    public LaserbeamManager() {
        this.laserbeams = new ArrayList<Laserbeam>();
    }

    public void onTick() {
        Laserbeam[] lasersArray = this.laserbeams.toArray(new Laserbeam[this.laserbeams.size()]);

        for (Laserbeam laserbeam : lasersArray) {
            laserbeam.onTick();
        }
    }

    public void draw(Graphics graphics) {
        Laserbeam[] lasersArray = this.laserbeams.toArray(new Laserbeam[this.laserbeams.size()]);

        for (Laserbeam laserbeam : lasersArray) {
            laserbeam.draw(graphics);
        }
    }

    public void addLaserbeam(Laserbeam laserbeam) {
        laserbeams.add(laserbeam);
    }

    public void destroyLaserbeam(Laserbeam laserbeam) {

    }
}
