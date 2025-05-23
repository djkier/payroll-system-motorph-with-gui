package org.motorph.controller;

import org.motorph.model.FileHandler;
import org.motorph.model.datarepositories.DataProcessRepo;
import org.motorph.view.MainApplication;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class MainAppViewController {
    private MainApplication psApp;
    private DashboardController dashboard;
    private EmployeeController employee;
    private PayrollController payslip;
    private String user;

    private FileHandler file;
    private DataProcessRepo dataProcessRepo;

    public MainAppViewController(String user) {
        this.user = user;
        //data
        this.file = new FileHandler();
        this.file.preLoadEmpDetails();
        this.file.preLoadAttendance();
        this.dataProcessRepo = file.getRepository();

//        System.out.println(dataProcessRepo.getEmployeeRepository().getEmployeeById("10001").toString());

        //view
        this.dashboard = new DashboardController();
        this.employee = new EmployeeController(dataProcessRepo);
        this.payslip = new PayrollController();
        dashboardSetUp();

        //App name and the loaded screen when open
        this.psApp = new MainApplication("MotorPH Payroll System");
        this.psApp.changePanel(employee.getPanel());
        tabEvents();
    }

    public void start() {
        psApp.start();
    }

    private void dashboardSetUp() {
        this.dashboard.setUser(user);
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
