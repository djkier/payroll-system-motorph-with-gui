package org.motorph.view.screen;

import org.motorph.utility.styling.ColorUtility;

import javax.swing.*;
import java.awt.*;

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
        b.setBackground(ColorUtility.greenDark);
        b.setSize(500, 30);
        return b;
    }

    @Override
    public JLabel setLabel() {
        return new JLabel("Dashboard");
    }

}
