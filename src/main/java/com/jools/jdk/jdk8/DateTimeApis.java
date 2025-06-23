package com.jools.jdk.jdk8;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/13 18:07
 * @description: TODO
 */
public class DateTimeApis {

    @Test
    public void calLocalDate() {

        LocalDate localDate = LocalDate.now();
        LocalDate after = localDate.plus(1, ChronoUnit.WEEKS);
        System.out.println("一周之后的日期为:" + after);    // 输出: 2025-02-20

        // 计算两个日期的时间间隔
        LocalDate date1 = LocalDate.parse("2024-09-11");
        LocalDate date2 = LocalDate.parse("2025-02-13");
        Period period = Period.between(date2, date1);
        System.out.println(
                "两个日期相差的时间间隔为:" + period.getYears() + "年" +
                        period.getMonths() + "月" +
                        period.getDays() + "天");    // 输出: 两个日期相差的时间间隔为:0年-5月-2天
    }


    @Test
    public void testStrToLocalDateTime() {
        LocalDate date = LocalDate.of(2025, 2, 13);
        LocalDate parseDate = LocalDate.parse("2025-02-13");
        Assert.assertEquals(date, parseDate);

        LocalDateTime dateTime = LocalDateTime.of(2025, 2, 13, 12, 12, 22);

        // Define the formatter with the correct pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Parse the string using the formatter
        LocalDateTime parseDateTime = LocalDateTime.parse("2025-02-13 12:12:22", formatter);

        Assert.assertEquals(dateTime, parseDateTime);
    }

    public static void main(String[] args) {

        LocalDate now = LocalDate.now();
        System.out.printf("data format: %s%n", now);     // 输出: 2023-08-03


        // format HH:mm:ss
        LocalTime time = LocalTime.now().withNano(0);
        System.out.println(String.format("time format: %s", time)); // 输出: 18:07:00

        // format yyyy-MM-dd HH:mm:ss
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTime.format(dateTimeFormatter));  // 输出: 2023-08-03 18:07:00
    }
}
