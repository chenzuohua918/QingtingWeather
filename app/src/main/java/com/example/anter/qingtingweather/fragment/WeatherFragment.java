package com.example.anter.qingtingweather.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anter.qingtingweather.R;
import com.example.anter.qingtingweather.adapter.WeatherInfoAdapter;

public class WeatherFragment extends Fragment {
    private RecyclerView mRvWeather;
    private WeatherInfoAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_weather, container, false);
        initView(contentView);
        return contentView;
    }

    private void initView(View contentView) {
        mRvWeather = contentView.findViewById(R.id.recycler_weather);
        mRvWeather.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL);
        itemDecoration.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.shape_weather_divider));
        mRvWeather.addItemDecoration(itemDecoration);
        mAdapter = new WeatherInfoAdapter(getActivity());
        mRvWeather.setAdapter(mAdapter);
    }
}
