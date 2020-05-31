package com.example.anter.qingtingweather.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.anter.qingtingweather.R;
import com.example.anter.qingtingweather.adapter.ChooseCityAdapter;
import com.example.anter.qingtingweather.base.BaseToolbarActivity;
import com.example.anter.qingtingweather.dao.CityCodeDBManager;

import java.util.List;

public class ChooseCityActivity extends BaseToolbarActivity {
    private RecyclerView mRvProvince, mRvDistrict, mRvCountry;
    private ChooseCityAdapter mProvinceAdapter, mDistrictAdapter, mCountryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_city);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initView();
    }

    private void initView() {
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(ContextCompat.getDrawable(this, R.drawable.choose_city_divider));

        mRvProvince = findViewById(R.id.rv_province);
        mRvProvince.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRvProvince.addItemDecoration(itemDecoration);

        mRvDistrict = findViewById(R.id.rv_district);
        mRvDistrict.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRvDistrict.addItemDecoration(itemDecoration);

        mRvCountry = findViewById(R.id.rv_country);
        mRvCountry.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRvCountry.addItemDecoration(itemDecoration);

        updateProvinceList();
        updateDistrictList("北京");
        updateCountryList("北京", "北京");
    }

    private void updateProvinceList() {
        new AsyncTask<Void, Void, List<String>>() {
            @Override
            protected List<String> doInBackground(Void... voids) {
                return CityCodeDBManager.getInstance(getApplicationContext()).queryProvinces();
            }

            @Override
            protected void onPostExecute(List<String> strings) {
                super.onPostExecute(strings);
                if (mProvinceAdapter == null) {
                    mProvinceAdapter = new ChooseCityAdapter(ChooseCityActivity.this, strings);
                    mRvProvince.setAdapter(mProvinceAdapter);
                } else {
                    mProvinceAdapter.setData(strings);
                }
            }
        }.execute();
    }

    private void updateDistrictList(final String province) {
        new AsyncTask<Void, Void, List<String>>() {
            @Override
            protected List<String> doInBackground(Void... sVoid) {
                return CityCodeDBManager.getInstance(getApplicationContext()).queryDistricts(province);
            }

            @Override
            protected void onPostExecute(List<String> strings) {
                super.onPostExecute(strings);
                if (mDistrictAdapter == null) {
                    mDistrictAdapter = new ChooseCityAdapter(ChooseCityActivity.this, strings);
                    mRvDistrict.setAdapter(mDistrictAdapter);
                } else {
                    mDistrictAdapter.setData(strings);
                }
            }
        }.execute();
    }

    private void updateCountryList(final String province, final String district) {
        new AsyncTask<Void, Void, List<String>>() {
            @Override
            protected List<String> doInBackground(Void... sVoid) {
                return CityCodeDBManager.getInstance(getApplicationContext()).queryCountries(province, district);
            }

            @Override
            protected void onPostExecute(List<String> strings) {
                super.onPostExecute(strings);
                if (mCountryAdapter == null) {
                    mCountryAdapter = new ChooseCityAdapter(ChooseCityActivity.this, strings);
                    mRvCountry.setAdapter(mCountryAdapter);
                } else {
                    mCountryAdapter.setData(strings);
                }
            }
        }.execute();
    }
}
