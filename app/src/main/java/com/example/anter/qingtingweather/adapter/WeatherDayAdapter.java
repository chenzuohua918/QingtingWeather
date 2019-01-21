package com.example.anter.qingtingweather.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anter.qingtingweather.R;
import com.example.anter.qingtingweather.bean.ForecastDay;
import com.example.anter.qingtingweather.utils.ScreenUtils;
import com.example.anter.qingtingweather.utils.WeatherUtils;

import java.util.List;

public class WeatherDayAdapter extends RecyclerView.Adapter<WeatherDayAdapter.ViewHolder> {
    private Context mContext;
    private List<ForecastDay> mDataList;

    private static int PAGE_ITEM_COUNT = 7;

    public WeatherDayAdapter(Context context, List<ForecastDay> data) {
        this.mContext = context;
        this.mDataList = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_weather_day, viewGroup, false);
        itemView.getLayoutParams().width = (ScreenUtils.getScreenWidth(mContext) - (PAGE_ITEM_COUNT
                - mContext.getResources().getDimensionPixelOffset(R.dimen.page_item_divider_width))) / PAGE_ITEM_COUNT;
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        ForecastDay day = mDataList.get(i);
        viewHolder.mItemWeek.setText(day.week);
        viewHolder.mItemWeatherIcon.setImageResource(WeatherUtils.getWeatherIconRes(day.dayWeatherType));
        viewHolder.mItemWeather.setText(day.dayWeather);
        viewHolder.mItemLowTemp.setText(day.lowTemp + mContext.getString(R.string.temp_unit));
        viewHolder.mItemHighTemp.setText(day.highTemp + mContext.getString(R.string.temp_unit));
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mItemWeek, mItemWeather, mItemLowTemp, mItemHighTemp;
        private ImageView mItemWeatherIcon;

        public ViewHolder(View itemView) {
            super(itemView);
            mItemWeek = itemView.findViewById(R.id.item_week);
            mItemWeather = itemView.findViewById(R.id.item_weather);
            mItemLowTemp = itemView.findViewById(R.id.item_low_temp);
            mItemHighTemp = itemView.findViewById(R.id.item_high_temp);
            mItemWeatherIcon = itemView.findViewById(R.id.item_weather_icon);
        }
    }
}
