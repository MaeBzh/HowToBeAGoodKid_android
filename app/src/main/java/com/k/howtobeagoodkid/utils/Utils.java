package com.k.howtobeagoodkid.utils;

import android.database.Cursor;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Locale;

public class Utils {
    public static String dateToString(DateTime date){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("DD-MM-YYYY").withLocale(Locale.FRANCE);
        return date.toString(dateTimeFormatter);
    }

    public static DateTime stringToDate(String str){
        return DateTime.parse(str, DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public static boolean getBoolean(int columnIndex, Cursor cursor) {
        boolean result = true;
        if (cursor.isNull(columnIndex) || cursor.getShort(columnIndex) == 0) {
            result = false;
        }
        return result;
    }
}
