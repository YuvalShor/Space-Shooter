package com.spaceshooter.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class MenuPanel extends JPanel {
    private PanelMouseMovementListener panelMouseMovementListener;
    private PanelMouseClickListener panelMouseClickListener;

    private ImageHandler imageHandler = new ImageHandler();

    private BufferedImage menuBackgroundImage;

    private JButton playButton;
    private JButton leaderboardsButton;
    private JButton exitButton;

    private ImageIcon playButtonIcon = imageHandler.CreateIcon("/com/spaceshooter/view/images/menuPlayButton.png");
    private ImageIcon playButtonOpaqueIcon = imageHandler.CreateIcon("/com/spaceshooter/view/images/menuPlayButton_Opaque.png");
    private ImageIcon leaderboardsButtonIcon = imageHandler.CreateIcon("/com/spaceshooter/view/images/menuLeaderboardsButton.png");
    private ImageIcon leaderboardsButtonOpaqueIcon = imageHandler.CreateIcon("/com/spaceshooter/view/images/menuLeaderboardsButton_Opaque.png");
    private ImageIcon exitButtonIcon = imageHandler.CreateIcon("/com/spaceshooter/view/images/menuExitButton.png");
    private ImageIcon exitButtonOpaqueIcon = imageHandler.CreateIcon("/com/spaceshooter/view/images/menuExitButton_Opaque.png");

    private MenuPlayButtonClickListener menuPlayButtonClickListener;
    private MenuLeaderboardsClickListener menuLeaderboardsClickListener;
    private MenuExitButtonClickListener menuExitButtonClickListener;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(menuBackgroundImage, 0, 0, null);
    }

    public MenuPanel(int width, int height) {
        menuBackgroundImage = ImageHandler.GetMenuImage("/com/spaceshooter/view/images/menuBackground.jpg");

        Dimension dimension = new Dimension(width, height);
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        setMaximumSize(dimension);

        playButton = new JButton();
        leaderboardsButton = new JButton();
        exitButton = new JButton();

        Dimension menuButtonDimension = new Dimension(402, 99);
        Font titleFont = new Font("Arial", Font.BOLD, 70);

        setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weighty = 0.55;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;

        JLabel menuTitle = new JLabel(imageHandler.CreateIcon("/com/spaceshooter/view/images/logo.png"));
        menuTitle.setSize(new Dimension(500,100));
        add(menuTitle, gridBagConstraints);
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weighty = 0.15;
        add(playButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weighty = 0.15;
        add(leaderboardsButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weighty = 0.15;
        add(exitButton, gridBagConstraints);


        playButton.setOpaque(false);
        playButton.setPreferredSize(menuButtonDimension);
        playButton.setIcon(playButtonIcon);
        leaderboardsButton.setOpaque(false);
        leaderboardsButton.setPreferredSize(menuButtonDimension);
        leaderboardsButton.setIcon(leaderboardsButtonIcon);
        exitButton.setOpaque(false);
        exitButton.setPreferredSize(menuButtonDimension);
        exitButton.setIcon(exitButtonIcon);

        playButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                playButton.setIcon(playButtonOpaqueIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                playButton.setIcon(playButtonIcon);
            }
        });

        leaderboardsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                leaderboardsButton.setIcon(leaderboardsButtonOpaqueIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                leaderboardsButton.setIcon(leaderboardsButtonIcon);
            }
        });

        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exitButton.setIcon(exitButtonOpaqueIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton.setIcon(exitButtonIcon);
            }
        });

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (menuPlayButtonClickListener != null)
                {
                    menuPlayButtonClickListener.mouseButtonClick();
                }
            }
        });

        leaderboardsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (menuLeaderboardsClickListener != null)
                {
                    menuLeaderboardsClickListener.mouseButtonClick();
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (menuExitButtonClickListener != null)
                {
                    menuExitButtonClickListener.mouseButtonClick();
                }
            }
        });
    }

    public void setMenuPlayButtonClickListener(MenuPlayButtonClickListener menuPlayButtonClickListener) {
        this.menuPlayButtonClickListener = menuPlayButtonClickListener;
    }

    public void setMenuLeaderboardsClickListener(MenuLeaderboardsClickListener menuLeaderboardsClickListener) {
        this.menuLeaderboardsClickListener = menuLeaderboardsClickListener;
    }

    public void setMenuExitClickListener(MenuExitButtonClickListener menuExitButtonClickListener) {
        this.menuExitButtonClickListener = menuExitButtonClickListener;
    }
}