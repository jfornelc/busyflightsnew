package com.travix.medusa.busyflights.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Functions {

    private Functions(){

    }

    public static LocalDateTime generateLocalDateTime(String str){
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        return LocalDateTime.parse(str, formatter);
    }

    public static Instant generateInstant(String str){
        DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;
        return Instant.from(formatter.parse(str));
    }
}
