package com.example.commonmodule.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

/**
 * 日期工具类
 */
public class DateUtil {
    static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    static final DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static final DateFormat hourMinuteFormat = new SimpleDateFormat("HH:mm");
    static final DateFormat yearFormat = new SimpleDateFormat("yyyy");

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
            yearFormat.setLenient(false);
            Date date = yearFormat.parse(str);
            return true;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 返回时、分
     *
     * @param date
     * @return
     */
    public static String getHourMinute(Date date) {
        return hourMinuteFormat.format(date);
    }


    /**
     * Date 转化成 LocalTime
     *
     * @param date
     * @return
     */
    public static LocalTime dateToLocalTime(Date date) {
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return zonedDateTime.toLocalTime();
    }

    /**
     * Date 转化成 LocalDateTime
     *
     * @param date
     * @return
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return zonedDateTime.toLocalDateTime();
    }

}
