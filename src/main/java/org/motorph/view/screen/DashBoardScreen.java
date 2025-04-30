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
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


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


    @Override
    public JPanel body() {
        JPanel b = new JPanel();
        b.setBackground(ColorUtility.redLight);
        b.setPreferredSize(new Dimension(200, 200));
        b.setLayout(new BorderLayout());

        b.add(bodyCenterTop(), BorderLayout.NORTH);
        b.add(fileInfo(), BorderLayout.CENTER);
        b.add(bodyCenterBottom(), BorderLayout.SOUTH);

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

        p.add(EffectsUtility.marginedBoxText(welcomeMessage()), BorderLayout.CENTER);
        p.add(EffectsUtility.horizontalMargin(24), BorderLayout.SOUTH);

        return p;
    }

    public JPanel welcomeMessage() {
        JPanel top = new JPanel();

        JPanel messageBox = new JPanel();
        messageBox.setLayout(new BorderLayout());

        JLabel message = new JLabel("Welcome, " + getUser() );
        message.setFont(FontUtility.important(16));
        message.setForeground(ColorUtility.black);

        JLabel timeLoggedIn = new JLabel("Time logged in: " + "12:00PM");
        timeLoggedIn.setFont(FontUtility.plainItalic(14));
        timeLoggedIn.setForeground(ColorUtility.grayDark);

        messageBox.add(message, BorderLayout.CENTER);
        messageBox.add(timeLoggedIn, BorderLayout.SOUTH);
        messageBox.setBackground(ColorUtility.transparent);

        JLabel motorphLogo = ImageUtility.importedResizedInJLabel("/images/passwordLogoOriginalSize.jpg", 90, 52);
        motorphLogo.setVerticalAlignment(SwingConstants.CENTER);
        top.setBackground(ColorUtility.white);
        top.setPreferredSize(new Dimension(200, 48));
        top.setLayout(new BorderLayout());

        top.add(messageBox, BorderLayout.WEST);
        top.add(motorphLogo, BorderLayout.EAST);

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
    public JPanel bodyCenterBottom() {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());

        p.add(EffectsUtility.horizontalMargin(24), BorderLayout.NORTH);
        p.add(EffectsUtility.marginedBoxText(announcement()), BorderLayout.CENTER);

        return p;
    }
    public JPanel announcement() {
        JPanel announceTable = new JPanel();
        JLabel tableTitle = new JLabel("Announcement");
        tableTitle.setFont(FontUtility.important(14));
        tableTitle.setForeground(ColorUtility.black);

        announceTable.setBackground(ColorUtility.white);
        announceTable.setPreferredSize(new Dimension(210, 200));

        announceTable.add(tableTitle);
        return announceTable;
    }

}
