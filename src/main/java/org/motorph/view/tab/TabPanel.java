package org.motorph.view.tab;

import org.motorph.utility.styling.ColorUtility;
import org.motorph.utility.styling.EffectsUtility;

import javax.swing.*;
import java.awt.*;

public class TabPanel {
    private JPanel tabPanel;
    private Tab dashboard;
    private Tab empDetails;
    private Tab paySlip;

    public TabPanel() {
        this.dashboard = new Tab("Dashboard", "/images/tab-icon/dashboard.png");
        this.empDetails = new Tab("Employee", "/images/tab-icon/employee.png");
        this.paySlip = new Tab("Payslip", "/images/tab-icon/payslip.png");

        //preload the tab before the creation of the tab panel
        this.tabPanel = setUpTabPanel();
    }

    public JPanel setUpTabPanel() {
        JPanel tab = new JPanel();
        tab.setBackground(ColorUtility.grayLight);
        tab.setPreferredSize(new Dimension(180, 130));
        tab.setBorder(EffectsUtility.borderColor(0, 0, 0, 2));

        tab.setLayout(new FlowLayout());
        tab.add(dashboard.getTab());
        tab.add(empDetails.getTab());
        tab.add(paySlip.getTab());


        return tab;
    }

    public JPanel getTabPanel() {
        return tabPanel;
    }

}
