package org.motorph.view.screen.components;

import org.motorph.utility.ImageUtility;
import org.motorph.utility.styling.ColorUtility;
import org.motorph.utility.styling.EffectsUtility;
import org.motorph.utility.styling.FontUtility;

import javax.swing.*;
import java.awt.*;

public class AddNewEmployee {
    private JDialog jDialog;
    private JTextField id;
    private JTextField firstName;
    private JTextField lastName;
    private JTextField birthDate;
    private JTextField phone;
    private JTextField address;
    private JTextField tin;
    private JTextField sss;
    private JTextField philhealth;
    private JTextField pagibig;


    public AddNewEmployee(JFrame mainFrame) {
        //General Information
        this.id = new JTextField(16);
        this.firstName = new JTextField(16);
        this.lastName = new JTextField(16);
        this.birthDate = new JTextField(16);
        this.phone = new JTextField(16);
        this.address = new JTextField(46);

        //id number
        this.tin = new JTextField(16);
        this.sss = new JTextField(16);
        this.philhealth = new JTextField(16);
        this.pagibig = new JTextField(16);


        //Load every instance before loading the main dialog
        this.jDialog = setUpDialog(mainFrame);

    }

    public void makeDialogVisible() {
        jDialog.setVisible(true);
    }

    private JDialog setUpDialog(JFrame frame) {
        JDialog dialog = new JDialog(frame, "Add New Employee", true);
        dialog.setSize(800,600);
//        dialog.setLocationRelativeTo(frame);
        //DELETE THIS after creating the dialog box
        dialog.setLocation(-1450,150);
        dialog.setResizable(false);
        dialog.setBackground(ColorUtility.grayLight);

        //Add the boarded main panel
        dialog.add(EffectsUtility.marginedBoxText(mainPanel(), ColorUtility.grayLight));

        return dialog;
    }

    private JPanel mainPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(ColorUtility.white);
        panel.setLayout(null);

        JPanel employeePicture = employeePicture();
        JPanel employeeInformation = employeeInformation();
        JPanel horizontalDivider1 = EffectsUtility.horizontalDivider(2, ColorUtility.grayBorder);
        JPanel idNumber = idNumber();


        employeePicture.setBounds(624,40,120,158);
        idNumber.setBounds(0,224,778,220);
        horizontalDivider1.setBounds(0,212,778,2);
        employeeInformation.setBounds(0,0,778,212);


        panel.add(employeePicture);
        panel.add(employeeInformation);
        panel.add(horizontalDivider1);
        panel.add(idNumber);


        return panel;
    }

    //Picture portion
    private JPanel employeePicture() {
        JPanel panel = new JPanel();
        panel.setBackground(ColorUtility.white);
        panel.setLayout(new BorderLayout());

        //size of the picture 116 x 116 pixels
        JPanel pictureHolder = pictureHolder();
        JPanel pictureChangeButton = pictureChangeButton();

        panel.add(pictureHolder, BorderLayout.NORTH);
        panel.add(pictureChangeButton, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel pictureHolder() {
        JPanel panel = new JPanel();
        panel.setBackground(ColorUtility.grayBorder);
        panel.setPreferredSize(new Dimension(120,120));
        panel.setLayout(new BorderLayout());

        String picturePath = "10001";
        JLabel picture = ImageUtility.importedImagesInJLabel("/images/employee-images/" + picturePath + ".jpg");

        panel.add(picture, SwingConstants.CENTER);

        return panel;
    }

    private JPanel pictureChangeButton() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(120, 30));
        panel.setBackground(ColorUtility.blueBright);
        EffectsUtility.panelHover(panel, ColorUtility.blueBright, ColorUtility.blueDark);

        JLabel buttonText = new JLabel("Change Picture");
        buttonText.setFont(FontUtility.important(10));
        buttonText.setForeground(ColorUtility.white);
        buttonText.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(buttonText, BorderLayout.CENTER);

        return panel;
    }

    //General Information
    private JPanel employeeInformation() {
        JPanel panel = new JPanel();
        panel.setBackground(ColorUtility.white);
        panel.setLayout(null);

        JLabel label = new JLabel("General Information");
        label.setFont(FontUtility.important());

        JPanel employeeId = textAndField("Employee ID", this.id);
        JPanel firstName = textAndField("First Name", this.firstName);
        JPanel lastName = textAndField("Last Name", this.lastName);
        JPanel birthDate = textAndField("Birthday", this.birthDate);
        JPanel phone = textAndField("Phone", this.phone);
        JPanel address = textAndField("Address", this.address);

        label.setBounds(0,0,150,20);
        employeeId.setBounds(12,24,300,40);
        firstName.setBounds(12,66,300,40);
        lastName.setBounds(312,66,300,40);
        birthDate.setBounds(12,108,300,40);
        phone.setBounds(312,108,300,40);
        address.setBounds(12,150,600,40);


        panel.add(label);
        panel.add(employeeId);
        panel.add(firstName);
        panel.add(lastName);
        panel.add(birthDate);
        panel.add(phone);
        panel.add(address);

        return EffectsUtility.marginedBoxText(panel,12,12, ColorUtility.white);
    }

    private JPanel idNumber() {
        JPanel panel = new JPanel();
        panel.setBackground(ColorUtility.white);
        panel.setLayout(null);

        JLabel label = new JLabel("Government ID Numbers");
        label.setFont(FontUtility.important());

        JPanel tin = textAndField("TIN", this.tin);
        JPanel sss = textAndField("SSS", this.sss);
        JPanel philhealth = textAndField("PhilHealth", this.philhealth);
        JPanel pagibig = textAndField("Pag-IBIG", this.pagibig);

        label.setBounds(0,0,200,20);
        tin.setBounds(12,24,300,40);
        sss.setBounds(360,24,300,40);
        philhealth.setBounds(12,66,300,40);
        pagibig.setBounds(360,66,300,40);

        panel.add(label);
        panel.add(tin);
        panel.add(sss);
        panel.add(philhealth);
        panel.add(pagibig);

        return EffectsUtility.marginedBoxText(panel, 12,0,ColorUtility.white);
    }

    private JPanel salaryAndAllowances() {
        JPanel panel = new JPanel();

        return panel;
    }

    private JPanel textAndField(String text, int spacing, JTextField textField) {
        JPanel panel = new JPanel();
        panel.setBackground(ColorUtility.white);
        panel.setLayout(new BorderLayout());


        JLabel label = new JLabel(text);
        label.setFont(FontUtility.important(12));
        label.setPreferredSize(new Dimension(spacing,30));

        JPanel jTextField = EffectsUtility.searchField(textField);

        jTextField.setAlignmentX(0);


        panel.add(label, BorderLayout.WEST);
        panel.add(jTextField, BorderLayout.CENTER);

        return panel;
    }

    private JPanel textAndField(String text, JTextField textField) {
        return textAndField(text, 72, textField);
    }





}
