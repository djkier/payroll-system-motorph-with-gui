package org.motorph.view.screen.components;

import org.motorph.utility.styling.ColorUtility;
import org.motorph.utility.styling.EffectsUtility;

import javax.swing.*;

public class AddNewEmployee {
    private JDialog jDialog;

    public AddNewEmployee(JFrame mainFrame) {
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

        JLabel label = new JLabel("Hello World!");

        panel.add(label);

        return panel;
    }
}
