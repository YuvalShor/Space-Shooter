package com.spaceshooter.game;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private GamePanel gamePanel;

    public GameFrame()  {
        this.setLayout(new BorderLayout());
        this.setSize(500, 400);
        this.setVisible(true);

        gamePanel = new GamePanel();
        this.add(gamePanel, BorderLayout.CENTER);
    }
}
