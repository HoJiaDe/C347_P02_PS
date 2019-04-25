package com.example.c347_p02_ps;

public class Holiday {
    private String title;
    private String date;
    public Holiday(String title, String date) {
        this.title = title;
        this.date = date;
    }
    public String getTitle() {
        return title;
    }
    public String getDate() {
        return date;
    }
}