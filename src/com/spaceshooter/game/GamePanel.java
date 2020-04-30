package com.spaceshooter.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePanel extends JPanel {
    private Spaceship spaceship;

    public GamePanel() {
        this.setSize(500, 400);
        System.out.println(this.getWidth());
        spaceship = new Spaceship(this.getWidth() / 2, this.getHeight() / 2, 50, 50);
        addListeners();
    }

    private void addListeners() {
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
                spaceship.setX(mouseEvent.getX());
                spaceship.setY(mouseEvent.getY());

                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D)g;
        graphics2D.setColor(new Color(0, 0, 0));
        graphics2D.fillRect(0,0, this.getWidth(), this.getHeight());
        spaceship.draw(g);
    }

}
