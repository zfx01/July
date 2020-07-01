package com.july.demo.other;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Gettime {
    public static Date time() {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        System.out.println("当前时间为: " + ft.format(dNow));
        return dNow;
    }
}
