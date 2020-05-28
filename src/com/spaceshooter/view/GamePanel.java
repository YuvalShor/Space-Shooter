package com.spaceshooter.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferStrategy;

public class GamePanel extends JPanel {

    private GamePanelListener gamePanelListener;
    private Canvas gameCanvas;

    public GamePanel(int width, int height) {
        gameCanvas = new Canvas();
        Dimension dimension = new Dimension(width, height);

        gameCanvas.setPreferredSize(dimension);
        gameCanvas.setMinimumSize(dimension);
        gameCanvas.setMaximumSize(dimension);

        setRequestFocusEnabled(true);

        setLayout(new BorderLayout());
        add(gameCanvas, BorderLayout.CENTER);
        
        addPanelListeners();
    }

    private void addPanelListeners() {
        gameCanvas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if(gamePanelListener != null) {
                    gamePanelListener.updatePlayerPosition(e.getX(), e.getY());
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if(gamePanelListener != null) {
                    gamePanelListener.updatePlayerPosition(e.getX(), e.getY());
                }
            }
        });
    }

    public void setGamePanelListener(GamePanelListener gamePanelListener){
        this.gamePanelListener = gamePanelListener;
    }

    public BufferStrategy getCanvasBufferStrategy(){
        return gameCanvas.getBufferStrategy();
    }

    public void CreateGamePanelBufferStrategy(int buffers) {
        gameCanvas.createBufferStrategy(buffers);
    }
}
