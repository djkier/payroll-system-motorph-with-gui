package org.motorph.controller;

import org.motorph.view.screen.EmployeeDetailsScreen;

import javax.swing.*;

public class EmployeeController {
    private EmployeeDetailsScreen emp;

    public EmployeeController() {
        this.emp = new EmployeeDetailsScreen();
    }

    public JPanel getPanel() {
        return this.emp.getView();
    }
}
