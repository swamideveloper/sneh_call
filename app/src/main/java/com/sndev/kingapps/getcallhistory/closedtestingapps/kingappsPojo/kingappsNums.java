package com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsPojo;


public class kingappsNums {
    String number;
    String time;
    String title;

    public String getNumber() {
        return this.number;
    }

    public String getTime() {
        return this.time;
    }

    public String getTitle() {
        return this.title;
    }

    public kingappsNums(String str, String str2, String str3) {
        this.title = str;
        this.number = str2;
        this.time = str3;
    }
}
