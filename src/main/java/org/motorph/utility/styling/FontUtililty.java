package org.motorph.utility.styling;

import java.awt.*;

public class FontUtililty {
    private static String fontFamily = "Helvetica";


    public static Font important(int size) {
        return new Font(fontFamily, Font.BOLD, size);
    }

    public static Font plain(int size) {
        return new Font(fontFamily, Font.PLAIN, size);
    }


    public static Font important() {
        return important(16);
    }

    public static Font plain() {
        return plain(14);
    }
}
