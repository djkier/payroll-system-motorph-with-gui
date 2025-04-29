package org.motorph.view.screen;

import org.motorph.model.samplefile.TestData;
import org.motorph.utility.styling.ColorUtility;

import javax.swing.*;
import java.awt.*;
import java.io.File;


public class DashBoardScreen extends ScreenView {
    private String user;

    public DashBoardScreen(String user) {
        super("Dashboard");
        this.user = user;
    }

//    @Override
//    public JPanel setUp() {
//        JPanel panel = new JPanel();
//        panel.setBackground(Color.GREEN);
//
//        return panel;
//    }
    @Override
    public JPanel body() {
        JPanel b = new JPanel();
        b.setBackground(ColorUtility.transparent);
        b.setSize(300, 30);

        return b;
    }

    @Override
    public String setLabel() {
        return "Dashboard";
    }

}
