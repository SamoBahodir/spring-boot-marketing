package com.example.hellospring.cor.util;

import java.text.DateFormat;
import java.util.Date;

public class DateParser {

    public static Date tryParse(String dateAsString, DateFormat dateFormat) {
        try {
            return dateFormat.parse(dateAsString);
        } catch (Exception ignored) {
            return null;
        }
    }

    public static String convertDate(Date date, DateFormat dateFormat) {
        try {
            return dateFormat.format(date);
        } catch (Exception e) {
            return null;
        }
    }
}
