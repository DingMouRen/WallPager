package com.dingmouren.wallpager.utils;


import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 */
public class DateUtils {

    public static String parse(String str){
        DateFormat df = DateFormat.getDateInstance();
        Date date = null;
        try {
            date = df.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.toString();
    }

}
