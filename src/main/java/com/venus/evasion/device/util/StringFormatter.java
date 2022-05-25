package com.venus.evasion.device.util;

public class StringFormatter {

    public static String format(String field) {
        return field.replace(" ", "-").toUpperCase();
    }
}
