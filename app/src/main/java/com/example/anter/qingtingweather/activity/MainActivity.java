package com.example.anter.qingtingweather.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.example.anter.qingtingweather.R;
import com.example.anter.qingtingweather.adapter.MainPagerAdapter;
import com.example.anter.qingtingweather.base.BaseActivity;
import com.example.anter.qingtingweather.dao.CityCodeDBManager;
import com.example.anter.qingtingweather.fragment.WeatherFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private ViewPager mViewPager;
    private MainPagerAdapter mPagerAdapter;
    private List<WeatherFragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.viewPager);
        mFragments.add(new WeatherFragment());
        mFragments.add(new WeatherFragment());
        mFragments.add(new WeatherFragment());
        mPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mPagerAdapter);

        String s = CityCodeDBManager.getInstance().queryCityCode("井冈山");
        Toast.makeText(this, "code = " + s, Toast.LENGTH_SHORT).show();
    }
}
