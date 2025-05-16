package org.motorph.view.screen.components;

import org.motorph.utility.ImageUtility;
import org.motorph.utility.TypeCleaner;
import org.motorph.utility.styling.ColorUtility;
import org.motorph.utility.styling.EffectsUtility;
import org.motorph.utility.styling.FontUtility;
import org.motorph.utility.styling.TextFieldUtility;

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
    private JComboBox<String> status;
    private JComboBox<String> position;
    private JComboBox<String> immSupervisor;


    public AddNewEmployee(JFrame mainFrame, String[] positionOptions, String[] supervisorOptions) {
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

        //Employment Details
        this.status = new JComboBox<>(new String[]{"Regular", "Probationary"});
        this.position = new JComboBox<>(positionOptions);
        this.immSupervisor = new JComboBox<>(supervisorOptions);

        //Load every instance before loading the main dialog
        this.jDialog = setUpDialog(mainFrame);

    }

    public void makeDialogVisible() {
        jDialog.setVisible(true);
    }

    private JDialog setUpDialog(JFrame frame) {
        JDialog dialog = new JDialog(frame, "Add New Employee", true);
        dialog.setSize(800,800);
//        dialog.setLocationRelativeTo(frame);
        //DELETE THIS after creating the dialog box
        dialog.setLocation(-1450,25);
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
        JPanel horizontalDivider2 = EffectsUtility.horizontalDivider(2, ColorUtility.grayBorder);
        JPanel employmentDetails = employmentDetails();
        JPanel horizontalDivider3 = EffectsUtility.horizontalDivider(2, ColorUtility.grayBorder);
        JPanel salaryAndAllowances = salaryAndAllowances();

        employeePicture.setBounds(624,40,120,158);
        employeeInformation.setBounds(0,0,778,212);
        horizontalDivider1.setBounds(0,212,778,2);
        idNumber.setBounds(0,224,778,110);
        horizontalDivider2.setBounds(0, 342,778,2);
        employmentDetails.setBounds(0,342,778,110);
        horizontalDivider3.setBounds(0,460,778,2);
        salaryAndAllowances.setBounds(0,460,778,110);


        panel.add(employeePicture);
        panel.add(employeeInformation);
        panel.add(horizontalDivider1);
        panel.add(idNumber);
        panel.add(horizontalDivider2);
        panel.add(employmentDetails);
        panel.add(horizontalDivider3);
        panel.add(salaryAndAllowances);


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
        JPanel panel = generalTemplate("General Information");

        JPanel employeeId = TextFieldUtility.textAndField("Employee ID", this.id);
        JPanel firstName = TextFieldUtility.textAndField("First Name", this.firstName);
        JPanel lastName = TextFieldUtility.textAndField("Last Name", this.lastName);
        JPanel birthDate = TextFieldUtility.textAndField("Birthday", this.birthDate);
        JPanel phone = TextFieldUtility.textAndField("Phone", this.phone);
        JPanel address = TextFieldUtility.textAndField("Address", this.address);

        TextFieldUtility.textFieldPlaceHolder(this.birthDate, "MM/DD/YYYY");

        employeeId.setBounds(12,24,300,40);
        firstName.setBounds(12,66,300,40);
        lastName.setBounds(312,66,300,40);
        birthDate.setBounds(12,108,300,40);
        phone.setBounds(312,108,300,40);
        address.setBounds(12,150,600,40);

        panel.add(employeeId);
        panel.add(firstName);
        panel.add(lastName);
        panel.add(birthDate);
        panel.add(phone);
        panel.add(address);

        return EffectsUtility.marginedBoxText(panel,12,12, ColorUtility.white);
    }

    //Government ID Numbers
    private JPanel idNumber() {
        JPanel panel = generalTemplate("Government ID Numbers");

        JPanel tin = TextFieldUtility.textAndField("TIN", this.tin);
        JPanel sss = TextFieldUtility.textAndField("SSS", this.sss);
        JPanel philhealth = TextFieldUtility.textAndField("PhilHealth", this.philhealth);
        JPanel pagibig = TextFieldUtility.textAndField("Pag-IBIG", this.pagibig);

        tin.setBounds(12,24,300,40);
        sss.setBounds(360,24,300,40);
        philhealth.setBounds(12,66,300,40);
        pagibig.setBounds(360,66,300,40);

        panel.add(tin);
        panel.add(sss);
        panel.add(philhealth);
        panel.add(pagibig);

        return EffectsUtility.marginedBoxText(panel, 12,0,ColorUtility.white);
    }

    private JPanel employmentDetails() {
        JPanel panel = generalTemplate("Employment Details");

        JPanel status = TextFieldUtility.textAndComboBox("Status", this.status);
        JPanel position = TextFieldUtility.textAndComboBox("Position", this.position);
        JPanel immSupervisor = TextFieldUtility.textAndComboBox("Immediate Supervisor", this.immSupervisor);

        status.setBounds(12,24,150,60);
        position.setBounds(192,24,250,60);
        immSupervisor.setBounds(472, 24, 250,60);

        panel.add(status);
        panel.add(position);
        panel.add(immSupervisor);

        return EffectsUtility.marginedBoxText(panel, 12, 12, ColorUtility.white);
    }

    private JPanel salaryAndAllowances() {
        JPanel panel = generalTemplate("Salary & Allowances");

        return EffectsUtility.marginedBoxText(panel, 12, 12, ColorUtility.white);
    }



    private JPanel generalTemplate(String title) {
        JPanel panel = new JPanel();
        panel.setBackground(ColorUtility.white);
        panel.setLayout(null);

        JLabel label = new JLabel(title);
        label.setFont(FontUtility.important());
        label.setBounds(0,0,200,20);

        panel.add(label);

        return panel;
    }


}
