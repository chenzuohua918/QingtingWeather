package com.example.anter.qingtingweather.listener;

import com.example.anter.qingtingweather.bean.WeatherBean;

public interface OnGetWeatherDataListener {
    void onSuccess(WeatherBean bean);

    void onError();
}
