package org.motorph.view.screen;

import org.motorph.utility.styling.ColorUtility;

import javax.swing.*;

public class ScreenPanel {
    private JPanel screenPanel;

    public ScreenPanel() {
        this.screenPanel = screen();
    }

    private JPanel screen() {
        JPanel s = new JPanel();
        s.setBackground(ColorUtility.grayLight);
        return s;
    }

    public JPanel getScreenPanel() {
        return this.screenPanel;
    }

    private void changePanel(JPanel newScreen) {
        screenPanel.removeAll();
        screenPanel.add(newScreen);
        screenPanel.revalidate();
        screenPanel.repaint();
    }
}
