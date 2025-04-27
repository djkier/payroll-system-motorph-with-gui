package org.motorph.view.screen;

import javax.swing.*;

public class ScreenPanel {
    protected JPanel panel;

    public ScreenPanel() {
        this.panel = new JPanel();
    }

    public JPanel getView() {
        setUp(panel);
        return panel;
    }

    public void setUp(JPanel pane) {

    }



}
