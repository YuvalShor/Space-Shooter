package com.spaceshooter.game;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private GamePanel gamePanel;

    public GameFrame()  {
        this.setLayout(new GridLayout());
        this.setSize(1280, 720);
        this.setVisible(true);
        this.setResizable(false);

        gamePanel = new GamePanel();
        this.add(gamePanel);
    }
}
