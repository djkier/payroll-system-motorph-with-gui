package org.motorph.controller;

import org.motorph.view.screen.PayrollScreen;

import javax.swing.*;

public class PayrollController {
    private PayrollScreen ps;

    public PayrollController() {
        this.ps = new PayrollScreen();
    }

    public JPanel getPanel() {
        return this.ps.getView();
    }
}
