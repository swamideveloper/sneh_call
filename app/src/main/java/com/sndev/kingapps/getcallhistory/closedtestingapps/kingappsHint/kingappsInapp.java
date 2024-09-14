package com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsHint;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsPojo.kingappsNums;

import java.util.ArrayList;


public class kingappsInapp {
    public static String COUNTRY = "country";
    public static String COUNTRYCODE = "countrycode";
    public static String EMAIL = "email";
    public static String LIMIT = "limit";
    public static String NUMBER = "number";
    public static String PACKAGE = "package";
    public static String isPurchased = "isPurchased";
    public static String truecallerAPI = "https://app-backend-qrpg.onrender.com/v1/informations?";

    public static void log(String str, String str2) {
        Log.d(str + ":", str2 + " : ");
    }

    public static boolean isOnline(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static ArrayList<kingappsNums> getData() {
        ArrayList<kingappsNums> arrayList = new ArrayList<>();
        arrayList.add(new kingappsNums("Call History", "722458****", "15min ago"));
        arrayList.add(new kingappsNums("Whatsapp History", "859677****", "2min ago"));
        arrayList.add(new kingappsNums("SMS History", "955421****", "10min ago"));
        arrayList.add(new kingappsNums("Call History", "611119****", "1hour ago"));
        arrayList.add(new kingappsNums("Whatsapp History", "900006****", "30 min ago"));
        arrayList.add(new kingappsNums("SMS History", "85586****", "25min ago"));
        return arrayList;
    }
}
