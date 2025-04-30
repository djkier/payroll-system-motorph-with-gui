package org.motorph.controller;

import org.motorph.view.screen.DashBoardScreen;

import javax.swing.*;

public class DashboardController {
    private DashBoardScreen dashboardScreen;

    public DashboardController(String user) {

        this.dashboardScreen = new DashBoardScreen(user);
    }

    public JPanel getPanel() {
        return dashboardScreen.getView();
    }
}
