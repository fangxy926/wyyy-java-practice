package com.example.studentmodule.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {
    static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    static final DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    /**
     * 将String转为Date类型
     *
     * @param dateString
     * @return
     * @throws ParseException
     */
    public static Date stringToDate(String dateString) throws ParseException {
        Date date = dateFormat.parse(dateString);
        return date;
    }

    /**
     * 将LocalDateTime转为Date
     *
     * @param localDateTime
     * @return
     */
    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 判断是否为年份
     *
     * @param str
     * @return
     */
    public static boolean isYear(String str) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
            dateFormat.setLenient(false);
            Date date = dateFormat.parse(str);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

}
