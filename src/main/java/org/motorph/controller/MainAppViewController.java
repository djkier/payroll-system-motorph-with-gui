package org.motorph.controller;

import org.motorph.model.FileHandler;
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
    private String user;

    public MainAppViewController(String user) {
        //model
//        this.file = new FileHandler();


        //view
        this.dashboard = new DashboardController(user);
        this.employee = new EmployeeController();
        this.payslip = new PayrollController();
        this.user = user;


        this.psApp = new MainApplication("MotorPH Payroll System", employee.getPanel());
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

    //restart the values of employee and payslip when loaded a new file

    public void tabClick(JPanel tab, JPanel newScreen) {
        tab.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                psApp.changePanel(newScreen);
            }
        });
    }
}
