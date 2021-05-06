package com.example.yr_youramigos.ui.gallery;

public class User {
    private static String ph="9876543210";
    private static String msg="";

    public static String getPh() {
        return ph;
    }

    public static String getMsg() {
        return msg;
    }

    public static void setMsg(String msg) {
        User.msg = msg;
    }

    public static void setPh(String ph) {
        User.ph = ph;
    }
}
