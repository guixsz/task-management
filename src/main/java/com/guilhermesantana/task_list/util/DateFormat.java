package com.guilhermesantana.task_list.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormat {

    public static String toHour(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return date.format(formatter);
    }

    public static String brazillianTime(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }
}
