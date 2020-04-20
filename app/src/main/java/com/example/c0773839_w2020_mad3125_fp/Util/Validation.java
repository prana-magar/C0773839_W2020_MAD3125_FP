package com.example.c0773839_w2020_mad3125_fp.Util;

import android.provider.ContactsContract;

import java.util.regex.Pattern;

public class Validation {

    public static boolean Email(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();

    }

    public static boolean Phone(String phone) {
        return (phone.length() >= 7 && phone.length() <= 16);
    }
}
