package com.example.anter.qingtingweather.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.anter.qingtingweather.R;
import com.example.anter.qingtingweather.base.BaseToolbarActivity;

public class ChooseCityActivity extends BaseToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_city);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
