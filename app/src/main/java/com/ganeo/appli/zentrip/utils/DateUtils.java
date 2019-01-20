package com.ganeo.appli.zentrip.utils;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;

public class DateUtils {

    public static LocalDate getLocalDate(String date) {
        return LocalDate.parse(date, DateTimeFormat.forPattern("dd/MM/yyyy"));
    }

    public static LocalDate getLocalDate(Long date) {
        return LocalDate.fromDateFields(new Date(date));
    }

    public static String getStringDate(LocalDate localDate) {
        return localDate.toString(DateTimeFormat.forPattern("dd/MM/yyyy"));
    }

    public static Long getLongDate(LocalDate localDate) {
        return localDate.toDate().getTime();
    }
}
