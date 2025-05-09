package org.motorph.view.screen;

import org.motorph.model.datarepositories.EmployeeRepository;
import org.motorph.utility.ImageUtility;
import org.motorph.utility.styling.ColorUtility;
import org.motorph.utility.styling.EffectsUtility;
import org.motorph.utility.styling.FontUtility;
import org.motorph.view.screen.components.TableScreen;

import javax.swing.*;
import java.awt.*;

public class EmployeeDetailsScreen extends ScreenView {
    private EmployeeRepository employeeRepository;
    private boolean isIdSelectedInRadio;
    private JTextField searchBar;
    private JPanel employeeTablePanel;
    private JTable table;
    private JPanel employeeHeader;
    private JPanel addNewButton;



    public EmployeeDetailsScreen(EmployeeRepository employeeRepository) {
        super(employeeRepository);
        this.employeeRepository = employeeRepository;
        this.isIdSelectedInRadio = true;
        this.employeeTablePanel = new JPanel();
        this.searchBar = new JTextField(30);
        this.table = new JTable(TableScreen.employeeRowData(employeeRepository.employeeTableData()));
        this.employeeHeader = new JPanel();
        this.addNewButton = new JPanel();


        setPanel(setUp());
    }

    //Getters
    public JTextField getSearchBar() {
        return this.searchBar;
    }

    public boolean isIdSelectedInRadio() {
        return this.isIdSelectedInRadio;
    }

    public JPanel getAddNewButton() {
        return addNewButton;
    }

    public JTable getTable() {
        return this.table;
    }

    //User interface methods for the employee screen
    @Override
    public JPanel getView() {
        return getPanel();
    }

    @Override
    public JPanel body() {
        JPanel panel = new JPanel();
        panel.setBackground(ColorUtility.white);
        panel.setLayout(null);

        JPanel employeeHeader = employeeHeader();
        updateEmployeeHeader(employeeRepository);
        employeeHeader.setBounds(16,16,740,120);

        JPanel grayStripe1 = EffectsUtility.horizontalMargin(24);
        grayStripe1.setBounds(0,152, 800, 24);

        JPanel employeeTable = employeeTable();
        employeeTable.setBounds(0, 176,752,600);


        panel.add(employeeHeader);
        panel.add(grayStripe1);
        panel.add(employeeTable);


        return panel;
    }

    @Override
    public String setLabel() {
        return "Employee";
    }

    private JPanel employeeHeader() {
        JPanel panel = this.employeeHeader;
        panel.setName("employeeHeader");
        panel.setBackground(ColorUtility.white);
        panel.setLayout(new GridLayout(1,3));

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

        JLabel note = new JLabel("Double click a row to view or edit.");
        note.setFont(FontUtility.plainItalic(12));
        note.setBounds(28, 62, 400, 50);

        JTable intialTable = TableScreen.generalTable(this.table);
        JScrollPane initialScrollPane = TableScreen.scrollPane(intialTable);
        initialScrollPane.setName("initialScrollPane");

        initialScrollPane.setBounds(28, 100, 724, 370);

        panel.add(searchIcon);
        panel.add(searchField);
        panel.add(label);
        panel.add(radioBtn);
        panel.add(addEmployee);
        panel.add(note);
        panel.add(initialScrollPane);


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
        JPanel panel = this.addNewButton;

        panel.setBackground(ColorUtility.redDark);

        JLabel addNew = new JLabel("+ Add New Employee");
        addNew.setFont(FontUtility.important(12));
        addNew.setForeground(ColorUtility.white);

        panel.add(addNew);

        EffectsUtility.panelHover(panel, ColorUtility.redDark, ColorUtility.redDarkHover);

        return panel;
    }

    //Radio interaction
    private void radioListener(JRadioButton button) {
        button.addActionListener(e -> {
            if (button.isSelected()) {
                //check the pick option from radio, that will be use as basis of searchfield
                boolean isIdSelected = button.getText().equalsIgnoreCase("ID");
                if (isIdSelectedInRadio != isIdSelected) {
                    isIdSelectedInRadio = isIdSelected;
                    this.searchBar.setText("");
                }

            }
        });
    }

    //Updates the employee screen header
    public void updateEmployeeHeader(EmployeeRepository employeeRepository) {
        this.employeeHeader.removeAll();
        this.employeeHeader.add(compHeader("Employee", employeeRepository.totalEmployee()));
        this.employeeHeader.add(compHeader("Regular", employeeRepository.totalRegular()));
        this.employeeHeader.add(compHeader("Probationary", employeeRepository.totalProbationary()));
        this.employeeHeader.revalidate();
        this.employeeHeader.repaint();
    }

    //Updates the employee table
    public void updateTableValues(Object[][] data) {
        this.table.setModel(TableScreen.employeeRowData(data));
        JTable addUIInTable = TableScreen.generalTable(this.table);
        JScrollPane newScrollPane = TableScreen.scrollPane(addUIInTable);

        newScrollPane.setBounds(28, 100, 724, 370);
        newScrollPane.setName("newScrollPane");

        if (isComponentIsExisting("newScrollPane")) {
            removeByName("newScrollPane");
            employeeTablePanel.add(newScrollPane);
        } else {
            removeByName("initialScrollPane");
            employeeTablePanel.add(newScrollPane);
        }

        this.employeeTablePanel.revalidate();
        this.employeeTablePanel.repaint();
    }

    private boolean isComponentIsExisting(String compName) {
        for (Component comp : employeeTablePanel.getComponents()) {
            if (compName.equalsIgnoreCase(comp.getName())){
                return true;
            }
        }

        return false;
    }

    private void removeByName(String name) {
        for (Component comp : employeeTablePanel.getComponents()) {
            if (name.equalsIgnoreCase(comp.getName())) {
                employeeTablePanel.remove(comp);
            }
        }
    }






}
