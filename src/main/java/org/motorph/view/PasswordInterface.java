package org.motorph.view;

import org.motorph.PayrollSystem;

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

    //use to set up the password interface window
    private JFrame setUpFrame(String title) {
        JFrame passUI = new JFrame(title);
        passUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        passUI.setLocation(1250,120);
        passUI.setSize(350, 220);
        passUI.setLayout(new FlowLayout());
        passUI.setResizable(false);
        passUI.getContentPane().setBackground(Color.WHITE);

        //Change password window Icon
        ImageIcon icon = new ImageIcon(PayrollSystem.class.getResource("/images/keyIcon.png"));
        Image img = icon.getImage();
        passUI.setIconImage(img);

        //Add the username and password panel
        passUI.add(entryField(new JLabel()));

        return passUI;
    }

    public JPanel entryField(JLabel label) {
        //Set up the label that will appear when admin and password is invalid
        label.setForeground(Color.RED);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        //Set the username and password field
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6,1));
        panel.add(new JLabel());
        panel.add(newRow("Username", userName));
        panel.add(newRow("Password", password));
        panel.add(label);
        panel.add(submitButton);
        panel.setBackground(new Color(0, 0, 0, 0));

        return panel;
    }

    //Refresh the entry on the username and password for invalid or incorrect input
    public void restartField() {
        userName.setText("");
        password.setText("");
        passwordInterface.getContentPane().removeAll();
        passwordInterface.add(entryField(new JLabel("Invalid username or password.")));
        passwordInterface.revalidate();
        passwordInterface.repaint();
        passwordInterface.getRootPane().setDefaultButton(submitButton);

    }

    //Will be used in creation of the Username/password with  their respecting field
    private JPanel newRow(String str, JTextField e) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(0,0,0,0));

        //Use this if you want to change the font of username and password
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
