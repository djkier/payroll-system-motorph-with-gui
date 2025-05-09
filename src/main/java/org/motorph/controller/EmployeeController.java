package org.motorph.controller;

import org.motorph.model.datarepositories.DataProcessRepo;
import org.motorph.model.datarepositories.EmployeeRepository;
import org.motorph.view.screen.EmployeeDetailsScreen;
import org.motorph.view.screen.components.TableScreen;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.ArrayList;

public class EmployeeController {
    private EmployeeDetailsScreen emp;
    private DataProcessRepo repository;
    private EmployeeRepository employeeRepository;

    public EmployeeController(DataProcessRepo repository) {
        this.repository = repository;
        this.employeeRepository = repository.getEmployeeRepository();
        this.emp = new EmployeeDetailsScreen(repository.getEmployeeRepository());


        tableUpdater(emp.getSearchBar());

    }

    private void tableUpdater(JTextField searchBar) {
        searchBar.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                showEmployee();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                showEmployee();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                showEmployee();
            }

            private void showEmployee() {
                //refactor this from the model
                ArrayList<String> availableData = employeeRepository.getEmployeeWithIdStartsWith(searchBar.getText().trim());
                Object[][] data;

                if (!availableData.isEmpty()) {
                    data = employeeRepository.getEmployeeTableUsingId(availableData);
                } else {
                    data = new Object[][]{{"", "No Record Found", "", ""}};
                }

                emp.updateTableValues(data);
            }

        });
    }




    public JPanel getPanel() {
        return this.emp.getView();
    }
}
