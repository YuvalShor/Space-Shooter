package com.spaceshooter.view;

import com.spaceshooter.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class LoginRegisterFrame extends JFrame{
    private Controller controller;
    private LoginPanel loginPanel;
    private RegisterPanel registerPanel;

    public LoginRegisterFrame()  {
        setTitle("Login");

        setPreferredSize(new Dimension(350,200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);

        registerPanel = new RegisterPanel();
        loginPanel = new LoginPanel();

        add(loginPanel);
        pack();
        addPanelListeners();
    }

    private void addPanelListeners() {
        registerPanel.setRegisterButtonListener(new RegisterPanelRegisterButtonClickListener() {
            @Override
            public void registerButtonClicked(String username, String password) {
                if(controller != null){
                    controller.register(username, password);
                    dispose();
                    controller.startGameWindow();
                }
            }
        });

        registerPanel.setCancelButtonListener(new CancelButtonClickListener() {
            @Override
            public void mouseCancelButtonClick() {
                if(controller != null) {
                    dispose();
                    controller.startGameWindow();
                }
            }
        });

        loginPanel.setLoginButtonClickListener(new LoginPanelLoginButtonClickListener() {
            @Override
            public void loginButtonClick(String username, String password) throws Exception {
                if(controller.login(username, password)){
                    if(controller != null) {
                        dispose();
                        controller.startGameWindow();
                    }
                }
                else{
                    setContentPane(registerPanel);
                    pack();
                }
            }
        });

        loginPanel.setCancelButtonClickListener(new CancelButtonClickListener() {
            @Override
            public void mouseCancelButtonClick() {
                dispose();
            }
        });
    }

    public static String getSha1Hex(String clearString)
    {
        try
        {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(clearString.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = messageDigest.digest();
            StringBuilder buffer = new StringBuilder();
            for (byte b : bytes)
            {
                buffer.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            return buffer.toString();
        }
        catch (Exception ignored)
        {
            ignored.printStackTrace();
            return null;
        }
    }

    public void setController(Controller gameController) {
        this.controller = gameController;
    }
}
