package org.motorph.view;

import org.motorph.utility.ImageUtility;
import org.motorph.utility.styling.ColorUtility;
import org.motorph.view.tab.TabPanel;

import javax.swing.*;
import java.awt.*;

public class MainApplication {
    private JFrame app;
    private TabPanel tabPanel;


    public MainApplication(String appTitle) {
        this.tabPanel = new TabPanel();

        //set up last
        this.app = setUpApp(appTitle);
    }

    private JFrame setUpApp(String title) {
        JFrame w = new JFrame(title);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setLocation(-1650,50);
        w.setSize(1024, 768);
        //Set true after development
//        w.setLocationRelativeTo(null);
        w.setLayout(new BorderLayout());
        w.setBackground(ColorUtility.black);
        w.setResizable(false);

        ImageIcon icon = ImageUtility.importImages("/images/icon2.png");
        Image img = icon.getImage();
        w.setIconImage(img);

        w.add(tabPanel.getTabPanel(), BorderLayout.WEST);

        return w;
    }

    public void start() {
        this.app.setVisible(true);
    }



}
