package com.spaceshooter.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.net.URL;

public class MenuPanel extends JPanel {
    private PanelMouseMovementListener panelMouseMovementListener;
    private PanelMouseClickListener panelMouseClickListener;
    private BufferedImage menuBackgroundImage;

    private JButton playButton;
    private JButton leaderboardsButton;
    private JButton exitButton;

    private MenuPlayButtonClickListener menuPlayButtonClickListener;
    private MenuLeaderboardsClickListener menuLeaderboardsClickListener;
    private MenuExitButtonClickListener menuExitButtonClickListener;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(menuBackgroundImage, 0, 0, null);
    }

    public MenuPanel(int width, int height) {
        BufferedImageLoader bufferedImageLoader = new BufferedImageLoader();
        menuBackgroundImage = bufferedImageLoader.loadImage("/com/spaceshooter/view/images/menuBackground.jpg");

        Dimension dimension = new Dimension(width, height);
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        setMaximumSize(dimension);

        playButton = new JButton();
        leaderboardsButton = new JButton();
        exitButton = new JButton();

        Dimension menuButtonDimension = new Dimension(402, 99);
        Font menuButtonFont = new Font("Arial", Font.PLAIN, 30);

        setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weighty = 0.55;
        gridBagConstraints.anchor = GridBagConstraints.EAST;

        JLabel menuTitleShadow = new JLabel("Space Shooter");
        menuTitleShadow.setPreferredSize(new Dimension(500,100));
        menuTitleShadow.setFont(new Font("Arial",Font.BOLD,70));
        menuTitleShadow.setForeground(Color.WHITE);
        add(menuTitleShadow, gridBagConstraints);

        gridBagConstraints.ipadx = 4;
        JLabel menuTitle = new JLabel("Space Shooter");
        menuTitle.setPreferredSize(new Dimension(500,100));
        menuTitle.setFont(new Font("Arial",Font.BOLD,70));
        menuTitle.setForeground(Color.BLACK);
        add(menuTitle, gridBagConstraints);

        gridBagConstraints.ipadx = 0;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
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
        playButton.setIcon(createIcon("/com/spaceshooter/view/images/menuPlayButton.png"));
        leaderboardsButton.setOpaque(false);
        leaderboardsButton.setPreferredSize(menuButtonDimension);
        leaderboardsButton.setIcon(createIcon("/com/spaceshooter/view/images/menuLeaderboardsButton.png"));
        exitButton.setOpaque(false);
        exitButton.setPreferredSize(menuButtonDimension);
        exitButton.setIcon(createIcon("/com/spaceshooter/view/images/menuExitButton.png"));

        playButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
//                playButton.setBackground(new Color(0,0,0,20));
                playButton.setIcon(createIcon("/com/spaceshooter/view/images/menuPlayButton_Opaque.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                playButton.setBackground(UIManager.getColor("control"));
                playButton.setIcon(createIcon("/com/spaceshooter/view/images/menuPlayButton.png"));
            }
        });

        leaderboardsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
//                leaderboardsButton.setBackground(new Color(0,0,0,20));
                leaderboardsButton.setIcon(createIcon("/com/spaceshooter/view/images/menuLeaderboardsButton_Opaque.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                leaderboardsButton.setBackground(UIManager.getColor("control"));
                leaderboardsButton.setIcon(createIcon("/com/spaceshooter/view/images/menuLeaderboardsButton.png"));
            }
        });

        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
//                exitButton.setBackground(new Color(0,0,0,20));
                exitButton.setIcon(createIcon("/com/spaceshooter/view/images/menuExitButton_Opaque.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                exitButton.setBackground(UIManager.getColor("control"));
                exitButton.setIcon(createIcon("/com/spaceshooter/view/images/menuExitButton.png"));
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

    private ImageIcon createIcon(String path){
        URL url = getClass().getResource(path);

        if(url == null){
            System.err.println("Unable to load image " +  path);
            return null;
        }

        return new ImageIcon(url);
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