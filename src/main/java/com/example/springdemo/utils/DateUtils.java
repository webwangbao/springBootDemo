package com.example.springdemo.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: wangbao02
 * @CreateDate: 2018/6/4 18:36
 * @Description:
 */
public class DateUtils {
    public final static String YMD_HMS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 根据相应日期格式：将Timestamp转换成字符串
     * @param timestamp
     * @return
     */
    public static String convertSqlTimeStampToString(Timestamp timestamp, String dateFormat) {
        DateFormat df = new SimpleDateFormat(dateFormat);
        return df.format(timestamp);
    }

    /**
     * 将日期格式为DateTime转为字符串
     * @param date
     * @param dateFormat
     * @return
     */
    public static String convertDateTimeToString(Date date, String dateFormat) {
        DateFormat df = new SimpleDateFormat(dateFormat);
        return df.format(date);
    }

    public static String convertDateTimeToString(Date date) {
        DateFormat df = new SimpleDateFormat(YMD_HMS);
        return df.format(date);
    }

    /**
     * 将unix时间戳(单位是秒)转成日期格式字符串
     * @param timeStamp
     * @param dateFormat
     * @return
     */
    public static String convertIntToDateString(long timeStamp, String dateFormat) {
        timeStamp = timeStamp * 1_000;
        DateFormat df = new SimpleDateFormat(dateFormat);
        return df.format(timeStamp);
    }
}
