package com.rto.util;

public class Validator {
    public static boolean isNonEmpty(String s) {
        return s != null && !s.trim().isEmpty();
    }

    public static boolean isValidPhone(String phone) {
        if (phone == null) return false;
        return phone.matches("\\d{10}") || phone.matches("\\+?\\d{10,15}");
    }

    public static boolean isValidRegNo(String reg) {
        return reg != null && reg.length() <= 50 && reg.matches("[A-Za-z0-9\\- ]+");
    }
}
