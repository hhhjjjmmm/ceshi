package com.example.hjmtest.logic.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class GenebankTimerTask {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 14);
        calendar.set(Calendar.MINUTE, 27);
        calendar.set(Calendar.SECOND, 0);
        Date date = calendar.getTime();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                SimpleDateFormat df=new SimpleDateFormat("HH:mm:ss");
                System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
                System.out.println(df.format(date));// new Date()为获取当前系统时间
                String date1=df.format(new Date());
                String data2=df.format(date);
                try {
                    Date dt=df.parse(date1);
                    Date et=df.parse(data2);
                    if (et.before(dt)){
                        System.out.println("时间超时**");
                    }else {
                        System.out.println("11.45");
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }, date, 1000 * 60 * 60 * 24);
    }
}
