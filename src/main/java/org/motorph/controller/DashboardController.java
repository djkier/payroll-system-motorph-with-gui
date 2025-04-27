package org.motorph.controller;

import org.motorph.view.screen.DashBoardScreen;

import javax.swing.*;

public class DashboardController {
    private DashBoardScreen dashBoardScreen;

    public DashboardController() {
        this.dashBoardScreen = new DashBoardScreen();
    }

    public JPanel getPanel() {
        return dashBoardScreen.getView();
    }
}
