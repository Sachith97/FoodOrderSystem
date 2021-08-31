package com.sac.foodorder.util;

public final class StringUtil {

    private static final String EMPTY_STRING = "";

    public StringUtil() {
    }

    public static boolean isEmpty(String s) {
        return s == null || "".equals(s);
    }

    public static boolean isNotEmpty(String s) {
        return s != null && !"".equals(s.trim());
    }

    public static boolean isValidEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
}
