package com.spaceshooter.controller;

import com.spaceshooter.model.Laserbeam;
import com.spaceshooter.model.interfaces.ObjectObserver;
import com.spaceshooter.model.interfaces.ObservableObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LaserbeamManager implements ObjectObserver {
    private final List<Laserbeam> laserbeams;

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

    public void removeLaserbeam(Laserbeam laserbeam) {
        this.laserbeams.remove(laserbeam);
    }

    public List<Laserbeam> getLasers() {
        return this.laserbeams;
    }

    @Override
    public void objectStateChanged(ObservableObject observable) {
        removeLaserbeam((Laserbeam) observable);
    }

    public void clear() {
        this.laserbeams.clear();
    }

    public void remove(Laserbeam laser) {
        laserbeams.remove(laser);
    }
}
