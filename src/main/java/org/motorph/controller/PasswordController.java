package org.motorph.controller;


import org.motorph.view.PasswordInterface;

import javax.swing.*;

public class PasswordController {
    private PasswordInterface passwordInterface;

    public PasswordController() {
        this.passwordInterface = new PasswordInterface("Login");
    }

    public void start() {
        passwordInterface.getApp().setVisible(true);
    }


}
