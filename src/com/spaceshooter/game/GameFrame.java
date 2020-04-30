package com.spaceshooter.game;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private GamePanel gamePanel;

    public GameFrame()  {
        gamePanel = new GamePanel();
        gamePanel.setPreferredSize(new Dimension(500, 400));
    }
}
