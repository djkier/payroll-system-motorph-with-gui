package org.motorph.utility;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TypeCleaner {

    public static String[] cleanSplit(String line) {

        return line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
    }

    public static Double convertStringToMoney(String money) {
        String removeComma = money.replace(",", "");
        String removeQuotation = removeComma.replace("\"", "");
        return Double.valueOf(removeQuotation);
    }

    public static LocalDate convertStringToDate(String date) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return LocalDate.parse(date, format);
    }

    public static LocalTime convertStringToTime(String time) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(time, format);
    }

    //Get only 2 decimal numbers
    public static double cleanDouble(double number) {
        return Math.round(number * 100.0) / 100.0;
    }

}
