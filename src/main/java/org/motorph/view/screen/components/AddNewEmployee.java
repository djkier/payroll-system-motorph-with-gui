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

    public AddNewEmployee(JFrame mainFrame) {
        this.id = new JTextField(16);
        this.firstName = new JTextField(16);
        this.lastName = new JTextField(16);
        this.birthDate = new JTextField(16);
        this.phone = new JTextField(16);
        this.address = new JTextField(43);


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

        employeePicture.setBounds(624,40,120,158);
        employeeInformation.setBounds(0,0,778,250);

        panel.add(employeePicture);
        panel.add(employeeInformation);


        return panel;
    }

    private JPanel employeePicture() {
        JPanel panel = new JPanel();
        panel.setBackground(ColorUtility.white);
        panel.setLayout(new BorderLayout());

        //size of the picture 116 x 116 pixels
        String picturePath = "10001";
        JLabel picture = ImageUtility.importedImagesInJLabel("/images/employee-images/" + picturePath + ".jpg");
        picture.setVerticalAlignment(SwingConstants.CENTER);

        JPanel pictureHolder = new JPanel();
        pictureHolder.setBackground(ColorUtility.grayBorder);
        pictureHolder.setPreferredSize(new Dimension(120,120));
        pictureHolder.setLayout(new BorderLayout());

        pictureHolder.add(picture, SwingConstants.CENTER);

        JLabel buttonText = new JLabel("Change Picture");
        buttonText.setFont(FontUtility.important(10));
        buttonText.setForeground(ColorUtility.white);
        buttonText.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel changeButton = new JPanel();
        changeButton.setLayout(new BorderLayout());
        changeButton.add(buttonText, BorderLayout.CENTER);
        changeButton.setPreferredSize(new Dimension(120, 30));


        changeButton.setBackground(ColorUtility.blueBright);
        EffectsUtility.panelHover(changeButton, ColorUtility.blueBright, ColorUtility.blueDark);

        panel.add(pictureHolder, BorderLayout.NORTH);
        panel.add(changeButton, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel employeeInformation() {
        JPanel panel = new JPanel();
        panel.setBackground(ColorUtility.white);
        panel.setLayout(null);

        JLabel label = new JLabel("General Information");
        label.setFont(FontUtility.important(16));

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

    private JPanel idNumbers() {
        JPanel panel = new JPanel();

        return panel;
    }

    private JPanel salaryAndAllowances() {
        JPanel panel = new JPanel();

        return panel;
    }

    private JPanel textAndField(String text, JTextField textField) {
        JPanel panel = new JPanel();
        panel.setBackground(ColorUtility.white);
        panel.setLayout(new BorderLayout());


        JLabel label = new JLabel(text);
        label.setFont(FontUtility.important(12));
        label.setPreferredSize(new Dimension(72,30));

        JPanel jTextField = EffectsUtility.searchField(textField);

        jTextField.setAlignmentX(0);


        panel.add(label, BorderLayout.WEST);
        panel.add(jTextField, BorderLayout.CENTER);

        return panel;
    }




}
