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
//        SwingUtilities.invokeLater(() -> {
//            MainAppViewController mainApp = new MainAppViewController("Admin");
//            mainApp.start();
//        });

        FileHandler fh = new FileHandler();
        fh.preLoadEmpDetails();
        fh.preLoadAttendance();
        System.out.println("start");
        fh.getRepository().findInstanceLastName("ae");
        System.out.println("----------");
        fh.getRepository().findInstanceLastName("b");
        System.out.println("----------");
        fh.getRepository().findInstanceLastName("c");
        System.out.println("----------");
        fh.getRepository().findInstanceLastName("d");
        System.out.println("End");

    }
}