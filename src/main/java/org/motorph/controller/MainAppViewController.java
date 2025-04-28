package org.motorph.controller;

import org.motorph.view.MainApplication;
import org.motorph.view.screen.EmployeeDetailsScreen;
import org.motorph.view.screen.PayrollScreen;
import org.motorph.view.tab.Tab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainAppViewController {
    private MainApplication psApp;
    private DashboardController dashboard;
    private EmployeeController employee;
    private PayrollController payslip;

    public MainAppViewController() {
        this.dashboard = new DashboardController();
        this.employee = new EmployeeController();
        this.payslip = new PayrollController();

        this.psApp = new MainApplication("MotorPH Payroll System", dashboard.getPanel());
        tabEvents();
    }

    public void start() {
        psApp.start();
    }

    public void tabEvents() {
        tabClick(psApp.dashboardTab(), dashboard.getPanel());
        tabClick(psApp.empDetailsTab(), employee.getPanel());
        tabClick(psApp.paySlipTab(), payslip.getPanel());
    }

    public void tabClick(JPanel tab, JPanel newScreen) {
        tab.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                psApp.changePanel(newScreen);
            }
        });
    }
}
