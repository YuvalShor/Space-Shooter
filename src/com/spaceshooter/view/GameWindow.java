package com.spaceshooter.view;

import com.spaceshooter.controller.Controller;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private Controller gameController;

    public GameWindow(int width, int height) {
        setTitle("Space Shooter");

        Dimension dimension = new Dimension(width, height);
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        setMinimumSize(dimension);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        createBufferStrategy(2);
    }

}
