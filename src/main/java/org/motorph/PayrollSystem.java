package org.motorph;

import org.motorph.controller.ViewController;

import javax.swing.SwingUtilities;


public class PayrollSystem {
    public static void main(String[] args) {
        //load the preload employee details and attendance

        //open the app
        SwingUtilities.invokeLater(() -> {
            ViewController main = new ViewController();
            main.startApplication();
        });

    }
}