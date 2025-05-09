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
    private JTextField searchBar;

    public EmployeeController(DataProcessRepo repository) {
        this.repository = repository;
        this.employeeRepository = repository.getEmployeeRepository();
        this.emp = new EmployeeDetailsScreen(repository.getEmployeeRepository());
        this.searchBar = emp.getSearchBar();

        searchBar.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { showEmployee(); }

            @Override
            public void removeUpdate(DocumentEvent e) { showEmployee(); }

            @Override
            public void changedUpdate(DocumentEvent e) { showEmployee(); }

            private void showEmployee() {
                ArrayList<String> availableData = employeeRepository.getEmployeeWithIdStartsWith(searchBar.getText().trim());
                Object[][] data;

                if (!availableData.isEmpty()) {
                    data = employeeRepository.getEmployeeTableUsingId(availableData);
                } else {
                    data = new Object[][]{{"", "No Record Found", "", ""}};
                }

//                for (Object[] d : data) {
//                    System.out.println(d[0]);
//                }

                emp.updateTableValues(data);
            }

        });

//
//
//
////                JScrollPane newScrollPane = TableScreen.employeeTable(data);
////                newScrollPane.setBounds(28, 100, 724, 370);
////                newScrollPane.setName("newScrollPane");
////
////                if (isComponentIsExisting("newScrollPane")) {
////                    removeByName("newScrollPane");
////                    panel.add(newScrollPane);
////                } else {
////                    panel.remove(scrollPane);
////                    panel.add(newScrollPane);
////                }
////
////
////                panel.revalidate();
////                panel.repaint();
//
//
//
//            }
//
//            );
//
//        }
    }




    public JPanel getPanel() {
        return this.emp.getView();
    }
}
