package com.example.anter.qingtingweather.bean;

import java.util.List;

public class WeatherBean {
    public String city;// 例：井冈山
    public String upper;// 例：吉安
    public String cityCode;// 编号
    public String updateTime;// 更新时间
    public String shidu;// 湿度
    public String weather;// 天气
    public int weatherType;// 天气类型
    public int temp;// 实时温度
    public String windSpeed;// 风速
    public String windDirection;// 风向
    public int tiganTemp;// 体感温度
    public int no2;// 二氧化氮
    public int pm25;// PM2.5
    public int o3;// 臭氧
    public int so2;// 二氧化硫
    public int pm10;// PM10.
    public int co;// 一氧化碳
    public String quality;// 空气质量
    public String suggest;// 建议
    public List<ForecastDay> forecastDayList;
    public List<ForecastHour> forecastHourList;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUpper() {
        return upper;
    }

    public void setUpper(String upper) {
        this.upper = upper;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getShidu() {
        return shidu;
    }

    public void setShidu(String shidu) {
        this.shidu = shidu;
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

    public int getTiganTemp() {
        return tiganTemp;
    }

    public void setTiganTemp(int tiganTemp) {
        this.tiganTemp = tiganTemp;
    }

    public int getNo2() {
        return no2;
    }

    public void setNo2(int no2) {
        this.no2 = no2;
    }

    public int getPm25() {
        return pm25;
    }

    public void setPm25(int pm25) {
        this.pm25 = pm25;
    }

    public int getO3() {
        return o3;
    }

    public void setO3(int o3) {
        this.o3 = o3;
    }

    public int getSo2() {
        return so2;
    }

    public void setSo2(int so2) {
        this.so2 = so2;
    }

    public int getPm10() {
        return pm10;
    }

    public void setPm10(int pm10) {
        this.pm10 = pm10;
    }

    public int getCo() {
        return co;
    }

    public void setCo(int co) {
        this.co = co;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    public List<ForecastDay> getForecastDayList() {
        return forecastDayList;
    }

    public void setForecastDayList(List<ForecastDay> forecastDayList) {
        this.forecastDayList = forecastDayList;
    }

    public List<ForecastHour> getForecastHourList() {
        return forecastHourList;
    }

    public void setForecastHourList(List<ForecastHour> forecastHourList) {
        this.forecastHourList = forecastHourList;
    }
}
