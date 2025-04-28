package org.motorph.controller;

import org.motorph.view.MainApplication;
import org.motorph.view.screen.EmployeeDetailsScreen;
import org.motorph.view.screen.PayrollScreen;

import javax.swing.*;
import java.awt.*;

public class MainAppViewController {
    private MainApplication psApp;

    public MainAppViewController() {
        this.psApp = new MainApplication("MotorPH Payroll System");
    }

    public void start() {
        psApp.start();
    }

//    private void tabPanelOptions() {
//        JButton dashBoardBtn = new JButton("Dash Board");
//        JButton employeeDetailBtn = new JButton("Employee Details");
//        JButton printPayrollBtn = new JButton("Print Payroll");
//
//        tabPanel.add(dashBoardBtn);
//        tabPanel.add(employeeDetailBtn);
//        tabPanel.add(printPayrollBtn);
//
//        dashBoardBtn.addActionListener(e -> showOnScreenPanel(dashboardController.getPanel()));
//        employeeDetailBtn.addActionListener(e -> showOnScreenPanel(new EmployeeDetailsScreen().getView()));
//        printPayrollBtn.addActionListener(e -> showOnScreenPanel(new PayrollScreen().getView()));
//    }


//    private void showOnScreenPanel(JPanel newScreen) {
//        screenPanel.removeAll();
//        screenPanel.add(newScreen);
//        screenPanel.revalidate();
//        screenPanel.repaint();
//    }



}
