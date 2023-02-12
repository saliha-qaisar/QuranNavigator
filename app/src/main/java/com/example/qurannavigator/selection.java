package com.example.qurannavigator;

public class selection {
    public selection(String format, Integer number, String name) {
        this.format = format;
        this.number = number;
        this.name = name;
    }

    public selection() {
        this.name="";
        this.number=0;
    }

    String format;
    Integer number;
    String name;

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
