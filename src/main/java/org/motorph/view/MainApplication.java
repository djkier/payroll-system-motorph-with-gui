package org.motorph.view;

import javax.swing.*;
import java.awt.*;

public class MainApplication {
    private JFrame app;
    private JPanel screenPanel;
    private JPanel tabPanel;

    public MainApplication(String appTitle) {
        this.app = setUpApp(appTitle);
        this.screenPanel = setUpScreen();
        this.tabPanel = setTabPanel();

    }

    private JFrame setUpApp(String title) {
        JFrame w = new JFrame(title);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setLocation(1250,120);
        w.setSize(450, 450);
        //Set true after development
//        setLocationRelativeTo(null);
        w.setLayout(new BorderLayout());
        w.setResizable(false);
        return w;
    }

    private JPanel setUpScreen() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        return panel;
    }

    private JPanel setTabPanel() {
        JPanel tab = new JPanel();
        tab.setBackground(Color.RED);
        tab.setPreferredSize(new Dimension(100, 0));
        return tab;
    }

    public JFrame getApp() {
        return this.app;
    }

    public JPanel getScreenPanel() {
        return this.screenPanel;
    }

    public JPanel getTabPanel() {
        return this.tabPanel;
    }






}
