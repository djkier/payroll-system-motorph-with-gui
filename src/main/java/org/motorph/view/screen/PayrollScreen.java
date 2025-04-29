package org.motorph.view.screen;

import org.motorph.utility.styling.ColorUtility;

import javax.swing.*;
import java.awt.*;

public class PayrollScreen extends ScreenView {

    public PayrollScreen() {
        super("Payslip");
    }

//    @Override
//    public JPanel setUp() {
//        JPanel panel = new JPanel();
//        panel.setBackground(Color.CYAN);
//
//        return panel;
//    }

    @Override
    public JPanel body() {
        JPanel b = new JPanel();
        b.setBackground(ColorUtility.grayDark);
        b.setSize(500, 30);
        return b;
    }

    @Override
    public JLabel setLabel() {
        return new JLabel("Payslip");
    }
}
