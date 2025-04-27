package org.motorph.view;

import javax.swing.*;
import java.awt.*;

public class PasswordInterface {
    private JFrame passwordInterface;
    private JTextField userName;
    private JTextField password;
    private JButton submitButton;

    public PasswordInterface(String title) {
        this.userName = new JTextField(16);
        this.password = new JTextField(16);
        this.submitButton = new JButton("Submit");
        this.passwordInterface = setUpFrame(title);
    }

    private JFrame setUpFrame(String title) {
        JFrame passUI = new JFrame(title);
        passUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        passUI.setLocation(1250,120);
        passUI.setSize(350, 220);
        passUI.setLayout(new FlowLayout());
        passUI.add(entry());

        return passUI;
    }

    public JPanel entry() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6,1));
        panel.add(new JPanel());
        panel.add(newRow("Username", userName));
        panel.add(newRow("Password", password));
        panel.add(new JPanel());
        panel.add(submitButton);

        return panel;
    }

    private JPanel newRow(String str, JTextField e) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setSize(100, 50);
        panel.add(new JLabel(str), BorderLayout.WEST);
        panel.add(e, BorderLayout.EAST);
        return panel;
    }

    public JFrame getApp() {
        return this.passwordInterface;
    }



}
