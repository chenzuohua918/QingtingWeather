package com.example.anter.qingtingweather.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.anter.qingtingweather.R;
import com.example.anter.qingtingweather.utils.SharePreferenceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CityCodeDBManager {
    private static CityCodeDBManager instance;
    private String mCityDBPath;
    private SQLiteDatabase mDatabase;

    private static final String DB_NAME = "city.db";
    private static final String TABLE_NAME = "city_code";

    private static final String ROW_ID = "rowid";
    private static final String PROVINCE = "province";// 省
    private static final String DISTRICTCN = "districtcn";// 区域
    private static final String NAMECN = "namecn";// 区县
    private static final String CITY_CODE = "city_code";// 城市编码

    private CityCodeDBManager(Context context) {
        Context application = context.getApplicationContext();
        if (!SharePreferenceUtils.getBoolean(application, "copySuccess", false)) {
            writeCityDB(application, DB_NAME);
        }
        mDatabase = application.openOrCreateDatabase(mCityDBPath, Context.MODE_PRIVATE, null);
    }

    public static CityCodeDBManager getInstance(Context context) {
        if (null == instance) {
            synchronized (CityCodeDBManager.class) {
                if (null == instance) {
                    instance = new CityCodeDBManager(context);
                }
            }
        }
        return instance;
    }

    private void writeCityDB(Context context, String dbName) {
        mCityDBPath = context.getFilesDir() + "\\databases\\" + dbName;// 此处如果是放在应用包名的目录下,自动放入“databases目录下
        FileOutputStream fos = null;
        InputStream inputStream = null;
        try {
            inputStream = context.getResources().openRawResource(R.raw.city);
            fos = new FileOutputStream(new File(mCityDBPath));
            byte[] buffer = new byte[128];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            SharePreferenceUtils.putBoolean(context, "copySuccess", true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String queryCityCode(String namecn) {
        Cursor cursor = mDatabase.query(TABLE_NAME, new String[]{CITY_CODE}, NAMECN + " = ?", new String[]{namecn}, null, null, null);
        String cityCode = null;
        if (null != cursor) {
            while (cursor.moveToNext()) {
                cityCode = cursor.getString(cursor.getColumnIndex(CITY_CODE));
                break;
            }
            cursor.close();
        }
        return cityCode;
    }

    public List<String> queryProvinces() {
        Cursor cursor = mDatabase.query(TABLE_NAME, new String[]{PROVINCE}, null, null, PROVINCE, null, ROW_ID);
        if (null != cursor) {
            List<String> list = new ArrayList<>();
            while (cursor.moveToNext()) {
                list.add(cursor.getString(cursor.getColumnIndex(PROVINCE)));
            }
            cursor.close();
            return list;
        }
        return null;
    }

    public List<String> queryDistricts(String province) {
        Cursor cursor = mDatabase.query(TABLE_NAME, new String[]{DISTRICTCN}, PROVINCE + " = ?", new String[]{province}, DISTRICTCN, null, ROW_ID);
        if (null != cursor) {
            List<String> list = new ArrayList<>();
            while (cursor.moveToNext()) {
                list.add(cursor.getString(cursor.getColumnIndex(DISTRICTCN)));
            }
            cursor.close();
            return list;
        }
        return null;
    }

    public List<String> queryCountries(String province, String district) {
        Cursor cursor = mDatabase.query(TABLE_NAME, new String[]{NAMECN}, PROVINCE + " = ? and " + DISTRICTCN + " = ?", new String[]{province, district}, null, null, null);
        if (null != cursor) {
            List<String> list = new ArrayList<>();
            while (cursor.moveToNext()) {
                list.add(cursor.getString(cursor.getColumnIndex(NAMECN)));
            }
            cursor.close();
            return list;
        }
        return null;
    }
}
