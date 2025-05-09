package org.motorph.view.screen;

import org.motorph.model.datarepositories.EmployeeDetails;
import org.motorph.model.datarepositories.EmployeeRepository;
import org.motorph.utility.ImageUtility;
import org.motorph.utility.styling.ColorUtility;
import org.motorph.utility.styling.EffectsUtility;
import org.motorph.utility.styling.FontUtility;
import org.motorph.view.screen.components.TableScreen;
import org.motorph.view.tab.Tab;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.ArrayList;

public class EmployeeDetailsScreen extends ScreenView {
    private EmployeeRepository employeeRepository;
    private boolean isIdSelectedInRadio;
    private JTextField searchBar;
    private JPanel employeeTablePanel;
    private JScrollPane employeeScrollpane;




    public EmployeeDetailsScreen(EmployeeRepository employeeRepository) {
        super(employeeRepository);
        this.employeeRepository = employeeRepository;
        this.isIdSelectedInRadio = true;

        this.employeeTablePanel = new JPanel();
        this.searchBar = new JTextField(30);
        this.employeeScrollpane = TableScreen.employeeTable(employeeRepository.employeeTableData());

        setPanel(setUp());


    }

    @Override
    public JPanel getView() {
        return getPanel();
    }

    public JTextField getSearchBar() {
        return this.searchBar;
    }


    @Override
    public JPanel body() {
        JPanel panel = new JPanel();
        panel.setBackground(ColorUtility.white);
        panel.setLayout(null);

        JPanel total = employeeHeader();
        total.setBounds(16,16,740,120);

        JPanel grayStripe1 = EffectsUtility.horizontalMargin(24);
        grayStripe1.setBounds(0,152, 800, 24);

        JPanel employeeTable = employeeTable();
        employeeTable.setBounds(0, 176,752,600);


        panel.add(total);
        panel.add(grayStripe1);
        panel.add(employeeTable);


        return panel;
    }

    @Override
    public String setLabel() {
        return "Employee";
    }

    private JPanel employeeHeader() {
        JPanel panel = new JPanel();
        panel.setBackground(ColorUtility.white);
        panel.setLayout(new GridLayout(1,3));

        panel.add(compHeader("Employee", 34));
        panel.add(compHeader("Regular", 26));
        panel.add(compHeader("Probationary", 8));

        return panel;
    }

    private JPanel compHeader(String status, int amount) {
        JPanel panel = EffectsUtility.marginedBoxText(new JPanel(),6,6, ColorUtility.white);
        panel.setBackground(ColorUtility.white);
        panel.setBorder(EffectsUtility.borderColor(0,0,0,4));
        panel.setLayout(null);

        JLabel title = new JLabel("Total " + status);
        JLabel number = new JLabel(String.valueOf(amount));

        title.setFont(FontUtility.important(16));
        number.setFont(FontUtility.plain(60));
        number.setForeground(ColorUtility.blueBright);

        title.setBounds(6,0, 200,20);
        number.setBounds(90, 40, 200, 50);

        panel.add(title);
        panel.add(number);

        return panel;
    }

    private JPanel employeeTable() {
        JPanel panel = employeeTablePanel;
        panel.setBackground(ColorUtility.white);
        panel.setLayout(null);

        JLabel searchIcon = ImageUtility.importedImagesInJLabel("/images/tab-icon/search.png");
        searchIcon.setBounds(20,0,30,50);

        JLabel label = new JLabel("Searched by:");
        label.setFont(FontUtility.important(18));
        label.setBounds(50,0,200,50);

        JPanel radioBtn = radioBtn();
        radioBtn.setBounds(200, 16, 250,20);

        JPanel addEmployee = addEmployee();
        addEmployee.setBounds(580, 12, 160,28);

        JPanel searchField = EffectsUtility.searchField(searchBar);
        searchField.setBounds(24, 40, 350,50);

        JLabel note = new JLabel("Click a row to view or edit.");
        note.setFont(FontUtility.plainItalic(12));
        note.setBounds(28, 62, 400, 50);


//        JScrollPane table = employeeScrollpane;
        employeeScrollpane.setBounds(28, 100, 724, 370);

        panel.add(searchIcon);
        panel.add(searchField);
        panel.add(label);
        panel.add(radioBtn);
        panel.add(addEmployee);
        panel.add(note);
        panel.add(employeeScrollpane);

        for (Component comp : panel.getComponents()) {
            System.out.println(comp.getName());
        }

//        searchFieldListener(searchBar, panel, table);

        return panel;
    }

    private JPanel radioBtn() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(ColorUtility.white);

        JRadioButton idBtn = radioBtn("ID");
        idBtn.setPreferredSize(new Dimension(50,10));

        JRadioButton lnBtn = radioBtn("Last Name");

        ButtonGroup group = new ButtonGroup();
        group.add(idBtn);
        group.add(lnBtn);
        idBtn.setSelected(true);

        radioListener(idBtn);
        radioListener(lnBtn);

        panel.add(idBtn, BorderLayout.WEST);
        panel.add(lnBtn, BorderLayout.CENTER);

        return panel;
    }

    private JRadioButton radioBtn(String label) {
        JRadioButton btn = new JRadioButton(label);
        btn.setBackground(ColorUtility.white);
        btn.setFont(FontUtility.plain(14));
        btn.setForeground(ColorUtility.grayDark);
        btn.setFocusPainted(false);

        return btn;
    }

    private JPanel addEmployee() {
        JPanel panel = new JPanel();

        panel.setBackground(ColorUtility.redDark);

        JLabel addNew = new JLabel("+ Add New Employee");
        addNew.setFont(FontUtility.important(12));
        addNew.setForeground(ColorUtility.white);

        panel.add(addNew);

        EffectsUtility.panelHover(panel, ColorUtility.redDark, ColorUtility.redDarkHover);

        return panel;
    }

    //Logic
    private void radioListener(JRadioButton button) {
        button.addActionListener(e -> {
            if (button.isSelected()) {
                //To be use by the searchfield
                isIdSelectedInRadio = button.getText().equalsIgnoreCase("ID");
            }
        });
    }


    public void updateTableValues(Object[][] data) {

        JScrollPane newScrollPane = TableScreen.employeeTable(data);
        newScrollPane.setBounds(28, 100, 724, 370);
        newScrollPane.setName("newScrollPane");

        if (isComponentIsExisting("newScrollPane", employeeTablePanel)) {
            removeByName("newScrollPane", employeeTablePanel);
            employeeTablePanel.add(newScrollPane);
        } else {
            employeeTablePanel.remove(employeeScrollpane);
            System.out.println("removed");
            employeeTablePanel.add(newScrollPane);
        }

        this.employeeTablePanel.revalidate();
        this.employeeTablePanel.repaint();
    }

    private boolean isComponentIsExisting(String name, JPanel panel) {
        for (Component comp : panel.getComponents()) {
            if (name.equalsIgnoreCase(comp.getName())){
                return true;
            }
        }

        return false;
    }

    private void removeByName(String name, JPanel panel) {
        for (Component comp : panel.getComponents()) {
            if (name.equalsIgnoreCase(comp.getName())) {
                panel.remove(comp);
            }
        }
    }




}
