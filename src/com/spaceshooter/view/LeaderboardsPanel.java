package com.spaceshooter.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class LeaderboardsPanel extends JPanel {

    private JButton backToMenuButton = new JButton();
    private ImageHandler imageHandler = new ImageHandler();
    private BufferedImage menuBackgroundImage = ImageHandler.GetMenuImage("/com/spaceshooter/view/images/menuBackground.jpg");;
    private JLabel leaderboardsTitle = new JLabel(imageHandler.CreateIcon("/com/spaceshooter/view/images/leaderboardsTitle.png"));
    private ImageIcon backToMenuButtonIcon = imageHandler.CreateIcon("/com/spaceshooter/view/images/backToMenuButton.png");
    private ImageIcon backToMenuButtonOpaqueIcon = imageHandler.CreateIcon("/com/spaceshooter/view/images/backToMenuButton_Opaque.png");


    private BackToMenuButtonClickListener backToMenuButtonClickListener;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(menuBackgroundImage, 0, 0, null);
    }

    public LeaderboardsPanel(int width, int height) {

        Dimension dimension = new Dimension(width, height);
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        setMaximumSize(dimension);
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();


        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weighty = 0.55;

        leaderboardsTitle.setPreferredSize(new Dimension(500,100));
        add(leaderboardsTitle, gridBagConstraints);

        ///to do Jstring

        Dimension menuButtonDimension = new Dimension(402, 99);
        backToMenuButton.setPreferredSize(menuButtonDimension);
        backToMenuButton.setIcon(backToMenuButtonIcon);

        //gridBagConstraints.anchor = GridBagConstraints.SOUTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.weighty = 0.15;
        add(backToMenuButton, gridBagConstraints);

        setBorder(BorderFactory.createEtchedBorder());

        backToMenuButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                backToMenuButton.setIcon(backToMenuButtonOpaqueIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                backToMenuButton.setIcon(backToMenuButtonIcon);
            }
        });

        backToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (backToMenuButtonClickListener != null)
                {
                    backToMenuButtonClickListener.mouseButtonClick();
                }
            }
        });

    }

    public void setLeaderboardsBackClickListener(BackToMenuButtonClickListener backToMenuButtonClickListener) {
        this.backToMenuButtonClickListener = backToMenuButtonClickListener;
    }
}
