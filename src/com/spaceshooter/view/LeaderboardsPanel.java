package com.spaceshooter.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

public class LeaderboardsPanel extends JPanel {

    private JButton backToMenuButton;

    private ImageHandler imageHandler = new ImageHandler();

    private BufferedImage menuBackgroundImage;

    private ImageIcon backToMenuButtonIcon = imageHandler.CreateIcon("/com/spaceshooter/view/images/backToMenuButton.png");

    private BackToMenuButtonClickListener backToMenuButtonClickListener;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(menuBackgroundImage, 0, 0, null);
    }

    public LeaderboardsPanel(int width, int height) {
        menuBackgroundImage = ImageHandler.GetMenuImage("/com/spaceshooter/view/images/menuBackground.jpg");

        Dimension dimension = new Dimension(width, height);
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        setMaximumSize(dimension);

        backToMenuButton = new JButton();

        Dimension menuButtonDimension = new Dimension(402, 99);
        backToMenuButton.setPreferredSize(menuButtonDimension);
        backToMenuButton.setIcon(backToMenuButtonIcon);

        setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        //gridBagConstraints.gridx = 10;
       // gridBagConstraints.gridy = 10;
        //gridBagConstraints.weighty = 0.55;
        //gridBagConstraints.anchor = GridBagConstraints.EAST;

        gridBagConstraints.gridx = 25;
        gridBagConstraints.gridy = 25;

        gridBagConstraints.weighty = 0.15;
        add(backToMenuButton, gridBagConstraints);

        setBorder(BorderFactory.createEtchedBorder());



    }
}
