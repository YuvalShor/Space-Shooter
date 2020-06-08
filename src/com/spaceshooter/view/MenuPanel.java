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

    private BufferedImage menuBackgroundImage = ImageHandler.GetMenuImage("/com/spaceshooter/view/images/menuBackground.jpg");

    private JLabel menuLogo = new JLabel(imageHandler.CreateIcon("/com/spaceshooter/view/images/logo.png"));

    private JButton playButton = new JButton();
    private JButton leaderboardsButton = new JButton();
    private JButton loginButton = new JButton();
    private JButton registerButton = new JButton();
    private JButton exitButton = new JButton();

    private ImageIcon playButtonIcon = imageHandler.CreateIcon("/com/spaceshooter/view/images/menuPlayButton.png");
    private ImageIcon playButtonOpaqueIcon = imageHandler.CreateIcon("/com/spaceshooter/view/images/menuPlayButton_Opaque.png");
    private ImageIcon loginButtonIcon = imageHandler.CreateIcon("/com/spaceshooter/view/images/menuLoginButton.png");
    private ImageIcon loginButtonOpaqueIcon = imageHandler.CreateIcon("/com/spaceshooter/view/images/menuLoginButton_Opaque.png");
    private ImageIcon registerButtonIcon = imageHandler.CreateIcon("/com/spaceshooter/view/images/menuRegisterButton.png");
    private ImageIcon registerButtonOpaqueIcon = imageHandler.CreateIcon("/com/spaceshooter/view/images/menuRegisterButton_Opaque.png");
    private ImageIcon leaderboardsButtonIcon = imageHandler.CreateIcon("/com/spaceshooter/view/images/menuLeaderboardsButton.png");
    private ImageIcon leaderboardsButtonOpaqueIcon = imageHandler.CreateIcon("/com/spaceshooter/view/images/menuLeaderboardsButton_Opaque.png");
    private ImageIcon exitButtonIcon = imageHandler.CreateIcon("/com/spaceshooter/view/images/menuExitButton.png");
    private ImageIcon exitButtonOpaqueIcon = imageHandler.CreateIcon("/com/spaceshooter/view/images/menuExitButton_Opaque.png");

    private MenuPlayButtonClickListener menuPlayButtonClickListener;
    private MenuLoginButtonClickListener menuLoginButtonClickListener;
    private MenuRegisterButtonClickListener menuRegisterButtonClickListener;
    private MenuLeaderboardsClickListener menuLeaderboardsClickListener;
    private MenuExitButtonClickListener menuExitButtonClickListener;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(menuBackgroundImage, 0, 0, null);
    }

    public MenuPanel(int width, int height) {
        Dimension windowDimension = new Dimension(width, height);

        setPreferredSize(windowDimension);
        setMinimumSize(windowDimension);
        setMaximumSize(windowDimension);

        setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weighty = 0.55;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;

        menuLogo.setSize(new Dimension(500, 100));
        add(menuLogo, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weighty = 0.15;
        add(playButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weighty = 0.15;
        add(loginButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weighty = 0.15;
        add(registerButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.weighty = 0.15;
        add(leaderboardsButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.weighty = 0.15;
        add(exitButton, gridBagConstraints);

        Dimension menuButtonDimension = new Dimension(300, 74);

        playButton.setOpaque(false);
        playButton.setPreferredSize(menuButtonDimension);
        playButton.setIcon(playButtonIcon);

        loginButton.setOpaque(false);
        loginButton.setPreferredSize(menuButtonDimension);
        loginButton.setIcon(loginButtonIcon);

        registerButton.setOpaque(false);
        registerButton.setPreferredSize(menuButtonDimension);
        registerButton.setIcon(registerButtonIcon);

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

            @Override
            public void mouseReleased(MouseEvent e) {
                playButton.setIcon(playButtonIcon);
            }
        });

        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                loginButton.setIcon(loginButtonOpaqueIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                loginButton.setIcon(loginButtonIcon);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                loginButton.setIcon(loginButtonIcon);
            }
        });

        registerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                registerButton.setIcon(registerButtonOpaqueIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                registerButton.setIcon(registerButtonIcon);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                registerButton.setIcon(registerButtonIcon);
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

            @Override
            public void mouseReleased(MouseEvent e) {
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
                if (menuPlayButtonClickListener != null) {
                    menuPlayButtonClickListener.mouseButtonClick();
                }
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (menuLoginButtonClickListener != null) {
                    menuLoginButtonClickListener.mouseButtonClick();


                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (menuRegisterButtonClickListener != null) {
                    menuRegisterButtonClickListener.mouseButtonClick();
                }
            }
        });

        leaderboardsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (menuLeaderboardsClickListener != null) {
                    menuLeaderboardsClickListener.mouseButtonClick();
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (menuExitButtonClickListener != null) {
                    menuExitButtonClickListener.mouseButtonClick();
                }
            }
        });
    }

    public void setMenuPlayButtonClickListener(MenuPlayButtonClickListener menuPlayButtonClickListener) {
        this.menuPlayButtonClickListener = menuPlayButtonClickListener;
    }

    public void setMenuLoginButtonClickListener(MenuLoginButtonClickListener menuLoginButtonClickListener) {
        this.menuLoginButtonClickListener = menuLoginButtonClickListener;
    }

    public void setMenuRegisterButtonClickListener(MenuRegisterButtonClickListener menuRegisterButtonClickListener) {
        this.menuRegisterButtonClickListener = menuRegisterButtonClickListener;
    }

    public void setMenuLeaderboardsClickListener(MenuLeaderboardsClickListener menuLeaderboardsClickListener) {
        this.menuLeaderboardsClickListener = menuLeaderboardsClickListener;
    }

    public void setMenuExitClickListener(MenuExitButtonClickListener menuExitButtonClickListener) {
        this.menuExitButtonClickListener = menuExitButtonClickListener;
    }
}