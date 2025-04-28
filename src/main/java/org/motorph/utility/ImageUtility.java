package org.motorph.utility;

import org.motorph.PayrollSystem;

import javax.swing.*;
import java.awt.Image;

public class ImageUtility {

    public static ImageIcon resizeImage(ImageIcon img, int xLength, int yLength) {
        Image image = img.getImage();
        Image newImage = image.getScaledInstance(xLength, yLength, Image.SCALE_SMOOTH);
        return new ImageIcon(newImage);
    }

    public static JLabel resizedImageInJLabel(ImageIcon img, int xLength, int yLength) {
        return new JLabel(resizeImage(img, xLength, yLength));
    }

    public static ImageIcon importImages(String pathFromResources) {
        return new ImageIcon(PayrollSystem.class.getResource(pathFromResources));
    }

    public static JLabel importedImagesInJLabel(ImageIcon img) {
        return new JLabel(img);
    }

    public static JLabel importedImagesInJLabel(String pathFromResources) {
        return importedImagesInJLabel(importImages(pathFromResources));
    }



    public static ImageIcon importResizeImage(String pathFromResources, int xLength, int yLength) {
        ImageIcon importImage = importImages(pathFromResources);
        return resizeImage(importImage, xLength, yLength);
    }

    public static JLabel importedResizedInJLabel(String pathFromResources, int xLength, int yLength) {
        return new JLabel(importResizeImage(pathFromResources, xLength, yLength));
    }
}
