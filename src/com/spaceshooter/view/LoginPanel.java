package com.spaceshooter.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel{
    private JTextField usertText;
    private JPasswordField passwordText;
    private JLabel userLabel,passwordLabel,success;
    private JButton loginButton;
    private JButton cancelButton;
    private LoginPanelLoginButtonClickListener loginButtonClickListener;
    private CancelButtonClickListener cancelButtonClickListener;

    public LoginPanel() {
        setBorder(BorderFactory.createTitledBorder("Login"));
        setLayout(null);
        setVisible(true);

        userLabel=new JLabel("User");
        userLabel.setBounds(10,20,80,25);
        add(userLabel);

        passwordLabel=new JLabel("Password");
        passwordLabel.setBounds(10,50,80,25);//padding
        add(passwordLabel);

        passwordText=new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        add(passwordText);

        usertText=new JTextField(20);
        usertText.setBounds(100,20,165,25);
        add(usertText);

        loginButton=new JButton("Login");
        loginButton.setBounds(10,80,80,25);
        add(loginButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds((int) (loginButton.getBounds().getWidth() + 20), 80, 80, 25);
        add(cancelButton);

        success=new JLabel("");
        success.setBounds(10,110,300,25);
        add(success);

        addComponentListeners();
    }

    private void addComponentListeners() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(loginButtonClickListener != null) {
                    String username = usertText.getText();
                    String password = new String(passwordText.getPassword());

                    try {
                        loginButtonClickListener.loginButtonClick(username, password);
                    } catch (Exception exception) {
                        success.setText(exception.getMessage());
                    }
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cancelButtonClickListener != null){
                    cancelButtonClickListener.mouseCancelButtonClick();
                }
            }
        });
    }

    public void setLoginButtonClickListener(LoginPanelLoginButtonClickListener loginButtonClickListener) {
        this.loginButtonClickListener = loginButtonClickListener;
    }

    public void setCancelButtonClickListener(CancelButtonClickListener cancelButtonClickListener) {
        this.cancelButtonClickListener = cancelButtonClickListener;
    }
}
