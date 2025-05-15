package org.motorph.view.screen;

import org.motorph.utility.styling.ColorUtility;
import org.motorph.utility.styling.EffectsUtility;
import org.motorph.utility.styling.FontUtility;
import org.motorph.view.screen.components.TableScreen;
import org.motorph.view.tab.Tab;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PayrollScreen extends ScreenView {

    public PayrollScreen() {
        setPanel(setUp());
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
        horizontalDivider.setBounds(20, 140,744, 2);

        JPanel table = tablePanel();
        table.setBounds(0,150,780,500);


        b.add(horizontalDivider);
        b.add(table);
        b.add(selection);

        return b;
    }

    @Override
    public String setLabel() {
        return "Payslip & Reports";
    }

    //Choose Date range for payslip /report
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


        JPanel errorMessageStart = errorMessage();
        JPanel errorMessageEnd = errorMessage();


        title.setBounds(0, 0, 400, 20);

        fullMonthRadio.setBounds(50,30,150,50);
        customRangeRadio.setBounds(50, 70, 150, 50);
        cardPanel.setBounds(210, 30, 800, 90);
        errorMessageStart.setBounds(294,68, 100, 20);
        errorMessageEnd.setBounds(536,68, 100, 20);


        panel.add(title);
        panel.add(fullMonthRadio);
        panel.add(customRangeRadio);
        panel.add(errorMessageStart);
        panel.add(errorMessageEnd);
        panel.add(cardPanel);

        //set error message false
        errorMessageStart.setVisible(false);
        errorMessageEnd.setVisible(false);




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



    private JPanel errorMessage() {
        JPanel panel = new JPanel();
        panel.setBackground(ColorUtility.transparent);
        panel.setLayout(null);

        JLabel invalid = new JLabel("INVALID");
        invalid.setFont(FontUtility.important(10));
        invalid.setForeground(ColorUtility.redDark);
        invalid.setBounds(0,0,100,20);




        panel.add(invalid);

        return panel;
    }

    //table
    private JPanel tablePanel() {
        JPanel panel = new JPanel();
        panel.setBackground(ColorUtility.white);
        panel.setLayout(null);


        JPanel tableTop = tableTop();
        tableTop.setBackground(ColorUtility.white);


        JScrollPane table = TableScreen.payslipTable();

        JPanel numberSelectedPanel = numberSelected();

        JPanel tableBottom = tableBottom();



        tableTop.setBounds(20,0,744,40);
        numberSelectedPanel.setBounds(562,38,200,20);
        table.setBounds(20,60,744,392);
        tableBottom.setBounds(160,460,500,30);

        panel.add(tableTop);
        panel.add(numberSelectedPanel);
        panel.add(tableBottom);
        panel.add(table);


        return panel;

    }

    private JPanel tableTop() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("Searched by:");
        label.setFont(FontUtility.important(14));

        JPanel radioBtn = radioBtn();

        JTextField searchArea = new JTextField(18);

        JPanel searchBar = EffectsUtility.searchField(searchArea);
        searchBar.setBackground(ColorUtility.white);

        JPanel selectAll = selectorButton("Select All", ColorUtility.greenLightHover, ColorUtility.greenDark);
        JPanel unselectAll = selectorButton("Unselect All", ColorUtility.redDark, ColorUtility.redDarkHover);


        label.setBounds(0,0,150,20);
        searchBar.setBounds(134,0,240,40);
        radioBtn.setBounds(0,20,140,20);

        selectAll.setBounds( 430,8,150,24);
        unselectAll.setBounds(600,8,150,24);

        panel.add(label);
        panel.add(searchBar);
        panel.add(radioBtn);

        panel.add(selectAll);
        panel.add(unselectAll);


        return panel;
    }

    private JPanel tableBottom(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(ColorUtility.white);

        JPanel payslipButton = selectorButton("Print Payslip/s", ColorUtility.blueBright, ColorUtility.blueDark);

        JPanel reportButton = selectorButton("Print Payroll Summary", ColorUtility.blueBright, ColorUtility.blueDark);

        payslipButton.setBounds(0,0,200,30);
        reportButton.setBounds(230,0,200,30);

        panel.add(payslipButton);
        panel.add(reportButton);

        return panel;
    }

    private JPanel selectorButton(String buttonName, Color lightColor, Color darkColor) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        panel.setBackground(lightColor);

        JLabel addNew = new JLabel(buttonName);
        addNew.setFont(FontUtility.important(12));
        addNew.setForeground(ColorUtility.white);
        addNew.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(addNew, BorderLayout.CENTER);

        EffectsUtility.panelHover(panel, lightColor, darkColor);

        return panel;
    }

    private JPanel radioBtn() {
        JPanel panel = new JPanel();

        panel.setLayout(new BorderLayout());

        JRadioButton idBtn = radioBtn("ID");
        idBtn.setPreferredSize(new Dimension(50,20));
        idBtn.setBackground(ColorUtility.white);

        JRadioButton lnBtn = radioBtn("Last Name");
        lnBtn.setBackground(ColorUtility.white);

        ButtonGroup group = new ButtonGroup();
        group.add(idBtn);
        group.add(lnBtn);
        idBtn.setSelected(true);


        panel.add(idBtn, BorderLayout.WEST);
//        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        panel.add(lnBtn, BorderLayout.CENTER);

        return panel;
    }

    private JRadioButton radioBtn(String label) {
        JRadioButton btn = new JRadioButton(label);
        btn.setBackground(ColorUtility.white);
        btn.setFont(FontUtility.plain(12));
        btn.setForeground(ColorUtility.grayDark);
        btn.setFocusPainted(false);

        return btn;
    }

    private JPanel numberSelected() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(ColorUtility.white);

        JLabel numberOfSelected = new JLabel("100 employees selected");
        numberOfSelected.setFont(FontUtility.plainItalic(12));

        panel.add(numberOfSelected, BorderLayout.EAST);

        return panel;
    }

}
