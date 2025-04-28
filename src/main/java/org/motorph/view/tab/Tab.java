package org.motorph.view.tab;

import org.motorph.utility.ImageUtility;
import org.motorph.utility.styling.ColorUtility;
import org.motorph.utility.styling.EffectsUtility;
import org.motorph.utility.styling.FontUtililty;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Tab {
    private JPanel tab;


    public Tab(String name, String pathFromResources) {
        this.tab = setUp(name, pathFromResources);
    }

    private JPanel setUp(String name, String pathFromResources) {
        JPanel t = new JPanel();
        t.setBackground(ColorUtility.grayLight);
        t.setForeground(ColorUtility.violetText);
        t.setPreferredSize(new Dimension(178, 40));
        t.setLayout(new BorderLayout());
        t.setBorder(new EmptyBorder(0, 16, 0, 0));

        //Uncomment after testing
//        t.add(ImageUtility.importedImagesInJLabel(pathFromResources));
        //testing for size
        t.add(ImageUtility.importedResizedInJLabel(pathFromResources, 16, 16), BorderLayout.WEST);
        t.add(text(name), BorderLayout.CENTER);

        //Add hover effects
        EffectsUtility.panelHover(t, ColorUtility.grayLight, ColorUtility.grayTabHover);

        return t;
    }

    private JLabel text(String name) {
        String space = "  " + name;
        JLabel tText = new JLabel(space);
        tText.setFont(FontUtililty.important(18));
        return tText;
    }

    public JPanel getTab() {
        return this.tab;
    }

}
