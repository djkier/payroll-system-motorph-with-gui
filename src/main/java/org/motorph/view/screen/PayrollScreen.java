package org.motorph.view.screen;

import org.motorph.utility.styling.ColorUtility;
import org.motorph.utility.styling.EffectsUtility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PayrollScreen extends ScreenView {

    public PayrollScreen() {
        super("Payslip & Reports");
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
        b.setBackground(ColorUtility.transparent);
        b.setLayout(null);

        JPanel selection = selection();
        selection.setBounds(0,0, 600, 400);

        b.add(selection);

        return b;
    }

    @Override
    public String setLabel() {
        return "Payslip & Reports";
    }

    private JPanel selection(){
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JRadioButton fullMonthRadio = new JRadioButton("Full / Half Month");
        fullMonthRadio.setFocusPainted(false);

        JRadioButton customRangeRadio = new JRadioButton("Custom Range");
        customRangeRadio.setFocusPainted(false);

        ButtonGroup group = new ButtonGroup();
        group.add(fullMonthRadio);
        group.add(customRangeRadio);

        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(null);

        JPanel fullMonthPanel = fullMonthPanel();
        fullMonthPanel.setBounds(0, 0, 400, 50);

        JPanel customRangePanel = customRangePanel();
        customRangePanel.setBounds(0, 70, 400, 50);

        //default full month selection
        fullMonthRadio.setSelected(true);
        optionsComponent(fullMonthPanel, customRangePanel);


        cardPanel.add(fullMonthPanel);
        cardPanel.add(customRangePanel);


        fullMonthRadio.addActionListener(e -> {
            optionsComponent(fullMonthPanel, customRangePanel);
        });

        customRangeRadio.addActionListener(e -> {
            optionsComponent(customRangePanel, fullMonthPanel);
        });

        fullMonthRadio.setBounds(0,0,150,50);
        customRangeRadio.setBounds(0, 60, 150, 50);
        cardPanel.setBounds(150, 0, 500, 200);

        panel.add(fullMonthRadio);
        panel.add(customRangeRadio);
        panel.add(cardPanel);


        return EffectsUtility.marginedBoxText(panel);
    }

    private JPanel fullMonthPanel() {
        JPanel fullMonthPanel = new JPanel();


        fullMonthPanel.add(new JLabel("Cutoff:"));
        String[] type = {"Full Month", "1st Half", "2nd Half"};
        JComboBox<String> typeOfPayment = new JComboBox<>(type);
        fullMonthPanel.add(typeOfPayment);

        fullMonthPanel.add(new JLabel("Month:"));
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        JComboBox<String> monthSelect = new JComboBox<>(months);
        fullMonthPanel.add(monthSelect);


        return fullMonthPanel;
    }


    private JPanel customRangePanel() {
        JPanel customRangePanel = new JPanel();

        customRangePanel.add(new JLabel("Start Date:"));
        customRangePanel.add(new JTextField(10));
        customRangePanel.add(new JLabel("End Date:"));
        customRangePanel.add(new JTextField(10));


        return customRangePanel;
    }

    private void setEnabledComponent(JPanel panel, boolean bool) {
        for (Component c : panel.getComponents()) {
            c.setEnabled(bool);
        }
    }

    private void optionsComponent(JPanel setTrue, JPanel setFalse) {
        setEnabledComponent(setTrue, true);
        setEnabledComponent(setFalse, false);
    }

}
