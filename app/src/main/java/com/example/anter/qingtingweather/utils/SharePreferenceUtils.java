package com.example.anter.qingtingweather.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePreferenceUtils {
    private static String sp_name = "weather";

    private static SharedPreferences getSP(Context context) {
        return context.getSharedPreferences(sp_name, Context.MODE_PRIVATE);
    }

    public static boolean getBoolean(Context context, String key, boolean def) {
        return getSP(context).getBoolean(key, def);
    }

    public static void putBoolean(Context context, String key, boolean value) {
        getSP(context).edit().putBoolean(key, value);
    }
}
