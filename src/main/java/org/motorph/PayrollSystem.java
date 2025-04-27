package org.motorph;

import org.motorph.controller.PasswordController;
import org.motorph.controller.ViewController;
import org.motorph.view.PasswordInterface;

import javax.swing.SwingUtilities;


public class PayrollSystem {
    public static void main(String[] args) {
        //load the preload employee details and attendance

        //open the app
        SwingUtilities.invokeLater(() -> {
            PasswordController main = new PasswordController();
            main.start();

        });

    }
}