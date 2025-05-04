package org.motorph.view.screen.components;

import org.motorph.PayrollSystem;
import org.motorph.utility.styling.ColorUtility;
import org.motorph.utility.styling.FontUtility;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.metal.MetalScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class TableScreen {

    public static JScrollPane dashboardTable() {
        String[] columnTitles = {"Title", "Start Date", "End Date", "Description"};
        Object[][] data= {{"Value 1", "Value 2", "Value 3", "Value 4"}};

        DefaultTableModel model = new DefaultTableModel(data, columnTitles) {
            @Override
            public boolean isCellEditable(int row, int column) {

                return column == 0;
            }
        };

        JScrollPane sp = scrollPane(generalTable((model)));

        return sp;

    }

    public static JScrollPane employeeTable() {
        String[] columnTitles = {"Select", "ID", "Name", "Birthday", "Position", "Status"};
        Object[][] data = {{false, "10001", "Dela Cruz, J", "1975-01-01", "Clerk", "Regular"}};

        DefaultTableModel model = new DefaultTableModel(data, columnTitles) {
            @Override
            public boolean isCellEditable(int row, int column) {

                return column == 0;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) return Boolean.class; // checkbox for first column
                return super.getColumnClass(columnIndex);
            }
        };

        JScrollPane sp = scrollPane(generalTable((model)));


        return sp;
    }


    private static JTable generalTable(DefaultTableModel model) {
        UIManager.put("ScrollBar.width", 16); // Set scrollbar width
        UIManager.put("ScrollBar.background", ColorUtility.grayLight); // Set scrollbar background color
        UIManager.put("ScrollBar.thumb", ColorUtility.grayLight); // Set thumb color
        UIManager.put("ScrollBar.thumbHighlight", ColorUtility.grayLight); // Set thumb highlight color
        UIManager.put("ScrollBar.thumbShadow", ColorUtility.grayLight);

        JTable table = new JTable(model);
        JTableHeader header = table.getTableHeader();

        header.setReorderingAllowed(false);
        header.setFont(FontUtility.important(12));
        header.setPreferredSize(new Dimension(header.getWidth(), 30));
        header.setForeground(ColorUtility.grayDark);
        header.setBackground(ColorUtility.grayLight);

        table.setRowHeight(32);
        table.setBorder(BorderFactory.createLineBorder(ColorUtility.grayLight, 2));
        table.setBackground(ColorUtility.white);

        table.setFont(FontUtility.plain(12));
        table.setGridColor(ColorUtility.grayBorder);
        table.setSelectionBackground(ColorUtility.grayLight);


//        JScrollPane scrollPane = new JScrollPane(table);
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//        scrollPane.setBorder(BorderFactory.createLineBorder(ColorUtility.grayBorder, 2));
//        scrollPane.getViewport().setBackground(ColorUtility.white);
//        scrollPane.setBackground(ColorUtility.white);
//
//        scrollPane.getVerticalScrollBar().setUI(scrollBarUI());

        return table;
    }

    private static JScrollPane scrollPane(JTable table) {
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createLineBorder(ColorUtility.grayBorder, 2));
        scrollPane.getViewport().setBackground(ColorUtility.white);
        scrollPane.setBackground(ColorUtility.white);

        scrollPane.getVerticalScrollBar().setUI(scrollBarUI());

        return scrollPane;
    }

    private static BasicScrollBarUI scrollBarUI() {
        BasicScrollBarUI customUI = new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                // Set custom colors
                this.thumbColor = ColorUtility.blueDark; // Scroll thumb color
                this.trackColor = ColorUtility.grayLight; // Track color
                this.thumbDarkShadowColor = ColorUtility.blueDark; // Thumb dark shadow color
                this.thumbLightShadowColor = ColorUtility.blueDark; // Thumb light shadow color
            }
        };

        return customUI;
    }


}
