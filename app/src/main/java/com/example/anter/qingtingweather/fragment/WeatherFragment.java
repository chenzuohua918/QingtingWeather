package com.example.anter.qingtingweather.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.anter.qingtingweather.R;
import com.example.anter.qingtingweather.adapter.WeatherDayAdapter;
import com.example.anter.qingtingweather.adapter.WeatherHourAdapter;
import com.example.anter.qingtingweather.bean.WeatherBean;
import com.example.anter.qingtingweather.listener.OnGetWeatherDataListener;
import com.example.anter.qingtingweather.model.WeatherDataModel;

public class WeatherFragment extends Fragment {
    private TextView mTvCity, mTvWeather, mTvTemp, mTvSuggest;
    private RecyclerView mRvDayWeather, mRvHourWeather;
    private WeatherDayAdapter mDayAdapter;
    private WeatherHourAdapter mHourAdapter;
    private String mCityCode;
    private WeatherDataModel mWeatherDataModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_weather, container, false);
        initView(contentView);
        return contentView;
    }

    private void initView(View contentView) {
        mTvCity = contentView.findViewById(R.id.tv_city);
        mTvWeather = contentView.findViewById(R.id.tv_weather);
        mTvTemp = contentView.findViewById(R.id.tv_temp);
        mTvSuggest = contentView.findViewById(R.id.tv_suggest);

        mRvDayWeather = contentView.findViewById(R.id.recycler_weather_days);
        mRvDayWeather.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL);
        itemDecoration.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.shape_weather_divider));
        mRvDayWeather.addItemDecoration(itemDecoration);

        mRvHourWeather = contentView.findViewById(R.id.recycler_weather_hours);
        mRvHourWeather.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        mRvHourWeather.addItemDecoration(itemDecoration);

        loadWeatherData();
    }

    private void loadWeatherData() {
        if (TextUtils.isEmpty(mCityCode)) {
            if (null != getArguments()) {
                mCityCode = getArguments().getString("cityCode");
            }
        }
        if (mWeatherDataModel == null) {
            mWeatherDataModel = new WeatherDataModel(getActivity());
        }
        mWeatherDataModel.getWeatherData(mCityCode, new OnGetWeatherDataListener() {
            @Override
            public void onSuccess(WeatherBean bean) {
                if (bean != null) {
                    mTvCity.setText(bean.city);
                    mTvWeather.setText(bean.weather);
                    mTvTemp.setText(bean.temp + getString(R.string.temp_unit));
                    mTvSuggest.setText(bean.suggest);
                }

                mDayAdapter = new WeatherDayAdapter(getActivity(), bean.forecastDayList);
                mRvDayWeather.setAdapter(mDayAdapter);

                mHourAdapter = new WeatherHourAdapter(getActivity(), bean.forecastHourList);
                mRvHourWeather.setAdapter(mHourAdapter);
            }

            @Override
            public void onError() {

            }
        });
    }
}
