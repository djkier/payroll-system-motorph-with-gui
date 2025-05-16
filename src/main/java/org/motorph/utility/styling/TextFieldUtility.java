package org.motorph.utility.styling;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TextFieldUtility {
    public static JTextField textField (int cols) {
        JTextField t = new JTextField(cols);
        t.setMargin(new Insets(0, 6, 0, 0));

        return t;
    }

    public static JPasswordField passwordField (int cols) {
        JPasswordField t = new JPasswordField(cols);
        t.setMargin(new Insets(0, 6,0,0 ));
        return t;
    }

    public static JPanel textAndField(String title, int spacing, JTextField textField) {
        JPanel panel = new JPanel();
        panel.setBackground(ColorUtility.white);
        panel.setLayout(new BorderLayout());


        JLabel label = new JLabel(title);
        label.setFont(FontUtility.important(12));
        label.setPreferredSize(new Dimension(spacing,30));

        JPanel jTextField = EffectsUtility.searchField(textField);
        jTextField.setName("customizedTextField");

        panel.add(label, BorderLayout.WEST);
        panel.add(jTextField, BorderLayout.CENTER);

        return panel;
    }

    public static JPanel textAndField(String title, JTextField textField) {
        return textAndField(title, 72, textField);
    }

    public static void setBorderColor(JPanel panel, Color color) {
        for (Component comp : panel.getComponents()) {
            if (comp.getName() != null && comp.getName().equals("customizedTextField")) {
                JPanel compPanel = (JPanel) comp;
                EffectsUtility.changeSearchFieldColor(compPanel, color);
            }
        }
    }

    public static void textFieldPlaceHolder(JTextField textField, String text) {
        textField.setForeground(Color.gray);
        textField.setText(text);


        textField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if(textField.getText().equals(text)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);

                }
            }

            public void focusLost(FocusEvent e) {
                if(textField.getText().isEmpty()) {
                    textField.setText(text);
                    textField.setForeground(Color.gray);

                }

            }
        });

    }

    public static JPanel textAndComboBox(String title, JComboBox<String> comboBox) {
        JPanel panel = new JPanel();
        panel.setBackground(ColorUtility.white);
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel(title);
        label.setFont(FontUtility.important(12));
        label.setPreferredSize(new Dimension(200, 30));

//        comboBox.setSelectedIndex(0);
        comboBox.setBackground(ColorUtility.white);
        comboBox.setFont(FontUtility.plain(12));
        comboBox.setEditable(false);

        panel.add(label, BorderLayout.NORTH);
        panel.add(comboBox, BorderLayout.CENTER);


        return panel;
    }


}
