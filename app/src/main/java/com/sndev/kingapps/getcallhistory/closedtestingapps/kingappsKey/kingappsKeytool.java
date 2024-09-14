package com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsKey;

import android.content.Context;
import android.content.SharedPreferences;

public class kingappsKeytool {
    public SharedPreferences a;

    public kingappsKeytool(Context context) {
        this.a = context.getSharedPreferences("ads_sdk", 0);
    }

    public String I() {
        return this.a.getString("mc", "");
    }

}