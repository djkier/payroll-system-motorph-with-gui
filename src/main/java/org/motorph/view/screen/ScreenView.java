package org.motorph.view.screen;

import org.motorph.model.datarepositories.DataProcessRepo;
import org.motorph.model.datarepositories.EmployeeRepository;
import org.motorph.utility.styling.ColorUtility;
import org.motorph.utility.styling.EffectsUtility;
import org.motorph.utility.styling.FontUtility;

import javax.swing.*;
import java.awt.*;

public class ScreenView {

    private String user;
    private Object[][] tableData;
    private JPanel panel;

    public ScreenView(EmployeeRepository employeeRepository) {
        this.user = "";
        this.tableData = employeeRepository.employeeTableData();
        this.panel = setUp();
    }

    public ScreenView() {
        this.user = "";
        this.panel = setUp();

    }

    public Object[][] getTableData() {
        return tableData;
    }



    public JPanel getView() {
        //refresh screen
        this.panel = setUp();
        return panel;
    }
    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public JPanel setUp() {
        JPanel screen = new JPanel();
        screen.setLayout(new BorderLayout());
        screen.setBackground(ColorUtility.grayLight);

        screen.add(top(), BorderLayout.NORTH);
        screen.add(borderedBody(), BorderLayout.CENTER);
        return screen;
    }


    private JPanel top() {
        JPanel t = new JPanel();
        t.setBackground(ColorUtility.transparent);
        t.setPreferredSize(new Dimension(100, 48));
        t.setBorder(EffectsUtility.borderColor(0, 0, 3, 0));

        t.setLayout(new BorderLayout());
        t.add(topLeftPanel(), BorderLayout.WEST);
        t.add(topRightPanel(), BorderLayout.EAST);

        return t;
    }

    private JPanel topLeftPanel() {
        JPanel leftBox = new JPanel();
        leftBox.setPreferredSize(new Dimension(210, 80));
        leftBox.setLayout(new BorderLayout());
        leftBox.setBackground(ColorUtility.transparent);


        JLabel label = new JLabel(setLabel());
        label.setFont(FontUtility.plain(18));
        label.setHorizontalAlignment(SwingConstants.LEFT);


        JLabel space = new JLabel();
        space.setPreferredSize(new Dimension(24,80));

        leftBox.add(space, BorderLayout.WEST);
        leftBox.add(label, BorderLayout.CENTER);

        return leftBox;
    }

    //Override
    public String setLabel() {

        return "";
    }

    //Will be overriden by the dashboard
    private JPanel topRightPanel() {
        JPanel timeBox = new JPanel();
//        JLabel time = new JLabel(FontUtility.addSpaceLast("10:00 AM", 4));
//        timeBox.add(time);
        return timeBox;
    }

    //Main body starts here
    private JPanel borderedBody() {
        JPanel b = new JPanel();

        b.setBackground(ColorUtility.grayLight);
        b.setLayout(new BorderLayout());

        b.add(EffectsUtility.verticalMargin(24), BorderLayout.WEST);
        b.add(EffectsUtility.verticalMargin(24), BorderLayout.EAST);
        b.add(EffectsUtility.horizontalMargin(12), BorderLayout.NORTH);
        b.add(EffectsUtility.horizontalMargin(12), BorderLayout.SOUTH);

        b.add(body(), BorderLayout.CENTER);

        return b;
    }

    //override by the ancestors
    public JPanel body() {
        return new JPanel();
    }








}
