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
                panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {

                panel.setBackground(panelColor);
                panel.setCursor(Cursor.getDefaultCursor());

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

    public static JPanel margin(int width, int height, Color color) {
        JPanel border = new JPanel();
        border.setPreferredSize(new Dimension(width,height));
        border.setBackground(color);

        return border;
    }

    public static JPanel verticalMargin(int space) {
        return margin(space, 12, ColorUtility.grayLight);
    }

    public static JPanel horizontalMargin(int space) {
        return margin(24,space, ColorUtility.grayLight);
    }

    public static JPanel insideMarginHorizontal(int height, Color color) {
        return margin(12, height, color);
    }

    public static JPanel insideMarginHorizontal() {
        return insideMarginHorizontal(8, ColorUtility.white);
    }

    public static JPanel insideMarginVertical(int width, Color color) {
        return margin(width, 12, color);
    }
    public static JPanel insideMarginVertical() {

        return insideMarginVertical(12, ColorUtility.white);
    }

    public static JPanel marginedBoxText(JPanel panel , int width, int height, Color color) {
        JPanel box = new JPanel();
        box.setLayout(new BorderLayout());
        box.setBackground(color);

        box.add(insideMarginHorizontal(height, color), BorderLayout.NORTH);
        box.add(insideMarginVertical(width, color), BorderLayout.WEST);
        box.add(insideMarginHorizontal(height, color), BorderLayout.SOUTH);
        box.add(insideMarginVertical(width, color), BorderLayout.EAST);

        box.add(panel, BorderLayout.CENTER);

        return box;
    }

    public static JPanel marginedBoxText(JPanel panel , int width, int height) {
        return marginedBoxText(panel, width, height, ColorUtility.white);
    }

    public static JPanel marginedBoxText(JPanel panel) {
        return marginedBoxText(panel, 12, 8);
    }

    public static JPanel marginedPanelWithText(String text, Font font, Color color) {
        JPanel p  = new JPanel();
        p.setLayout(new BorderLayout());
        JLabel l = new JLabel(text);
        l.setForeground(ColorUtility.black);
        l.setBackground(ColorUtility.transparent);
        l.setFont(font);
        l.setHorizontalAlignment(SwingConstants.LEFT);

        p.add(l, BorderLayout.WEST);
        p.setBackground(color);
        return marginedBoxText(p,6, 6, color);
    }

    public static JPanel marginedPanelWithText(String text, Color color) {
        return marginedPanelWithText(text, FontUtility.plain(12), color);
    }

    public static JPanel searchField(int columns) {
        JPanel panel = new JPanel();
        panel.setBackground(ColorUtility.transparent);

        JTextField searchField = new JTextField(columns);
        searchField.setBackground(ColorUtility.white);
        searchField.setForeground(Color.DARK_GRAY);
        searchField.setFont(FontUtility.plain(12));

        searchField.setBorder(BorderFactory.createLineBorder(ColorUtility.white, 1));
        JPanel border = new JPanel();
        border.add(searchField);
        border.setBackground(ColorUtility.white);

        JPanel searchBorder = EffectsUtility.marginedBoxText(border, 0, 0, ColorUtility.white);
        searchBorder.setBorder(BorderFactory.createLineBorder(ColorUtility.graySurface, 2));
        searchBorder.setBackground(ColorUtility.white);

        panel.add(searchBorder);

        return panel;
    }












}
