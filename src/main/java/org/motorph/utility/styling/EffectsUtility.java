package org.motorph.utility.styling;

import javax.swing.*;
import javax.swing.border.MatteBorder;
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

    //Tab options highlight on hover
    public static void panelHover(JPanel panel, Color panelColor, Color colorIn) {
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setBackground(colorIn);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel.setBackground(panelColor);
            }
        });
    }

    //Border color
    public static MatteBorder borderColor(int top, int left, int bottom, int right) {
        return new MatteBorder(top, left, bottom, right, ColorUtility.grayBorder);
    }

    //Spacing JPanel
    public static JPanel horizontalDivider(int height, Color color) {
        JPanel s = new JPanel();
        s.setPreferredSize(new Dimension(30, height));
        s.setBackground(color);

        return s;
    }

    public static JPanel horizontalDivider(int height) {
        return horizontalDivider(height, ColorUtility.transparent);
    }








}
