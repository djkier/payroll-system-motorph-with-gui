package org.motorph.view.screen;

import org.motorph.utility.styling.ColorUtility;
import org.motorph.utility.styling.EffectsUtility;
import org.motorph.utility.styling.FontUtility;

import javax.swing.*;
import java.awt.*;

public class ScreenView {
    private JPanel panel;

    public ScreenView(String screenName) {
        this.panel = setUp();
    }

    public ScreenView() {
        this("hello");
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
        leftBox.setPreferredSize(new Dimension(128, 80));
        leftBox.setLayout(new BorderLayout());
        leftBox.setBackground(ColorUtility.transparent);


        JLabel label = new JLabel(setLabel());
        label.setFont(FontUtility.plain(18));
        label.setHorizontalAlignment(SwingConstants.CENTER);


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

    public JPanel body() {
        return new JPanel();
    }


    public JPanel getView() {
        return panel;
    }

    public JPanel setUp() {
        JPanel screen = new JPanel();
        screen.setLayout(new BorderLayout());
        screen.setBackground(ColorUtility.grayLight);

        screen.add(top(), BorderLayout.NORTH);
        screen.add(body(), BorderLayout.CENTER);
        return screen;
    }



}
