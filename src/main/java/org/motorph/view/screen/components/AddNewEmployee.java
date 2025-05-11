package org.motorph.view.screen.components;

import org.motorph.utility.styling.ColorUtility;
import org.motorph.utility.styling.EffectsUtility;

import javax.swing.*;

public class AddNewEmployee {
    private JDialog jDialog;
    private JTextField firstName;

    public AddNewEmployee(JFrame mainFrame) {
        this.firstName = new JTextField(16);

        //Load every instance before loading the main dialog
        this.jDialog = setUpDialog(mainFrame);

    }

    public void makeDialogVisible() {
        jDialog.setVisible(true);
    }

    private JDialog setUpDialog(JFrame frame) {
        JDialog dialog = new JDialog(frame, "Add New Employee", true);
        dialog.setSize(800,600);
//        dialog.setLocationRelativeTo(frame);
        //DELETE THIS after creating the dialog box
        dialog.setLocation(-1450,150);
        dialog.setResizable(false);
        dialog.setBackground(ColorUtility.grayLight);

        //Add the boarded main panel
        dialog.add(EffectsUtility.marginedBoxText(mainPanel(), ColorUtility.grayLight));

        return dialog;
    }

    private JPanel mainPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(ColorUtility.white);

        panel.add(employeeInformation());

        return panel;
    }

    private JPanel employeeInformation() {
        JPanel panel = new JPanel();

        JLabel label = new JLabel("General Information");


        JPanel firstName = textAndField("First Name", this.firstName);
//        JPanel firstName = textAndField("First Name", new JTextField(16));


        panel.add(label);
        panel.add(firstName);

        return EffectsUtility.marginedBoxText(panel,12,12, ColorUtility.white);
    }

    private JPanel idNumbers() {
        JPanel panel = new JPanel();

        return panel;
    }

    private JPanel salaryAndAllowances() {
        JPanel panel = new JPanel();

        return panel;
    }

    private JPanel textAndField(String text, JTextField textField) {
        JPanel firstName = new JPanel();
        JLabel firstNameLabel = new JLabel(text);
        JPanel firstNameTextField = EffectsUtility.searchField(textField);

        firstName.add(firstNameLabel);
        firstName.add(firstNameTextField);

        return firstName;
    }




}
