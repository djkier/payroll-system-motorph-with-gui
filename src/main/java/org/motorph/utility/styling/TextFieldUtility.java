package org.motorph.utility.styling;

import javax.swing.*;
import java.awt.*;

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

}
