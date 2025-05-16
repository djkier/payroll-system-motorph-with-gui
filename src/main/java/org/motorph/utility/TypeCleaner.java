package org.motorph.utility;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TypeCleaner {

    public static String[] cleanSplit(String line) {

        return line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
    }

    public static String removeQuotes(String text) {
        text = text.replaceAll("^\"|\"$", "");
        return text;
    }

    public static Double convertStringToMoney(String money) {
        String removeComma = money.replace(",", "");
        String removeQuotation = removeComma.replace("\"", "");
        return Double.valueOf(removeQuotation);
    }

    public static LocalDate convertStringToDate(String date) {
        String[] dateSplit = date.split("/");
        int month = Integer.valueOf(dateSplit[0]);
        int day = Integer.valueOf(dateSplit[1]);
        int year = Integer.valueOf(dateSplit[2]);
        return LocalDate.of(year, month, day);
    }

    public static LocalTime convertStringToTime(String time) {
        String[] timeSplit = time.split(":");
        int hour = Integer.valueOf(timeSplit[0]);
        int minutes = Integer.valueOf(timeSplit[1]);

        return LocalTime.of(hour, minutes);
    }

    //Get only 2 decimal numbers
    public static double cleanDouble(double number) {
        return Math.round(number * 100.0) / 100.0;
    }


}
