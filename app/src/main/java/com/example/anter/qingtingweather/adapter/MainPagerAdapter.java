package com.example.anter.qingtingweather.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.anter.qingtingweather.fragment.WeatherFragment;

import java.util.List;

public class MainPagerAdapter extends FragmentPagerAdapter {
    private List<WeatherFragment> fragments;

    public MainPagerAdapter(FragmentManager fm, List<WeatherFragment> list) {
        super(fm);
        this.fragments = list;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.size();
    }
}
