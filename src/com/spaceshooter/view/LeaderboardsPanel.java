package com.spaceshooter.view;

import com.spaceshooter.model.LeaderboardData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class LeaderboardsPanel extends JPanel {

    private final JButton backToMenuButton = new JButton();
    private final ImageHandler imageHandler = new ImageHandler();
    private final BufferedImage menuBackgroundImage = ImageHandler.GetMenuImage("/com/spaceshooter/view/images/menuBackground.jpg");
    private final JLabel leaderboardsTitle = new JLabel(imageHandler.CreateIcon("/com/spaceshooter/view/images/leaderboardsTitle.png"));
    private final ImageIcon backToMenuButtonIcon = imageHandler.CreateIcon("/com/spaceshooter/view/images/backToMenuButton.png");
    private final ImageIcon backToMenuButtonOpaqueIcon = imageHandler.CreateIcon("/com/spaceshooter/view/images/backToMenuButton_Opaque.png");

    private JLabel[] scoreTable;
    private JLabel[] usernameTable;

    private JPanel headerPanel = new JPanel();
    private JPanel tablePanel = new JPanel();
    private JPanel footerPanel = new JPanel();

    private Font tableTitleFont;
    private Font tableFont;
    GridBagConstraints gridBagConstraints;

    private BackToMenuButtonClickListener backToMenuButtonClickListener;
    private LeaderboardDataListener leaderboardDataListener;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(menuBackgroundImage, 0, 0, null);
    }

    public LeaderboardsPanel(int width, int height) {
        Dimension windowDimension = new Dimension(width, height);

        setPreferredSize(windowDimension);
        setMinimumSize(windowDimension);
        setMaximumSize(windowDimension);
        
        setLayout(new BorderLayout());
        headerPanel.setOpaque(false);
        tablePanel.setOpaque(false);
        footerPanel.setOpaque(false);

        headerPanel.setLayout(new GridBagLayout());
        tablePanel.setLayout(new GridBagLayout());
        footerPanel.setLayout(new GridBagLayout());

        gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;

        headerPanel.add(leaderboardsTitle, gridBagConstraints);

        add(headerPanel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(tablePanel);
        scrollPane.setBackground(new Color(0, 0, 0, 0));
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(scrollPane, BorderLayout.CENTER);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;

        tableTitleFont = new Font("Arial", Font.BOLD, 30);
        tableFont = new Font("Arial", Font.BOLD, 20);

        Dimension menuButtonDimension = new Dimension(300, 74);
        backToMenuButton.setPreferredSize(menuButtonDimension);
        backToMenuButton.setIcon(backToMenuButtonIcon);

        footerPanel.add(backToMenuButton);
        add(footerPanel, BorderLayout.SOUTH);

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

            @Override
            public void mouseReleased(MouseEvent e) {
                backToMenuButton.setIcon(backToMenuButtonIcon);
            }
        });

        backToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (backToMenuButtonClickListener != null) {
                    backToMenuButtonClickListener.mouseButtonClick();
                    tablePanel.removeAll();
                }
            }
        });
    }

    private ArrayList<LeaderboardData> getLeaderboardFromMainWindow() {
        if(leaderboardDataListener != null){
            return leaderboardDataListener.getLeaderboardData();
        }

        return null;
    }

    public void setLeaderboardsBackClickListener(BackToMenuButtonClickListener backToMenuButtonClickListener) {
        this.backToMenuButtonClickListener = backToMenuButtonClickListener;
    }

    public void setLeaderboardDataListener(LeaderboardDataListener leaderboardDataListener) {
        this.leaderboardDataListener = leaderboardDataListener;
    }

    public void drawLeaderboardsTable() {
        ArrayList<LeaderboardData> leaderboardScoreTable = getLeaderboardFromMainWindow();

        int numOfLeaderboardsUsers;

        if (leaderboardScoreTable != null) {
            numOfLeaderboardsUsers = leaderboardScoreTable.size() + 1;
        }
        else{
            numOfLeaderboardsUsers = 1;
        }

        scoreTable = new JLabel[numOfLeaderboardsUsers];
        usernameTable = new JLabel[numOfLeaderboardsUsers];

        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        scoreTable[0] = new JLabel("Username");
        scoreTable[0].setFont(tableTitleFont);
        scoreTable[0].setMinimumSize(new Dimension(150, 50));
        scoreTable[0].setPreferredSize(new Dimension(150, 50));
        scoreTable[0].setMaximumSize(new Dimension(150, 50));
        gridBagConstraints.gridy = 1;
        headerPanel.add(scoreTable[0], gridBagConstraints);

        usernameTable[0] = new JLabel("Score");
        usernameTable[0].setFont(tableTitleFont);
        usernameTable[0].setPreferredSize(new Dimension(150, 50));
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        headerPanel.add(usernameTable[0], gridBagConstraints);

        for (int i = 1; i < numOfLeaderboardsUsers; i++) {
            LeaderboardData currentRow = leaderboardScoreTable.get(i - 1);

            scoreTable[i] = new JLabel(String.valueOf(currentRow.getScore()));
            scoreTable[i].setFont(tableFont);
            scoreTable[i].setPreferredSize(new Dimension(200, 50));
            scoreTable[i].setHorizontalAlignment(SwingConstants.CENTER);
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = i + 1;
            tablePanel.add(scoreTable[i], gridBagConstraints);

            usernameTable[i] = new JLabel(String.valueOf(currentRow.getUsername()));
            usernameTable[i].setFont(tableFont);
            usernameTable[i].setPreferredSize(new Dimension(200, 50));
            usernameTable[i].setHorizontalAlignment(SwingConstants.CENTER);
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = i + 1;
            tablePanel.add(usernameTable[i], gridBagConstraints);
        }
    }
}