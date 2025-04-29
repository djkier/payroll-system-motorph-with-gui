package org.motorph.view.screen;

import org.motorph.utility.styling.ColorUtility;
import org.motorph.utility.styling.FontUtililty;

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
        t.setBackground(ColorUtility.violet);
        t.setSize(900, 1000);

        t.setLayout(new BorderLayout());
        t.add(topLeftPanel(), BorderLayout.WEST);
        t.add(topRightPanel(), BorderLayout.EAST);

        return t;
    }



    private JPanel topLeftPanel() {
        JPanel leftBox = new JPanel();
        JLabel label = setLabel();
        label.setFont(FontUtililty.important());

        leftBox.add(label);

        return leftBox;
    }

    public JLabel setLabel() {
        return new JLabel();
    }

    private JPanel topRightPanel() {
        JPanel timeBox = new JPanel();
        JLabel time = new JLabel("10:00 AM         ");
        timeBox.add(time);
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
//        screen.setLayout(new BoxLayout(screen,BoxLayout.Y_AXIS));
        screen.setLayout(new BorderLayout());

        screen.add(top(), BorderLayout.NORTH);
        screen.add(body(), BorderLayout.CENTER);
        return screen;
    }



}
