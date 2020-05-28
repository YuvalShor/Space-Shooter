package com.spaceshooter.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferStrategy;

public class GamePanel extends JPanel {

    private Canvas gameCanvas;
    private PanelMouseMovementListener panelMouseMovementListener;
    private PanelMouseClickListener panelMouseClickListener;

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
                if(panelMouseMovementListener != null) {
                    panelMouseMovementListener.mouseMovedInPanel(e.getX(), e.getY());
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if(panelMouseMovementListener != null) {
                    panelMouseMovementListener.mouseMovedInPanel(e.getX(), e.getY());
                }
            }
        });

        gameCanvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(panelMouseClickListener != null){
                    panelMouseClickListener.mouseClickedOnPanel();
                }
            }
        });
    }

    public void setPanelMouseMovementListener(PanelMouseMovementListener panelMouseMovementListener){
        this.panelMouseMovementListener = panelMouseMovementListener;
    }

    public void setPanelMouseClickListener(PanelMouseClickListener panelMouseClickListener) {
        this.panelMouseClickListener = panelMouseClickListener;
    }

    public BufferStrategy getCanvasBufferStrategy(){
        return gameCanvas.getBufferStrategy();
    }

    public void CreateGamePanelBufferStrategy(int buffers) {
        gameCanvas.createBufferStrategy(buffers);
    }
}
