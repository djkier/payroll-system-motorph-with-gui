package org.motorph.view.screen;

import org.motorph.model.samplefile.TestData;
import org.motorph.utility.ImageUtility;
import org.motorph.utility.styling.ColorUtility;
import org.motorph.utility.styling.EffectsUtility;
import org.motorph.utility.styling.FontUtility;
import org.motorph.view.screen.components.TableScreen;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class DashBoardScreen extends ScreenView {

    public DashBoardScreen() {


    }

    @Override
    public JPanel body() {
        JPanel b = new JPanel();
        b.setBackground(ColorUtility.redLight);
        b.setPreferredSize(new Dimension(200, 200));
        b.setLayout(new BorderLayout());

        b.add(bodyCenterTop(), BorderLayout.NORTH);
        b.add(bodyCenterMiddle(), BorderLayout.CENTER);
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
        p.add(EffectsUtility.horizontalMargin(16), BorderLayout.SOUTH);

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
        //Edit height top
        top.setPreferredSize(new Dimension(200, 48));
        top.setLayout(new BorderLayout());

        top.add(messageBox, BorderLayout.WEST);
        top.add(motorphLogo, BorderLayout.EAST);

        return top;
    }

    //body middle size dependent on the size with the top and bottom
    public JPanel bodyCenterMiddle() {
        JPanel center = EffectsUtility.marginedBoxText(fileInfo(), 24,12);

        return center;
    }


    public JPanel fileInfo() {
        JPanel loadedDetails = new JPanel();

        JLabel label = new JLabel("Current Files");
        label.setForeground(ColorUtility.grayDark);
        label.setFont(FontUtility.important(16));
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setVerticalAlignment(SwingConstants.TOP);
        //Edit margin from "Current Files" to the next
        label.setPreferredSize(new Dimension(12, 36));

        loadedDetails.setBackground(ColorUtility.white);
        loadedDetails.setLayout(new BorderLayout());

        loadedDetails.add(label, BorderLayout.NORTH);
        loadedDetails.add(fileDetails(), BorderLayout.CENTER);
        return loadedDetails;
    }

    public JPanel fileDetails() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(3,4));
        p.setBackground(ColorUtility.white);

        JPanel changeDetails = changeFile("Change details");
        JPanel changeAttendance = changeFile("Change attendance");

        //title
        p.add(EffectsUtility.marginedPanelWithText("Description", ColorUtility.grayLight));
        p.add(EffectsUtility.marginedPanelWithText("File Name", ColorUtility.grayLight));
        p.add(EffectsUtility.marginedPanelWithText("Date Open", ColorUtility.grayLight));
        p.add(EffectsUtility.marginedPanelWithText("Action", ColorUtility.grayLight));

        //employee details
        p.add(EffectsUtility.marginedPanelWithText("Employee Details", FontUtility.important(12), ColorUtility.white));
        p.add(EffectsUtility.marginedPanelWithText("employee-details.csv", ColorUtility.white));
        p.add(EffectsUtility.marginedPanelWithText("January 1, 2000", ColorUtility.white));
        p.add(changeDetails);

        //employee attendance
        p.add(EffectsUtility.marginedPanelWithText("Employee Attendance", FontUtility.important(12), ColorUtility.white));
        p.add(EffectsUtility.marginedPanelWithText("employee-attendance.csv", ColorUtility.white));
        p.add(EffectsUtility.marginedPanelWithText("January 1, 2000", ColorUtility.white));
        p.add(changeAttendance);

        return p;
    }

    public JPanel changeFile(String text) {
        JPanel p = new JPanel();
        JLabel label = new JLabel("+ " + text);
        label.setFont(FontUtility.important(12));
        label.setForeground(ColorUtility.white);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        p.setBackground(ColorUtility.blueBright);
        p.setLayout(new BorderLayout());
        p.add(label, BorderLayout.CENTER);

        EffectsUtility.panelHover(p, ColorUtility.blueBright, ColorUtility.blueDark);

        return EffectsUtility.marginedBoxText(p, 4, 2);
    }

    //body bottom size editable
    public JPanel bodyCenterBottom() {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());

        p.add(EffectsUtility.horizontalMargin(16), BorderLayout.NORTH);
        p.add(EffectsUtility.marginedBoxText(announcement(),24,12), BorderLayout.CENTER);

        return p;
    }
    public JPanel announcement() {
        JPanel announceTable = new JPanel();
        JLabel tableTitle = new JLabel("Announcement");
        tableTitle.setForeground(ColorUtility.grayDark);
        tableTitle.setFont(FontUtility.important(16));
        tableTitle.setVerticalAlignment(SwingConstants.TOP);
        tableTitle.setPreferredSize(new Dimension(32, 32));

        announceTable.setBackground(ColorUtility.white);
        announceTable.setPreferredSize(new Dimension(210, 400));
        announceTable.setLayout(new BorderLayout());

        announceTable.add((tableTitle), BorderLayout.NORTH);

        //column title are "title, Start Date, End Date, Desciption,
        //expected 5 to 10 rows only. adjust the table value sizes
        announceTable.add(TableScreen.dashboardTable(), BorderLayout.CENTER);

        return announceTable;
    }

}
