package org.motorph.controller;

import org.motorph.model.datarepositories.DataProcessRepo;
import org.motorph.view.screen.EmployeeDetailsScreen;

import javax.swing.*;

public class EmployeeController {
    private EmployeeDetailsScreen emp;
    private DataProcessRepo repository;

    public EmployeeController(DataProcessRepo repository) {
        this.repository = repository;

        this.emp = new EmployeeDetailsScreen(repository.getEmployeeRepository());
    }



    public JPanel getPanel() {
        return this.emp.getView();
    }
}
