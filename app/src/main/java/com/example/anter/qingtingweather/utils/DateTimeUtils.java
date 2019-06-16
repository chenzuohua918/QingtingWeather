package com.example.anter.qingtingweather.utils;

import android.content.Context;
import android.text.TextUtils;

import com.example.anter.qingtingweather.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtils {
    private static String[] WEEKDAYS;

    public static String dateToWeek(Context context, String dateStr) {
        try {
            if (!TextUtils.isEmpty(dateStr)) {
                Date currentDate = new Date();
                int currentYear = Integer.valueOf(new SimpleDateFormat("yyyy").format(currentDate));
                int currentDay = Integer.valueOf(new SimpleDateFormat("d").format(currentDate));

                Date date = new SimpleDateFormat("yyyyMMdd").parse(dateStr);
                // 先获取年份
                int year = Integer.valueOf(new SimpleDateFormat("yyyy").format(date));
                // 获取一年中的第几天
                int day = Integer.valueOf(new SimpleDateFormat("d").format(date));

                String week = "";
                // 计算如果是去年的
                if (currentYear - year == 1) {
                    // 如果当前正好是 1月1日 计算去年有多少天，指定时间是否是一年中的最后一天
                    if (currentDay == 1) {
                        int yearDay;
                        if (year % 400 == 0) {
                            yearDay = 366;// 世纪闰年
                        } else if (year % 4 == 0 && year % 100 != 0) {
                            yearDay = 366;// 普通闰年
                        } else {
                            yearDay = 365;// 平年
                        }
                        if (day == yearDay) {
                            week = context.getString(R.string.yesterday);
                        }
                    }
                } else {
                    if (currentDay - day == 1) {
                        week = context.getString(R.string.yesterday);
                    } else if (currentDay - day == 0) {
                        week = context.getString(R.string.today);
                    }
                }

                if (TextUtils.isEmpty(week)) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date);
                    int weekIndex = calendar.get(Calendar.DAY_OF_WEEK);
                    if (WEEKDAYS == null) {
                        WEEKDAYS = context.getResources().getStringArray(R.array.weeks);
                    }
                    week = WEEKDAYS[weekIndex - 1];
                }
                return week;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String formatDate(String date, String inPattern, String outPattern) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(inPattern);
            return new SimpleDateFormat(outPattern).format(sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
