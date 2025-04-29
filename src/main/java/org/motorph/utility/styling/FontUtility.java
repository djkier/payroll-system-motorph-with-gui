package org.motorph.utility.styling;

import java.awt.*;

public class FontUtility {
    private static String fontFamily = "Helvetica";


    public static Font important(int size) {
        return new Font(fontFamily, Font.BOLD, size);
    }

    public static Font plain(int size) {
        return new Font(fontFamily, Font.PLAIN, size);
    }

    public static String addSpaceFront(String word, int spaceInFront) {
        String edit = word;
        for (int i = 1; i <= spaceInFront; i++) {
            edit = " " + edit;
        }

        return edit;
    }

    public static String addSpaceLast(String word, int spaceInLast) {
        String edit = word;
        for (int i = 1; i <= spaceInLast; i++) {
            edit = edit + " ";
        }

        return edit;
    }

    public static String addSpaceBothSide(String word, int spaceFront, int spaceLast) {
        String editedWord = word;
        editedWord = addSpaceFront(editedWord, spaceFront);
        editedWord = addSpaceLast(editedWord, spaceLast);

        return editedWord;
    }

    public static String addSpaceBothSide(String word, int spaceInBothSide) {
        return addSpaceBothSide(word, spaceInBothSide, spaceInBothSide);
    }

    public static String textUnderline(String text) {
        return "<html><u>" + text + "</u></html>";
    }

    public static Font important() {
        return important(16);
    }

    public static Font plain() {
        return plain(14);
    }
}
