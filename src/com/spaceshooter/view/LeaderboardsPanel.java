package com.spaceshooter.view;

import com.spaceshooter.model.Leaderboard;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class LeaderboardsPanel extends JPanel {

    private final int numOfLeaderboardsUsers = Leaderboard.getLeaderboardsUsers().size() + 1;
    private JButton backToMenuButton = new JButton();
    private ImageHandler imageHandler = new ImageHandler();
    private BufferedImage menuBackgroundImage = ImageHandler.GetMenuImage("/com/spaceshooter/view/images/menuBackground.jpg");;
    private JLabel leaderboardsTitle = new JLabel(imageHandler.CreateIcon("/com/spaceshooter/view/images/leaderboardsTitle.png"));
    private ImageIcon backToMenuButtonIcon = imageHandler.CreateIcon("/com/spaceshooter/view/images/backToMenuButton.png");
    private ImageIcon backToMenuButtonOpaqueIcon = imageHandler.CreateIcon("/com/spaceshooter/view/images/backToMenuButton_Opaque.png");
    private JLabel[] usernameTable = new JLabel[numOfLeaderboardsUsers];
    private JLabel[] scoreTable = new JLabel[numOfLeaderboardsUsers];

    private BackToMenuButtonClickListener backToMenuButtonClickListener;

    @Override
    protected void paintComponent(Graphics g) {

        g.drawImage(menuBackgroundImage, 0, 0, null);
    }

    public LeaderboardsPanel(int width, int height) {

        JPanel headerPanel = new JPanel();
        JPanel tablePanel = new JPanel();
        JPanel footerPanel = new JPanel();

        headerPanel.setOpaque(false);
        tablePanel.setBackground(new Color(0,0,0,0));
        footerPanel.setOpaque(false);

        Insets distFromLeft = new Insets(0,0,0,0);
        Insets distFromRight = new Insets(0,150,0,0);

        headerPanel.setLayout(new GridBagLayout());

        tablePanel.setLayout(new GridBagLayout());

        Dimension dimension = new Dimension(width, height);
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        setMaximumSize(dimension);
        setLayout(new BorderLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;

        leaderboardsTitle.setPreferredSize(new Dimension(500,100));
        //gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = distFromRight;
        headerPanel.add(leaderboardsTitle,gridBagConstraints);
        gridBagConstraints.insets = new Insets(0,0,0,0);
        add(headerPanel,BorderLayout.NORTH);


        JScrollPane scrollPane =  new JScrollPane(tablePanel);
        scrollPane.setOpaque(false);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(scrollPane,BorderLayout.CENTER);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;

        Font tableTitleFont = new Font("Arial",Font.BOLD,30);
        Font tableFont = new Font("Arial",Font.BOLD,20);



        usernameTable[0] = new JLabel("Username");
        usernameTable[0].setFont(tableTitleFont);
        usernameTable[0].setPreferredSize(new Dimension(200,50));
        gridBagConstraints.insets = distFromLeft;
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        headerPanel.add(usernameTable[0],gridBagConstraints);

        scoreTable[0] = new JLabel("Score");
        scoreTable[0].setFont(tableTitleFont);
        scoreTable[0].setPreferredSize(new Dimension(200,50));
        gridBagConstraints.insets = distFromRight;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        headerPanel.add(scoreTable[0],gridBagConstraints);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;

        for (int i = 1 ; i < numOfLeaderboardsUsers ; i++)
        {
            String currentKey = (String) Leaderboard.getLeaderboardsUsers().keySet().toArray()[i - 1];


            usernameTable[i] = new JLabel(String.valueOf(Leaderboard.getLeaderboardsUsers().get(currentKey)));
            usernameTable[i].setFont(tableFont);
            usernameTable[i].setPreferredSize(new Dimension(200,50));
            gridBagConstraints.insets = distFromLeft;
            gridBagConstraints.gridx = 2;
            gridBagConstraints.gridy = i+1;
            tablePanel.add(usernameTable[i],gridBagConstraints);

            scoreTable[i] = new JLabel(String.valueOf(currentKey));
            scoreTable[i].setFont(tableFont);
            scoreTable[i].setPreferredSize(new Dimension(200,50));
            gridBagConstraints.insets = distFromRight;
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = i+1;
            tablePanel.add(scoreTable[i],gridBagConstraints);
        }


        Dimension menuButtonDimension = new Dimension(402, 99);
        backToMenuButton.setPreferredSize(menuButtonDimension);
        backToMenuButton.setIcon(backToMenuButtonIcon);

       
        footerPanel.add(backToMenuButton);
        add(footerPanel,BorderLayout.SOUTH);

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
