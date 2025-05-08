package org.motorph.view.screen;

import org.motorph.model.datarepositories.EmployeeRepository;
import org.motorph.utility.ImageUtility;
import org.motorph.utility.styling.ColorUtility;
import org.motorph.utility.styling.EffectsUtility;
import org.motorph.utility.styling.FontUtility;
import org.motorph.view.screen.components.TableScreen;

import javax.swing.*;
import java.awt.*;

public class EmployeeDetailsScreen extends ScreenView {
    private EmployeeRepository employeeRepository;

    public EmployeeDetailsScreen(EmployeeRepository employeeRepository) {
        super(employeeRepository);
        this.employeeRepository = employeeRepository;
    }


    @Override
    public JPanel body() {
        JPanel panel = new JPanel();
        panel.setBackground(ColorUtility.white);
        panel.setLayout(null);

        JPanel total = employeeHeader();
        total.setBounds(16,16,740,120);

        JPanel grayStripe1 = EffectsUtility.horizontalMargin(24);
        grayStripe1.setBounds(0,152, 800, 24);

        JPanel employeeTable = employeeTable();
        employeeTable.setBounds(0, 176,752,600);


        panel.add(total);
        panel.add(grayStripe1);
        panel.add(employeeTable);


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

    private JPanel employeeTable() {
        JPanel panel = new JPanel();
        panel.setBackground(ColorUtility.white);
        panel.setLayout(null);

        JLabel searchIcon = ImageUtility.importedImagesInJLabel("/images/tab-icon/search.png");
        searchIcon.setBounds(20,0,30,50);

        JLabel label = new JLabel("Searched by:");
        label.setFont(FontUtility.important(18));
        label.setBounds(50,0,200,50);

        JPanel radioBtn = radioBtn();
        radioBtn.setBounds(170, 8, 200,50);

        JPanel addEmployee = addEmployee();
        addEmployee.setBounds(580, 12, 160,28);

        JPanel searchField = EffectsUtility.searchField(30);
        searchField.setBounds(24, 40, 350,50);

        JLabel note = new JLabel("Click a row to view or edit.");
        note.setFont(FontUtility.plainItalic(12));
        note.setBounds(28, 62, 400, 50);


        JScrollPane table = TableScreen.employeeTable(getTableData());
        table.setBounds(28, 100, 724, 370);

        panel.add(searchIcon);
        panel.add(searchField);
        panel.add(label);
        panel.add(radioBtn);
        panel.add(addEmployee);
        panel.add(note);
        panel.add(table);

        return panel;
    }

    private JPanel radioBtn() {
        JPanel panel = new JPanel();
        panel.setBackground(ColorUtility.white);

        JRadioButton idBtn = radioBtn("ID");
        idBtn.setPreferredSize(new Dimension(50,20));

        JRadioButton lnBtn = radioBtn("Last Name");

        ButtonGroup group = new ButtonGroup();
        group.add(idBtn);
        group.add(lnBtn);
        idBtn.setSelected(true);

        panel.add(idBtn);
        panel.add(Box.createRigidArea(new Dimension(20, 0)));
        panel.add(lnBtn);

        return panel;
    }

    private JRadioButton radioBtn(String label) {
        JRadioButton btn = new JRadioButton(label);
        btn.setBackground(ColorUtility.white);
        btn.setFont(FontUtility.plain(14));
        btn.setForeground(ColorUtility.grayDark);
        btn.setFocusPainted(false);

        return btn;
    }

    private JPanel addEmployee() {
        JPanel panel = new JPanel();

        panel.setBackground(ColorUtility.redDark);

        JLabel addNew = new JLabel("+ Add New Employee");
        addNew.setFont(FontUtility.important(12));
        addNew.setForeground(ColorUtility.white);

        panel.add(addNew);

        EffectsUtility.panelHover(panel, ColorUtility.redDark, ColorUtility.redDarkHover);

        return panel;
    }

    private JPanel searchField() {
        JPanel panel = new JPanel();
        panel.setBackground(ColorUtility.transparent);

        JTextField searchField = new JTextField(30);
        searchField.setBackground(ColorUtility.white);
        searchField.setForeground(Color.DARK_GRAY);
        searchField.setFont(FontUtility.plain(12));

        searchField.setBorder(BorderFactory.createLineBorder(ColorUtility.white, 1));
        JPanel border = new JPanel();
        border.add(searchField);
        border.setBackground(ColorUtility.white);

        JPanel searchBorder = EffectsUtility.marginedBoxText(border,0,0, ColorUtility.white);
        searchBorder.setBorder(BorderFactory.createLineBorder(ColorUtility.graySurface, 2));
        searchBorder.setBackground(ColorUtility.white);

        panel.add(searchBorder);

        return panel;

    }


}
