package com.example.anter.qingtingweather.bean;

public class ForecastDay {
    public String date;// 日期
    public String week;// 周几
    public String sunrise;// 日出时间
    public String sunset;// 日落时间
    public int lowTemp;// 最低温度
    public int highTemp;// 最高温度
    public String nightWeather;// 夜间天气
    public int nightWeatherType;// 夜间天气类型
    public String nightWindSpeed;// 夜间风速
    public String nightWindDirection;// 夜间风向
    public String nightBgPicUrl;// 夜间背景图片（大）url
    public String nightSmPicUrl;// 夜间背景图片（小）url
    public String dayWeather;// 日间天气
    public int dayWeatherType;// 日间天气类型
    public String dayWindSpeed;// 日间风速
    public String dayWindDirection;// 日间风向
    public String dayBgPicUrl;// 日间背景图片（大）url
    public String daySmPicUrl;// 日间背景图片（小）url

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public int getLowTemp() {
        return lowTemp;
    }

    public void setLowTemp(int lowTemp) {
        this.lowTemp = lowTemp;
    }

    public int getHighTemp() {
        return highTemp;
    }

    public void setHighTemp(int highTemp) {
        this.highTemp = highTemp;
    }

    public String getNightWeather() {
        return nightWeather;
    }

    public void setNightWeather(String nightWeather) {
        this.nightWeather = nightWeather;
    }

    public int getNightWeatherType() {
        return nightWeatherType;
    }

    public void setNightWeatherType(int nightWeatherType) {
        this.nightWeatherType = nightWeatherType;
    }

    public String getNightWindSpeed() {
        return nightWindSpeed;
    }

    public void setNightWindSpeed(String nightWindSpeed) {
        this.nightWindSpeed = nightWindSpeed;
    }

    public String getNightWindDirection() {
        return nightWindDirection;
    }

    public void setNightWindDirection(String nightWindDirection) {
        this.nightWindDirection = nightWindDirection;
    }

    public String getNightBgPicUrl() {
        return nightBgPicUrl;
    }

    public void setNightBgPicUrl(String nightBgPicUrl) {
        this.nightBgPicUrl = nightBgPicUrl;
    }

    public String getNightSmPicUrl() {
        return nightSmPicUrl;
    }

    public void setNightSmPicUrl(String nightSmPicUrl) {
        this.nightSmPicUrl = nightSmPicUrl;
    }

    public String getDayWeather() {
        return dayWeather;
    }

    public void setDayWeather(String dayWeather) {
        this.dayWeather = dayWeather;
    }

    public int getDayWeatherType() {
        return dayWeatherType;
    }

    public void setDayWeatherType(int dayWeatherType) {
        this.dayWeatherType = dayWeatherType;
    }

    public String getDayWindSpeed() {
        return dayWindSpeed;
    }

    public void setDayWindSpeed(String dayWindSpeed) {
        this.dayWindSpeed = dayWindSpeed;
    }

    public String getDayWindDirection() {
        return dayWindDirection;
    }

    public void setDayWindDirection(String dayWindDirection) {
        this.dayWindDirection = dayWindDirection;
    }

    public String getDayBgPicUrl() {
        return dayBgPicUrl;
    }

    public void setDayBgPicUrl(String dayBgPicUrl) {
        this.dayBgPicUrl = dayBgPicUrl;
    }

    public String getDaySmPicUrl() {
        return daySmPicUrl;
    }

    public void setDaySmPicUrl(String daySmPicUrl) {
        this.daySmPicUrl = daySmPicUrl;
    }
}
