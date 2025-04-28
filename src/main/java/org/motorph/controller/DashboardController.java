package org.motorph.controller;

import org.motorph.view.screen.DashBoardScreen;

import javax.swing.*;

public class DashboardController {
    private DashBoardScreen dashboardScreen;


    public DashboardController() {

        this.dashboardScreen = new DashBoardScreen();
    }

    public JPanel getPanel() {

        return dashboardScreen.getView();
    }
}
