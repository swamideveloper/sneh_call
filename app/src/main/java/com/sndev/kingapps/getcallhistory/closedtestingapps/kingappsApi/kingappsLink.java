package com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsApi;

import static com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsActivity.kingappsSplash.key_Qureka;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;

import androidx.browser.customtabs.CustomTabsIntent;

import com.sndev.kingapps.getcallhistory.closedtestingapps.R;

public class kingappsLink {

    public static void openChromeCustomTabUrl(final Context context, String webUrl) {

        if (key_Qureka.equalsIgnoreCase("on")) {
            try {
                if (isAppInstalled(context, "com.android.chrome")) {
                    CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                    int coolorInt = Color.parseColor("#4080FF");
                    builder.setToolbarColor(coolorInt);
                    builder.setStartAnimations(context, R.anim.sdk_slide_in_right, R.anim.sdk_slide_out_left);
                    builder.setExitAnimations(context, R.anim.sdk_slide_in_left, R.anim.sdk_slide_out_right);
                    CustomTabsIntent customTabsIntent = builder.build();
                    customTabsIntent.intent.setPackage("com.android.chrome");
                    customTabsIntent.intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    customTabsIntent.launchUrl(context, Uri.parse(webUrl));
                } else {
                    CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                    int coolorInt = Color.parseColor("#4080FF");
                    builder.setToolbarColor(coolorInt);
                    builder.setStartAnimations(context, R.anim.sdk_slide_in_right, R.anim.sdk_slide_out_left);
                    builder.setExitAnimations(context, R.anim.sdk_slide_in_left, R.anim.sdk_slide_out_right);
                    CustomTabsIntent customTabsIntent = builder.build();
                    customTabsIntent.intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    customTabsIntent.launchUrl(context, Uri.parse(webUrl));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }


    public static boolean isAppInstalled(Context context, String packageName) {
        try {
            context.getPackageManager().getApplicationInfo(packageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
