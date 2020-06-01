package com.spaceshooter.view;

import com.spaceshooter.controller.Controller;

import javax.swing.*;
import java.awt.image.BufferStrategy;

public class GameWindow extends JFrame {

    private Controller gameController;
    private MenuPanel menuPanel;
    private GamePanel gamePanel;
    private LeaderboardsPanel leaderboardsPanel;
    private PanelMouseMovementListener gamePanelListener;

    public GameWindow(int width, int height) {
        setTitle("Space Shooter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        menuPanel = new MenuPanel(width, height);
        gamePanel = new GamePanel(width, height);
        leaderboardsPanel = new LeaderboardsPanel(width,height);

        setContentPane(menuPanel);
        this.pack();

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

        menuPanel.setMenuPlayButtonClickListener(new MenuPlayButtonClickListener() {
            @Override
            public void mouseButtonClick() {
                setContentPane(gamePanel);
                gamePanel.CreateGamePanelBufferStrategy(2);
                pack();
                gameController.start();
            }
        });

        menuPanel.setMenuLeaderboardsClickListener(new MenuLeaderboardsClickListener() {
            @Override
            public void mouseButtonClick() {
                setContentPane(leaderboardsPanel);
                pack();
            }
        });

        menuPanel.setMenuExitClickListener(new MenuExitButtonClickListener() {
           @Override
           public void mouseButtonClick() {
               System.exit(0);
           }
        });
    }

    public BufferStrategy getGamePanelCanvasBufferStrategy() {
        return gamePanel.getCanvasBufferStrategy();
    }
}