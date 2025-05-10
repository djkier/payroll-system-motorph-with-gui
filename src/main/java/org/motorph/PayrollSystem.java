package org.motorph;

import org.motorph.controller.MainAppViewController;
import org.motorph.controller.PasswordController;
import org.motorph.model.FileHandler;
import org.motorph.view.screen.components.AddNewEmployee;

import javax.swing.SwingUtilities;


public class PayrollSystem {
    public static void main(String[] args) {
        //load the preload employee details and attendance

        //Start with password Interface
//        SwingUtilities.invokeLater(() -> {
//            PasswordController main = new PasswordController();
//            main.start();
//
//        });

        //Start with the main app
//        SwingUtilities.invokeLater(() -> {
//            MainAppViewController mainApp = new MainAppViewController("Admin");
//            mainApp.start();
//        });


        //Start with add new employee dialog box
        SwingUtilities.invokeLater(() -> {
            MainAppViewController mainApp = new MainAppViewController("Admin");
            AddNewEmployee addNewEmployee = new AddNewEmployee(mainApp.mainFrame());
            addNewEmployee.makeDialogVisible();
        });


        //features to be implemented
        //when a row is click in employee tab the employee info will appear
        //it will have the employee picture,and other details
        //it will have edit option that when click will ask if needed to save edit or cancel
        //remove button that will remove the employee.

        //payslip still have a search bar and table.
        //add button description how many added
        //button at the bottom to print for payslip


    }
}