package org.motorph.view.screen;

import org.motorph.utility.styling.ColorUtility;

import javax.swing.*;
import java.awt.*;

public class EmployeeDetailsScreen extends ScreenView {

    public EmployeeDetailsScreen() {
        super("Employee Details");
    }

//    @Override
//    public JPanel setUp() {
//        JPanel panel = new JPanel();
//        panel.setBackground(Color.ORANGE);
//
//        return panel;
//    }
    @Override
    public JPanel body() {
        JPanel b = new JPanel();
        b.setBackground(ColorUtility.redLight);
        b.setSize(500, 30);
        return b;
    }

    @Override
    public JLabel setLabel() {
        return new JLabel("Employee");
    }
}
