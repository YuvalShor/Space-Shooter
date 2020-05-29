package com.spaceshooter.view;

import com.spaceshooter.controller.Controller;

import javax.swing.*;
import java.awt.image.BufferStrategy;

public class GameWindow extends JFrame {

    private Controller gameController;
    private GamePanel gamePanel;
    private PanelMouseMovementListener gamePanelListener;

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
        gamePanel.setPanelMouseMovementListener(new PanelMouseMovementListener() {
            @Override
            public void mouseMovedInPanel(int playerX, int playerY) {
                if(gameController != null){
                    gameController.updatePlayerPosition(playerX, playerY);
                }
            }
        });

        gamePanel.setPanelMouseClickListener(new PanelMouseClickListener() {
            @Override
            public void mouseClickedOnPanel() {
                if(gameController != null) {
                    gameController.playerMouseClicked();
                }
            }
        });
    }

    public BufferStrategy getGamePanelCanvasBufferStrategy() {
        return gamePanel.getCanvasBufferStrategy();
    }
}
