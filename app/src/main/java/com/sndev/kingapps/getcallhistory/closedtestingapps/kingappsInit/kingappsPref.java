package com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsInit;

import android.content.Context;
import android.content.SharedPreferences;

public class kingappsPref {
    public static String KEY_PREMIUM_USER = "key_premium_user";
    static SharedPreferences.Editor myEdit;
    static SharedPreferences sharedPreferences;


    public static void initializingSharedPreference(Context context) {
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("MySharedPref123", 0);
        sharedPreferences = sharedPreferences2;
        myEdit = sharedPreferences2.edit();
    }

    public static boolean isPremiumUser() {
        return sharedPreferences.getBoolean(KEY_PREMIUM_USER, false);
    }

    public static void setPremiumUser(boolean value) {
        sharedPreferences.edit().putBoolean(KEY_PREMIUM_USER, value).apply();
    }
}
