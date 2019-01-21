package com.example.anter.qingtingweather.model;

import android.content.Context;
import android.text.TextUtils;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.anter.qingtingweather.bean.ForecastDay;
import com.example.anter.qingtingweather.bean.ForecastHour;
import com.example.anter.qingtingweather.bean.WeatherBean;
import com.example.anter.qingtingweather.listener.OnGetWeatherDataListener;
import com.example.anter.qingtingweather.utils.DateTimeUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeatherDataModel {
    private Context mContext;

    public WeatherDataModel(Context context) {
        this.mContext = context;
    }

    public void getWeatherData(String cityCode, final OnGetWeatherDataListener listener) {
        if (!TextUtils.isEmpty(cityCode)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String date = sdf.format(new Date());
            StringRequest request = new StringRequest("http://zhwnlapi.etouch.cn/Ecalender/api/v2/weather?date=" + date + "&citykey=" + cityCode, new Response.Listener<String>() {
                @Override
                public void onResponse(String s) {
                    WeatherBean bean = parseJsonResult(s);
                    if (listener != null) {
                        if (bean != null) {
                            listener.onSuccess(bean);
                        } else {
                            listener.onError();
                        }
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    if (listener != null) {
                        listener.onError();
                    }
                }
            });
            Volley.newRequestQueue(mContext).add(request);
        }
    }

    private WeatherBean parseJsonResult(String result) {
        try {
            WeatherBean bean = new WeatherBean();
            JSONObject root = new JSONObject(result);
            JSONObject meta = root.getJSONObject("meta");
            bean.setCity(meta.getString("city"));
            bean.setUpper(meta.getString("upper"));
            bean.setCityCode(meta.getString("citykey"));
            bean.setUpdateTime(meta.getString("up_time"));

            JSONObject observe = root.getJSONObject("observe");
            bean.setShidu(observe.getString("shidu"));
            bean.setWeather(observe.getString("wthr"));
            bean.setWeatherType(observe.getInt("type"));
            bean.setTemp(observe.getInt("temp"));
            bean.setWindSpeed(observe.getString("wp"));
            bean.setWindDirection(observe.getString("wd"));
            bean.setTiganTemp(observe.getInt("tigan"));

            JSONObject evn = root.getJSONObject("evn");
            bean.setNo2(evn.getInt("no2"));
            bean.setPm25(evn.getInt("pm25"));
            bean.setO3(evn.getInt("o3"));
            bean.setSo2(evn.getInt("so2"));
            bean.setPm10(evn.getInt("pm10"));
            bean.setCo(evn.getInt("co"));
            bean.setQuality(evn.getString("quality"));
            bean.setSuggest(evn.getString("suggest"));

            JSONArray forecast15 = root.getJSONArray("forecast15");
            List<ForecastDay> forecastDays = new ArrayList<>();
            JSONObject itemObject;
            ForecastDay day;
            String date;
            JSONObject nightObject, dayObject;
            for (int i = 0, size = forecast15.length(); i < size; i++) {
                itemObject = forecast15.getJSONObject(i);
                day = new ForecastDay();
                date = itemObject.getString("date");
                day.setDate(date);
                day.setWeek(DateTimeUtils.dateToWeek(mContext, date));
                day.setSunrise(itemObject.getString("sunrise"));
                day.setSunset(itemObject.getString("sunset"));
                day.setLowTemp(itemObject.getInt("low"));
                day.setHighTemp(itemObject.getInt("high"));

                nightObject = itemObject.getJSONObject("night");
                day.setNightWeather(nightObject.getString("wthr"));
                day.setNightWeatherType(nightObject.getInt("type"));
                day.setNightWindSpeed(nightObject.getString("wp"));
                day.setNightWindDirection(nightObject.getString("wd"));
                day.setNightBgPicUrl(nightObject.getString("bgPic"));
                day.setNightSmPicUrl(nightObject.getString("smPic"));

                dayObject = itemObject.getJSONObject("day");
                day.setDayWeather(dayObject.getString("wthr"));
                day.setDayWeatherType(dayObject.getInt("type"));
                day.setDayWindSpeed(dayObject.getString("wp"));
                day.setDayWindDirection(dayObject.getString("wd"));
                day.setDayBgPicUrl(dayObject.getString("bgPic"));
                day.setDaySmPicUrl(dayObject.getString("smPic"));

                forecastDays.add(day);
            }
            bean.setForecastDayList(forecastDays);

            JSONArray hourfc = root.getJSONArray("hourfc");
            List<ForecastHour> forecastHours = new ArrayList<>();
            ForecastHour hour;
            String time;
            for (int i = 0, size = hourfc.length(); i < size; i++) {
                itemObject = hourfc.getJSONObject(i);
                hour = new ForecastHour();
                time = itemObject.getString("time");
                hour.setTime(DateTimeUtils.formatTime(time));
                hour.setWeather(itemObject.getString("type_desc"));
                hour.setWeatherType(itemObject.getInt("type"));
                hour.setTemp(itemObject.getInt("wthr"));
                hour.setShidu(itemObject.getString("shidu"));
                hour.setWindSpeed(itemObject.getString("wp"));
                hour.setWindDirection(itemObject.getString("wd"));

                forecastHours.add(hour);
            }
            bean.setForecastHourList(forecastHours);
            return bean;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
