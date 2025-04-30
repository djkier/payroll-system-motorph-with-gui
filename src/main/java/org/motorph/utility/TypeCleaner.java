package org.motorph.utility;

public class TypeCleaner {

    public static String[] cleanSplit(String line) {

        return line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
    }

    public static Double convertStringToMoney(String money) {
        String removeComma = money.replace(",", "");
        String removeQuotation = removeComma.replace("\"", "");
        return Double.valueOf(removeQuotation);
    }

}
