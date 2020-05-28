package com.spaceshooter.view;

import com.spaceshooter.controller.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferStrategy;

public class GameWindow extends JFrame {

    private Controller gameController;
    private GamePanel gamePanel;
    private GamePanelListener gamePanelListener;

    public GameWindow(int width, int height) {
        setTitle("Space Shooter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        gamePanel = new GamePanel(width, height);

        setContentPane(gamePanel);
        this.pack();

        gamePanel.CreateGamePanelBufferStrategy(2);

        addListeners();
    }

    public void setController(Controller gameController) {
        this.gameController = gameController;
    }

    private void addListeners() {
        gamePanel.setGamePanelListener(new GamePanelListener() {
            @Override
            public void updatePlayerPosition(int playerX, int playerY) {
                gameController.updatePlayerPosition(playerX, playerY);
            }
        });
    }

    public BufferStrategy getGamePanelCanvasBufferStrategy() {
        return gamePanel.getCanvasBufferStrategy();
    }
}
