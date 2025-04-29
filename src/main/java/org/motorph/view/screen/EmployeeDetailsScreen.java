package org.motorph.view.screen;

import org.motorph.model.samplefile.TestData;
import org.motorph.utility.styling.ColorUtility;

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
        JPanel b = new JPanel();
        b.setBackground(ColorUtility.transparent);
        b.setSize(300, 30);

        JPanel c = new JPanel();

        DefaultTableModel model = new DefaultTableModel(TestData.data, TestData.columns);
        JTable table = new JTable(model);

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                if (row >= 0) {
                    String name = table.getValueAt(row, 0).toString();
                    String age = table.getValueAt(row, 1).toString();
                    String city = table.getValueAt(row, 2).toString();

                    JOptionPane.showMessageDialog(new JFrame()
                            ,"",
                            "Row Details",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });



        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBackground(ColorUtility.redLight);
        scrollPane.setPreferredSize(new Dimension(800, 200));


        b.add(scrollPane);



        return b;
    }

    @Override
    public String setLabel() {
        return "Employee";
    }
}
