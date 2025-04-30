package org.motorph;

import org.motorph.controller.MainAppViewController;
import org.motorph.controller.PasswordController;
import org.motorph.model.FileHandler;

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
        SwingUtilities.invokeLater(() -> {
            MainAppViewController mainApp = new MainAppViewController("Admin");
            mainApp.start();
        });


    }
}