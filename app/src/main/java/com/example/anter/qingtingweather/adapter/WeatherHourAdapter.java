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
import com.example.anter.qingtingweather.bean.ForecastHour;
import com.example.anter.qingtingweather.utils.ScreenUtils;
import com.example.anter.qingtingweather.utils.WeatherUtils;

import java.util.List;

public class WeatherHourAdapter extends RecyclerView.Adapter<WeatherHourAdapter.ViewHolder> {
    private Context mContext;
    private List<ForecastHour> mDataList;

    private static int PAGE_ITEM_COUNT = 7;

    public WeatherHourAdapter(Context context, List<ForecastHour> data) {
        this.mContext = context;
        this.mDataList = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_weather_hour, viewGroup, false);
        itemView.getLayoutParams().width = (ScreenUtils.getScreenWidth(mContext) - (PAGE_ITEM_COUNT
                - mContext.getResources().getDimensionPixelOffset(R.dimen.page_item_divider_width))) / PAGE_ITEM_COUNT;
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        ForecastHour hour = mDataList.get(position);
        viewHolder.mItemTime.setText(hour.time);
        viewHolder.mItemWeatherIcon.setImageResource(WeatherUtils.getWeatherIconRes(hour.weatherType));
        viewHolder.mItemWeather.setText(hour.weather);
        viewHolder.mItemTemp.setText(hour.temp + mContext.getString(R.string.temp_unit));
        viewHolder.mItemShidu.setText(hour.shidu);
        viewHolder.mItemWindDirection.setText(hour.windDirection);
        viewHolder.mItemWindSpeed.setText(hour.windSpeed);
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
        private TextView mItemTime, mItemWeather, mItemTemp, mItemShidu, mItemWindDirection, mItemWindSpeed;
        private ImageView mItemWeatherIcon;

        public ViewHolder(View itemView) {
            super(itemView);
            mItemTime = itemView.findViewById(R.id.item_time);
            mItemWeather = itemView.findViewById(R.id.item_weather);
            mItemTemp = itemView.findViewById(R.id.item_temp);
            mItemShidu = itemView.findViewById(R.id.item_shidu);
            mItemWindDirection = itemView.findViewById(R.id.item_wind_direction);
            mItemWindSpeed = itemView.findViewById(R.id.item_wind_speed);
            mItemWeatherIcon = itemView.findViewById(R.id.item_weather_icon);
        }
    }
}
