package com.kexinzhida.backend.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * LocalDateUtils工具类
 */
public final class LocalDateUtils {

    private LocalDateUtils() {
    }

    /**
     * 转换
     *
     * @param localDate 日期
     * @return 日期
     */
    public static Date ofDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 转换
     * @param localDateTime 年月日
     * @return 日期
     */
    public static Date ofDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 转换
     *
     * @param date 日期
     * @return 日期
     */
    public static LocalDate ofLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
