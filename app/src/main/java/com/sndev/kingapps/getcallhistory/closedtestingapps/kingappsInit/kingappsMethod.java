package com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsInit;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import android.webkit.WebView;

public class kingappsMethod extends Application {
    private static Context context = null;
    private static kingappsMethod instance_app_data = null;


    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();
        instance_app_data = this;

        if (Build.VERSION.SDK_INT >= 24) {
            try {
                StrictMode.class.getMethod("disableDeathOnFileUriExposure", new Class[0]).invoke((Object) null, new Object[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            if (!getPackageName().equals(Application.getProcessName())) {
                WebView.setDataDirectorySuffix(Application.getProcessName());
            }
        }

        kingappsPref.initializingSharedPreference(context);
    }


}