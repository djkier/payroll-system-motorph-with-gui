package org.motorph.controller;


import org.motorph.view.PasswordInterface;

import javax.swing.*;

public class PasswordController {
    private PasswordInterface passwordInterface;
    private JFrame app;
    private JButton submitButton;
    private String userName;
    private String password;

    public PasswordController() {
        this.userName = "admin";
        this.password = "password";
        this.passwordInterface = new PasswordInterface("Login");
        this.app = passwordInterface.getApp();
        this.submitButton = passwordInterface.getSubmitButton();

        this.submitButton.addActionListener(e ->
                checkPassword(passwordInterface.getUserNameText()
                        , passwordInterface.getPasswordText()));


    }

    public void start() {
        app.setVisible(true);
    }

    public void checkPassword(String eUserName, String ePassword) {
        if (userName.equals(eUserName) && password.equals(ePassword)) {
            app.dispose();
            SwingUtilities.invokeLater(() -> {
                ViewController vc = new ViewController();
                vc.startApplication();
            });
        } else if (userName.equals(eUserName)){
            System.out.println("Wrong password!");
        } else {
            System.out.println("No Username found!");
        }
        passwordInterface.restartField();

    }


}
