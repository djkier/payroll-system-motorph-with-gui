package org.motorph.view.screen;

import javax.swing.*;

public class ScreenView {
    protected JPanel panel;

    public ScreenView() {
        this.panel = new JPanel();
    }

    public JPanel getView() {
        setUp(panel);
        return panel;
    }

    public void setUp(JPanel pane) {

    }



}
