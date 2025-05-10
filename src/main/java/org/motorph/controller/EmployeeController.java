package org.motorph.controller;

import org.motorph.model.datarepositories.DataProcessRepo;
import org.motorph.model.datarepositories.EmployeeDetails;
import org.motorph.model.datarepositories.EmployeeRepository;
import org.motorph.view.screen.EmployeeDetailsScreen;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeController {
    private EmployeeDetailsScreen employeeView;
    private DataProcessRepo repository;
    private EmployeeRepository employeeRepository;
    private HashMap<String, EmployeeDetails> employeeHashMap;
    private JFrame mainFrame;

    public EmployeeController(DataProcessRepo repository) {
        this.repository = repository;
        this.employeeRepository = repository.getEmployeeRepository();
        this.employeeHashMap = repository.getEmployeeRepository().getRepository();
        this.employeeView = new EmployeeDetailsScreen(repository.getEmployeeRepository());
        this.mainFrame = new JFrame();

        addNewEmployee(employeeView.getAddNewButton());
        tableUpdater(employeeView.getSearchBar());
        rowClickAction(employeeView.getTable());
    }

    public JPanel getPanel() {
        return this.employeeView.getView();
    }

    public void setFrame(JFrame frame) {
        this.mainFrame = frame;
    }

    private void addNewEmployee(JPanel addNewButton) {
        addNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Add new employees!");
                JDialog dialog = new JDialog(mainFrame, "My Dialog", true);
                dialog.setSize(300, 200);
                dialog.setLocationRelativeTo(mainFrame); // center on parent
                dialog.setResizable(true); // optional
                dialog.add(new JLabel("Hello from JDialog"), SwingConstants.CENTER);
                dialog.setVisible(true);
            }
        });
    }

    //Updates the values of the cells in the employee screen
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

                ArrayList<String> availableData = employeeView.isIdSelectedInRadio() ?
                        getEmployeeWithIdStartsWith(searchBar.getText()) :  //ID is selected
                        getEmployeeWithLastnameStartsWith(searchBar.getText());  //Lastname is selected

                Object[][] data = !availableData.isEmpty() ?
                        getEmployeeDataForTableUsingId(availableData) : //process if there is an available data
                        new Object[][]{{"-", "No Record Found", "-", "-", "-"}};


                employeeView.updateTableValues(data);
            }

        });
    }

    // Returns all IDs that start with the given text
    private ArrayList<String> getEmployeeWithIdStartsWith(String text) {
        String trimmedText = text.trim();
        ArrayList<String> availableData = new ArrayList<>();
        for (String key : employeeHashMap.keySet()) {
            if(key.startsWith(trimmedText)) {
                availableData.add(key);
            }
        }


        return availableData;
    }

    //Return a list of ID that has a last name that starts with the given text
    private ArrayList<String> getEmployeeWithLastnameStartsWith(String text) {
        ArrayList<String> availableData= new ArrayList<>();
        String reformedString = text.trim().toLowerCase();


        for (String key : employeeHashMap.keySet()) {
            String reformedLastName = employeeHashMap.get(key).getLastName().trim().toLowerCase();
            if (reformedLastName.startsWith(reformedString)) {
                availableData.add(key);
            }
        }

        return availableData;
    }

    //Return the data for the table
    private Object[][] getEmployeeDataForTableUsingId(ArrayList<String> listOfId) {

        ArrayList<String> sortedId = listOfId.stream()
                .map(Integer::valueOf)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.toCollection(ArrayList::new));

        return tableData(sortedId);
    }

    //Data processor for the table
    private Object[][] tableData(ArrayList<String> sortedList) {
        List<Object[]> dataList = new ArrayList<>();
        for (String id : sortedList) {
            dataList.add(new Object[] {
                    employeeHashMap.get(id).getId(),
                    employeeHashMap.get(id).getFullName(),
                    employeeHashMap.get(id).getBirthDate(),
                    employeeHashMap.get(id).getPosition(),
                    employeeHashMap.get(id).getStatus()
            });
        }

        return dataList.toArray(new Object[dataList.size()][]);
    }

    //Cell listener
    private void rowClickAction(JTable table) {
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && table.getSelectedColumn() != -1) {
                    int row = table.getSelectedRow();
                    Object value = table.getValueAt(row, 0);
                    System.out.println(value);
                }
            }
        });
    }





}
