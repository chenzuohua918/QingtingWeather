package com.example.anter.qingtingweather.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.anter.qingtingweather.R;
import com.example.anter.qingtingweather.adapter.MainPagerAdapter;
import com.example.anter.qingtingweather.dao.CityCodeDBManager;
import com.example.anter.qingtingweather.fragment.WeatherFragment;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private ViewPager mViewPager;
    private MainPagerAdapter mPagerAdapter;
    private List<WeatherFragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 透明状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            try {
                Class decorViewClazz = Class.forName("com.android.internal.policy.DecorView");
                Field field = decorViewClazz.getDeclaredField("mSemiTransparentStatusBarColor");
                field.setAccessible(true);
                field.setInt(getWindow().getDecorView(), Color.TRANSPARENT);// 改为透明
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.viewPager);
        WeatherFragment fragment = new WeatherFragment();
        Bundle bundle = new Bundle();
        bundle.putString("cityCode", CityCodeDBManager.getInstance().queryCityCode("北京"));
        fragment.setArguments(bundle);
        mFragments.add(fragment);

        WeatherFragment fragment1 = new WeatherFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putString("cityCode", CityCodeDBManager.getInstance().queryCityCode("宝安"));
        fragment1.setArguments(bundle1);
        mFragments.add(fragment1);

        WeatherFragment fragment2 = new WeatherFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString("cityCode", CityCodeDBManager.getInstance().queryCityCode("井冈山"));
        fragment2.setArguments(bundle2);
        mFragments.add(fragment2);

        mPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mPagerAdapter);
    }

    public void addCity(View view) {
        startActivity(new Intent(this, AddCityActivity.class));
    }
}
