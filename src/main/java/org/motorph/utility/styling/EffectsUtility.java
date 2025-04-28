package org.motorph.utility.styling;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EffectsUtility {

    public static void mouseHover(JButton btn, Color btnColor, Color colorIn) {
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(colorIn);
                btn.setForeground(btnColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn.setBackground(btnColor);
                btn.setForeground(Color.white);
            }
        });
    }

}
