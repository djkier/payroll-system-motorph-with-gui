package org.motorph.view.screen;

import org.motorph.utility.styling.ColorUtility;
import org.motorph.utility.styling.EffectsUtility;
import org.motorph.utility.styling.FontUtility;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        selection.setBounds(0,0, 800, 230);

        JPanel horizontalDivider = EffectsUtility.horizontalDivider(2, ColorUtility.grayBorder);
        horizontalDivider.setBounds(20, 210,744, 2);

        b.add(horizontalDivider);
        b.add(selection);


        return b;
    }

    @Override
    public String setLabel() {
        return "Payslip & Reports";
    }

    private JPanel selection(){
        JPanel panel = new JPanel();
        panel.setBackground(ColorUtility.white);
        panel.setLayout(null);


        JLabel title = new JLabel("Choose Date Range for Payslip / Report");
        title.setFont(FontUtility.important(16));

        JRadioButton fullMonthRadio = new JRadioButton("Full/Half Month");
        fullMonthRadio.setBackground(ColorUtility.white);
        fullMonthRadio.setFont(FontUtility.important(14));
        fullMonthRadio.setFocusPainted(false);

        JRadioButton customRangeRadio = new JRadioButton("Custom Range");
        customRangeRadio.setBackground(ColorUtility.white);
        customRangeRadio.setFont(FontUtility.important(14));
        customRangeRadio.setFocusPainted(false);

        ButtonGroup group = new ButtonGroup();
        group.add(fullMonthRadio);
        group.add(customRangeRadio);

        JPanel cardPanel = new JPanel();
        cardPanel.setBackground(ColorUtility.white);
        cardPanel.setLayout(null);

        JPanel fullMonthPanel = fullMonthPanel();
        fullMonthPanel.setBackground(ColorUtility.white);
        fullMonthPanel.setBounds(0, 6, 700, 40);

        JPanel customRangePanel = customRangePanel();
        customRangePanel.setBackground(ColorUtility.white);
        customRangePanel.setBounds(13, 56, 700, 80);

        //default full month selection
        fullMonthRadio.setSelected(true);
        fullMonthRadio.setBackground(ColorUtility.white);
        optionsComponent(fullMonthPanel, customRangePanel);


        cardPanel.add(fullMonthPanel);
        cardPanel.add(customRangePanel);


        fullMonthRadio.addActionListener(e -> {
            optionsComponent(fullMonthPanel, customRangePanel);
        });

        customRangeRadio.addActionListener(e -> {
            optionsComponent(customRangePanel, fullMonthPanel);
        });

        JPanel generateButton = generateButton();

        JPanel errorMessage = errorMessage();



        title.setBounds(0, 0, 400, 20);

        fullMonthRadio.setBounds(50,30,150,50);
        customRangeRadio.setBounds(50, 70, 150, 50);
        cardPanel.setBounds(210, 30, 800, 90);
        errorMessage.setBounds(0,125, 754, 25);
        generateButton.setBounds(280, 154, 180,30);

        panel.add(title);
        panel.add(fullMonthRadio);
        panel.add(customRangeRadio);
        panel.add(cardPanel);
        panel.add(errorMessage);
        panel.add(generateButton);



        return EffectsUtility.marginedBoxText(panel);
    }

    private JPanel fullMonthPanel() {
        JPanel fullMonthPanel = new JPanel();
        fullMonthPanel.setLayout(null);

        //CUT OFF
        String[] type = {"Full Month", "1st Half", "2nd Half"};
        JPanel typeOfPayment = labelAndComboBox("Cut Off", type);
        typeOfPayment.setBounds(0,0, 170,70);


        //MONTH OPTIONS
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        JPanel chooseMonth = labelAndComboBox("Month", months);
        chooseMonth.setBounds(175, 0, 170,70);


        //YEAR OPTIONS
        String[] years = {"2024", "2025", "2026"};
        JPanel chooseYear = labelAndComboBox("Year", years);
        chooseYear.setBounds(355, 0, 130,70);


        fullMonthPanel.add(typeOfPayment);
        fullMonthPanel.add(chooseMonth);
        fullMonthPanel.add(chooseYear);

        return fullMonthPanel;
    }

    private JPanel labelAndComboBox(String title, String[] options) {
        JPanel panel = new JPanel();
        panel.setBackground(ColorUtility.white);

        JLabel label = new JLabel(title);
        label.setPreferredSize(new Dimension(50, 20));
        if (title.equalsIgnoreCase("Year")) {
            label.setPreferredSize(new Dimension(40, 20));
        }
        label.setFont(FontUtility.important(12));
        label.setHorizontalAlignment(SwingConstants.LEFT);

        JComboBox<String> list = new JComboBox<>(options);
        list.setFont(FontUtility.plain(12));
        list.setBackground(ColorUtility.white);
        list.setBorder(new LineBorder(ColorUtility.grayBorder));

        panel.add(label);
        panel.add(list);

        return panel;
    }


    private JPanel customRangePanel() {
        JPanel customRangePanel = new JPanel();
        customRangePanel.setLayout(null);

        JPanel startDate = dateAndTextfield("Start Date");
        startDate.setBounds(0,0,240,80);

        JPanel endDate = dateAndTextfield("End Date");
        endDate.setBounds(242,0,240,80);

        JLabel rangeIssue = new JLabel("No Record Found!");

        customRangePanel.add(startDate);
        customRangePanel.add(endDate);

        return customRangePanel;
    }

    private JPanel dateAndTextfield(String title) {
        JPanel panel = new JPanel();
        panel.setBackground(ColorUtility.white);
        panel.setLayout(null);

        JLabel label = new JLabel(title);
        JTextField textField = new JTextField(10);
        JLabel hint = new JLabel("mm-dd-yyyy");
        hint.setFont(FontUtility.plainItalic(11));
        hint.setForeground(ColorUtility.grayDark);

        label.setBounds(0,0,70,20);
        textField.setBounds(70,0,150,20);
        hint.setBounds(74,16,150,20);

        panel.add(label);
        panel.add(textField);
        panel.add(hint);

        return panel;

    }

    private void setEnabledComponent(JPanel panel, boolean bool) {
        for (Component c : panel.getComponents()) {
            //Target components inside a component
            if (c instanceof JComponent insideComp) {
                for (Component i : insideComp.getComponents()) {
                    i.setEnabled(bool);
                }
            }

            c.setEnabled(bool);
        }
    }

    private void optionsComponent(JPanel setTrue, JPanel setFalse) {
        setEnabledComponent(setTrue, true);
        setEnabledComponent(setFalse, false);
    }

    private JPanel generateButton() {
        JPanel panel = new JPanel();

        panel.setBackground(ColorUtility.greenDark);

        JLabel addNew = new JLabel("Generate");
        addNew.setFont(FontUtility.important(14));
        addNew.setForeground(ColorUtility.white);

        panel.add(addNew);

        EffectsUtility.panelHover(panel, ColorUtility.greenDark, ColorUtility.greenLight);

        return panel;
    }

    private JPanel errorMessage() {
        JPanel panel = new JPanel();
        panel.setBackground(ColorUtility.white);

        JLabel invalid = new JLabel("Invalid start date");
        invalid.setFont(FontUtility.important(12));
        invalid.setForeground(ColorUtility.redDark);

        panel.add(invalid);

        return panel;
    }

}
