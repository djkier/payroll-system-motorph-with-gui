package org.motorph.view;

import org.motorph.utility.styling.ColorUtility;
import org.motorph.utility.styling.EffectsUtility;
import org.motorph.utility.styling.FontUtility;
import org.motorph.utility.ImageUtility;
import org.motorph.utility.styling.TextFieldUtility;

import javax.swing.*;
import java.awt.*;

public class PasswordInterface {
    private JFrame passwordInterface;
    private JTextField userName;
    private JPasswordField password;
    private JButton submitButton;
    private JPanel entryPanel;


    public PasswordInterface(String title) {
        this.userName = TextFieldUtility.textField(16);
        this.password = TextFieldUtility.passwordField(16);
        this.submitButton = setUpSubmitButton("Submit");
        this.entryPanel = entryField(new JLabel());
        this.passwordInterface = setUpFrame(title);
        this.passwordInterface.getRootPane().setDefaultButton(submitButton);


    }

    //use to set up the password interface window
    private JFrame setUpFrame(String title) {
        JFrame passUI = new JFrame(title);
        passUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        passUI.setLocation(-1350,200);
        passUI.setSize(650, 280);
        passUI.setResizable(false);
        passUI.getContentPane().setBackground(ColorUtility.white);


        //Change login window icon
        ImageIcon icon = ImageUtility.importImages("/images/keyIcon.png");
        Image img = icon.getImage();
        passUI.setIconImage(img);

        passUI.setLayout(new FlowLayout());
        //Add banner
        JLabel resizedLogo = ImageUtility.importedImagesInJLabel("/images/passwordLogo.png");
        passUI.add(resizedLogo);
        //Add the username and password panel
        passUI.add(entryPanel);

        return passUI;
    }

    public JPanel entryField(JLabel label) {
        //Set up the label that will appear when admin and password is invalid
        label.setForeground(ColorUtility.redDark);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        //Set the username and password field
        JPanel panel = new JPanel();
        panel.setSize(200, 300);
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
        passwordInterface.remove(entryPanel);

        //reinstate
        entryPanel = entryField(new JLabel("Invalid username or password."));
        passwordInterface.add(entryPanel);
        passwordInterface.revalidate();
        passwordInterface.repaint();
        passwordInterface.getRootPane().setDefaultButton(submitButton);

    }

    //Will be used in creation of the Username/password with  their respecting field
    private JPanel newRow(String str, JTextField e) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        //panel bg transparent
        panel.setBackground(new Color(0,0,0,0));

        //Use this to change the font of username and password
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
        return new String(pw);
    }

    public JButton setUpSubmitButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(FontUtility.important(14));
        btn.setBackground(ColorUtility.violetDark);
        btn.setForeground(ColorUtility.white);
//        btn.setBorder(BorderFactory.createEtchedBorder());
        EffectsUtility.mouseHover(btn, ColorUtility.violetDark, ColorUtility.graySurface);

        return btn;
    }




}
