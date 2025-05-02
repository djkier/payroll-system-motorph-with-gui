package org.motorph.utility.styling;

import java.awt.*;

public class ColorUtility {
    //Color Factory
    private static Color cF (String hexCode) {
        return Color.decode(hexCode);
    }

    public static Color black = cF("#0A0A0A");
    public static Color white = cF("#FFFFFF");
    public static Color graySurface = cF("#D3D3D9");
    public static Color grayBorder = cF("#E0E0E0");
    public static Color grayTabHover = cF("#E0E0E0");
    public static Color grayDark = cF("#404040");
    public static Color grayLight = cF("#F2F2F2");

    public static Color blueBright = cF("#146ADC");
    public static Color blueDark = cF("#1260C6");
    public static Color greenLight = cF("#CEE5D3");
    public static Color greenDark = cF("#0A7E22");
    public static Color redDark = cF("#FD304D");
    public static Color redDarkHover = cF("#db1430");
    public static Color redLight = cF("#FFD6DB");
    public static Color redText = cF("#D32940");
    public static Color violetDark = cF("#1A1A36");
    public static Color violet = cF("#212143");
    public static Color violetText = cF("#1A1A36");
    public static Color yellow = cF("#FFD254");

    public static Color transparent = new Color(0, 0, 0, 0);
}
