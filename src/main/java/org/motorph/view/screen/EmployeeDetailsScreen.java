package org.motorph.view.screen;

import org.motorph.model.samplefile.TestData;
import org.motorph.utility.styling.ColorUtility;
import org.motorph.utility.styling.EffectsUtility;
import org.motorph.utility.styling.FontUtility;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EmployeeDetailsScreen extends ScreenView {

    public EmployeeDetailsScreen() {
        super("Employee Details");
    }

//    @Override
//    public JPanel setUp() {
//        JPanel panel = new JPanel();
//        panel.setBackground(Color.ORANGE);
//
//        return panel;
//    }

    @Override
    public JPanel body() {
        JPanel panel = new JPanel();
        panel.setBackground(ColorUtility.white);
        panel.setLayout(null);

        JPanel total = employeeHeader();
        total.setBounds(16,16,740,120);

        JPanel grayStripe1 = EffectsUtility.horizontalMargin(24);
        grayStripe1.setBounds(0,152, 800, 24);

        JPanel searchTitle = searchTitle();
        searchTitle.setBounds(0, 176,740,50);


        panel.add(total);
        panel.add(grayStripe1);
        panel.add(searchTitle);


        return panel;
    }

    @Override
    public String setLabel() {
        return "Employee";
    }

    private JPanel employeeHeader() {
        JPanel panel = new JPanel();
        panel.setBackground(ColorUtility.white);
        panel.setLayout(new GridLayout(1,3));

        panel.add(compHeader("Employee", 34));
        panel.add(compHeader("Regular", 26));
        panel.add(compHeader("Probationary", 8));

        return panel;
    }

    private JPanel compHeader(String status, int amount) {
        JPanel panel = EffectsUtility.marginedBoxText(new JPanel(),6,6, ColorUtility.white);
        panel.setBackground(ColorUtility.white);
        panel.setBorder(EffectsUtility.borderColor(0,0,0,4));
        panel.setLayout(null);

        JLabel title = new JLabel("Total " + status);
        JLabel number = new JLabel(String.valueOf(amount));

        title.setFont(FontUtility.important(16));
        number.setFont(FontUtility.plain(60));
        number.setForeground(ColorUtility.blueBright);

        title.setBounds(6,0, 200,20);
        number.setBounds(90, 40, 200, 50);

        panel.add(title);
        panel.add(number);

        return panel;
    }

    private JPanel searchTitle() {
        JPanel panel = new JPanel();
//        JRadioButton maleBtn = new JRadioButton("Male");
//        JRadioButton femaleBtn = new JRadioButton("Female");
//
//        // Group the buttons so only one can be selected
//        ButtonGroup group = new ButtonGroup();
//        group.add(maleBtn);
//        group.add(femaleBtn);
//
//
//        panel.add(maleBtn);
//        panel.add(femaleBtn);

        return panel;

    }
}
