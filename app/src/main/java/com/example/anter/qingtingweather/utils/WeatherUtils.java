package com.example.anter.qingtingweather.utils;

import com.example.anter.qingtingweather.R;

public class WeatherUtils {
    public static final int TYPE_SUNNY = 1;// 晴
    public static final int TYPE_CLOUDY = 2;// 多云
    public static final int TYPE_SHOWER = 3;// 阵雨
    public static final int TYPE_THUNDER_SHOWER = 4;// 雷阵雨
    public static final int TYPE_SLEET = 6;// 雨夹雪
    public static final int TYPE_LIGHT_RAIN = 8;// 小雨
    public static final int TYPE_SNOW_SHOWER = 19;// 阵雪
    public static final int TYPE_SNOW = 20;// 雪
    public static final int TYPE_OVERCAST = 34;// 阴

    public static int getWeatherIconRes(int weatherType) {
        int result;
        switch (weatherType) {
            case TYPE_SUNNY:
                result = R.mipmap.icon_sunny;
                break;
            case TYPE_CLOUDY:
                result = R.mipmap.icon_cloudy;
                break;
            case TYPE_SHOWER:
                result = R.mipmap.icon_shower;
                break;
            case TYPE_THUNDER_SHOWER:
                result = R.mipmap.icon_thunder_shower;
                break;
            case TYPE_SLEET:
                result = R.mipmap.icon_sleet;
                break;
            case TYPE_LIGHT_RAIN:
                result = R.mipmap.icon_light_rain;
                break;
            case TYPE_SNOW_SHOWER:
                result = R.mipmap.icon_snow_shower;
                break;
            case TYPE_SNOW:
                result = R.mipmap.icon_snow;
                break;
            case TYPE_OVERCAST:
                result = R.mipmap.icon_overcast;
                break;
            default:
                result = R.mipmap.icon_sunny;
                break;
        }
        return result;
    }
}
