package org.motorph.utility.styling;

import java.awt.*;

public class FontUtililty {
    private static String fontFamily = "Helvetica";


    public static Font important(int size) {
        return new Font(fontFamily, Font.BOLD, size);
    }

    public static Font important() {
        return important(16);
    }
}
