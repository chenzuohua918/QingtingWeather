package com.example.anter.qingtingweather.bean;

public class ForecastHour {
    public String date;// 日期
    public String time;// 时间，如22:00
    public String weather;// 天气
    public int weatherType;// 天气类型
    public int temp;// 温度
    public String shidu;// 湿度
    public String windSpeed;// 风速
    public String windDirection;// 风向

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public int getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(int weatherType) {
        this.weatherType = weatherType;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public String getShidu() {
        return shidu;
    }

    public void setShidu(String shidu) {
        this.shidu = shidu;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }
}
