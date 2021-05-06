package com.example.yr_youramigos.ui.gallery.Level;

public class Data {
    private static int progress=0;
    private static String title=null;

    public static int getProgress() {
        return progress;
    }

    public static void setProgress(int progress) {
        Data.progress = progress;
    }

    public static String getTitle() {
        return title;
    }

    public static void setTitle(String title) {
        Data.title = title;
    }
}
