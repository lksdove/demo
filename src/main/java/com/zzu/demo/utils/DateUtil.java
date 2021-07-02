package com.zzu.demo.utils;

import com.zzu.demo.exception.ParaException;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * 时间工具类
 */
@Slf4j
public class DateUtil {

    public static final String FULL_TIME_PATTERN = "yyyyMMddHHmmss";

    public static final String FULL_TIME_SPLIT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static String formatFullDateTime(LocalDateTime localDateTime) {
        return formatFullDate(localDateTime, FULL_TIME_PATTERN);
    }

    public static String formatFullDate(LocalDateTime localDateTime, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(dateTimeFormatter);
    }

    private static String getDateFormat(Date date, String dateFormatType) {
        SimpleDateFormat simformat = new SimpleDateFormat(dateFormatType);
        return simformat.format(date);
    }

    //年月日
    public static LocalDate formatStringToLocalDate(String strDate, String pattern) {
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern(pattern);
        LocalDate parse = LocalDate.parse(strDate, dateTimeFormatter1);
        return parse;
    }

    //年月日时分秒
    public static LocalDateTime formatStringToLocalDateTime(String strDate, String pattern) {
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime parse = LocalDateTime.parse(strDate, dateTimeFormatter1);
        return parse;
    }

    //时分秒
    public static LocalTime formatStringToLocalTime(String strDate, String pattern) {
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern(pattern);
        LocalTime parse = LocalTime.parse(strDate, dateTimeFormatter1);
        return parse;
    }

    public static Date formatStringToDate(String strDate, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date parse = null;
        try {
            parse = sdf.parse(strDate);
        } catch (ParseException e) {
            log.info("日期格式转换异常");
            throw new ParaException("日期格式转换异常");
        }
        return parse;
    }

    public static String formatCSTTime(String date, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        Date d = sdf.parse(date);
        return DateUtil.getDateFormat(d, format);
    }

}
