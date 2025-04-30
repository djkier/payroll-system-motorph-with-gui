package org.motorph.view.screen;

import org.motorph.model.samplefile.TestData;
import org.motorph.utility.ImageUtility;
import org.motorph.utility.styling.ColorUtility;
import org.motorph.utility.styling.EffectsUtility;
import org.motorph.utility.styling.FontUtility;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.io.File;


public class DashBoardScreen extends ScreenView {


    public DashBoardScreen(String user) {
        super(user);

    }

//    @Override
//    public JPanel setUp() {
//        JPanel panel = new JPanel();
//        panel.setBackground(Color.GREEN);
//
//        return panel;
//    }

    public JPanel centerBody() {
        JPanel cb = new JPanel();

        cb.add(welcomeMessage(), BorderLayout.NORTH);
        cb.add(fileInfo(), BorderLayout.CENTER);
        cb.add(announcement(), BorderLayout.SOUTH);

        return cb;
    }

    @Override
    public JPanel body() {
        JPanel b = new JPanel();
        b.setBackground(ColorUtility.redLight);
        b.setPreferredSize(new Dimension(200, 200));
        b.setLayout(new BorderLayout());

        b.add(bodyCenterTop(), BorderLayout.NORTH);
        b.add(fileInfo(), BorderLayout.CENTER);
        b.add(announcement(), BorderLayout.SOUTH);

        return b;
    }

    @Override
    public String setLabel() {
        return "Dashboard";
    }

    //body top size editable
    public JPanel bodyCenterTop() {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());

        JPanel border = EffectsUtility.horizontalMargin();

        p.add(welcomeMessage(), BorderLayout.CENTER);
        p.add(border, BorderLayout.SOUTH);

        return p;
    }

    public JPanel welcomeMessage() {
        JPanel top = new JPanel();


        JPanel messageBox = new JPanel();
        JLabel message = new JLabel("Welcome, " + getUser());
        message.setFont(FontUtility.important(16));
        message.setForeground(ColorUtility.black);
        JLabel timeLoggedIn = new JLabel("Time logged in: " + "12:00PM");
        timeLoggedIn.setFont(FontUtility.plain());

        top.setBackground(ColorUtility.white);
        top.setPreferredSize(new Dimension(200, 80));

        top.add(message);
        top.add(timeLoggedIn);


        return top;
    }

    //body middle size dependent on the size with the top and bottom
    public JPanel fileInfo() {
        JPanel loadedDetails = new JPanel();
        JLabel label = new JLabel("Employee details loaded file");

        loadedDetails.setBackground(Color.DARK_GRAY);

        loadedDetails.add(label);
        return loadedDetails;
    }

    //body bottom size editable
    public JPanel announcement() {
        JPanel announceTable = new JPanel();
        JLabel tableTitle = new JLabel("Announcement");
        tableTitle.setForeground(ColorUtility.white);

        announceTable.setBackground(ColorUtility.violetDark);
        announceTable.setPreferredSize(new Dimension(210, 200));

        announceTable.add(tableTitle);
        return announceTable;
    }

}
