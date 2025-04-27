package org.motorph.view;

import javax.swing.*;
import java.awt.*;

public class PasswordInterface {
    private JFrame passwordInterface;
    private JTextField userName;
    private JPasswordField password;
    private JButton submitButton;

    public PasswordInterface(String title) {
        this.userName = new JTextField(16);
        this.password = new JPasswordField(16);
        this.submitButton = new JButton("Submit");
        this.passwordInterface = setUpFrame(title);
        this.passwordInterface.getRootPane().setDefaultButton(submitButton);

    }

    private JFrame setUpFrame(String title) {
        JFrame passUI = new JFrame(title);
        passUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        passUI.setLocation(1250,120);
        passUI.setSize(350, 220);
        passUI.setLayout(new FlowLayout());
        passUI.setResizable(false);
        passUI.getContentPane().setBackground(Color.PINK);

        passUI.add(entryField(new JLabel()));
        return passUI;
    }

    public JPanel entryField(JLabel label) {
        label.setForeground(Color.RED);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6,1));
        panel.add(new JPanel());
        panel.add(newRow("Username", userName));
        panel.add(newRow("Password", password));
        panel.add(label);
        panel.add(submitButton);
        panel.setBackground(Color.PINK);

        return panel;
    }

    public void restartField() {
        userName.setText("");
        password.setText("");
        passwordInterface.getContentPane().removeAll();
        passwordInterface.add(entryField(new JLabel("Invalid username or password.")));
        passwordInterface.revalidate();
        passwordInterface.repaint();
        passwordInterface.getRootPane().setDefaultButton(submitButton);

    }


    private JPanel newRow(String str, JTextField e) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel input = new JLabel(str);

        panel.add(input, BorderLayout.WEST);
        panel.add(e, BorderLayout.EAST);
        return panel;
    }

    public JFrame getApp() {
        return this.passwordInterface;
    }

    public JButton getSubmitButton() {
        return this.submitButton;
    }

    public String getUserNameText() {
        return this.userName.getText();
    }

    public String getPasswordText() {
        char[] pw = password.getPassword();
        System.out.println(pw);
        return new String(pw);
    }




}
