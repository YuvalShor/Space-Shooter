package com.spaceshooter.view;

import com.spaceshooter.view.listenerInterfaces.CancelButtonClickListener;
import com.spaceshooter.view.listenerInterfaces.RegisterPanelRegisterButtonClickListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {
    private static JTextField usertText;
    private static JPasswordField passwordText;
    private static JLabel userLabel, passwordLabel;
    private static JButton registerButton, cancelButton;
    private RegisterPanelRegisterButtonClickListener registerButtonListener;
    private CancelButtonClickListener cancelButtonListener;

    public RegisterPanel() {

        setBorder(BorderFactory.createTitledBorder("User not found. You must register first"));
        setLayout(null);

        usertText = new JTextField(20);
        usertText.setBounds(100, 20, 165, 25);
        add(usertText);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 60, 165, 25);
        add(passwordText);


        userLabel = new JLabel("Username");
        userLabel.setBounds(10, 20, 80, 25);//padding
        add(userLabel);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 60, 80, 25);//padding
        add(passwordLabel);

        registerButton = new JButton();
        registerButton.setText("Register");
        registerButton.setBounds(10, 100, 100, 25);

        add(registerButton);

        cancelButton = new JButton();
        cancelButton.setText("Cancel");
        cancelButton.setBounds(120, 100, 140, 25);
        add(cancelButton);
        setVisible(true);

        createComponentListeners();
    }

    private void createComponentListeners() {
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (registerButtonListener != null) {
                    String username = usertText.getText();
                    String password = new String(passwordText.getPassword());
                    try {
                        registerButtonListener.registerButtonClicked(username, password);
                    } catch (Exception exception) {
                        setBorder(BorderFactory.createTitledBorder(exception.getMessage()));
                    }
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cancelButtonListener != null) {
                    cancelButtonListener.mouseCancelButtonClick();
                }
            }
        });
    }

    public void setRegisterButtonListener(RegisterPanelRegisterButtonClickListener registerButtonListener) {
        this.registerButtonListener = registerButtonListener;
    }

    public void setCancelButtonListener(CancelButtonClickListener cancelButtonListener) {
        this.cancelButtonListener = cancelButtonListener;
    }
}
