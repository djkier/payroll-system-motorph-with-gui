package org.motorph.controller;

import org.motorph.view.screen.DashBoardScreen;

import javax.swing.*;

public class DashboardController {
    private DashBoardScreen dashboardScreen;
    private String user;


    public DashboardController(String user) {
        this.dashboardScreen = new DashBoardScreen(user);
        this.user = user;
    }

    public JPanel getPanel() {

        return dashboardScreen.getView();
    }
}
