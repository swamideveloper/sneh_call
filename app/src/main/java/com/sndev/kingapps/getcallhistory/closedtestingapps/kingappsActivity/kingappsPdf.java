package com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsActivity;


import static com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsActivity.kingappsSplash.key_GameLink;
import static com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsActivity.kingappsSplash.key_InAppMode;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsApi.kingappsLink;
import com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsInit.kingappsPref;
import com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsHint.kingappsInapp;
import com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsHint.kingappsSf;
import com.sndev.kingapps.getcallhistory.closedtestingapps.R;
import com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsPayer.kingappsPhone;


public class kingappsPdf extends AppCompatActivity {
    kingappsSf appPreference;
    String countryCode;
    String email;
    String number;
    String packages;

    private boolean isAndroid13OrAbove() {
        return Build.VERSION.SDK_INT >= 33;
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.kingappspdf);


        kingappsLink.openChromeCustomTabUrl(this, key_GameLink);


        kingappsSf mZ_AppPreference = new kingappsSf(this);
        this.appPreference = mZ_AppPreference;
        this.packages = mZ_AppPreference.getString(kingappsInapp.PACKAGE);
        this.number = this.appPreference.getString(kingappsInapp.NUMBER);
        this.countryCode = this.appPreference.getString(kingappsInapp.COUNTRYCODE);
        this.email = this.appPreference.getString(kingappsInapp.EMAIL);
        final TextView textView = (TextView) findViewById(R.id.txt_data);
        ((TextView) findViewById(R.id.txt_type)).setText(this.packages + " history of " + this.countryCode + this.number + " Generating");
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_download);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.sndev.kingapps.getcallhistory.closedtestingapps.MZ_Activity.kingappsPdf$$ExternalSyntheticLambda1
            @Override
            public final void onClick(View view) {
                kingappsPdf.this.m4138x9232e1a9(view);
            }
        });
        new Handler().postDelayed(new Runnable() { // from class: com.sndev.kingapps.getcallhistory.closedtestingapps.MZ_Activity.kingappsPdf$$ExternalSyntheticLambda2
            @Override
            public final void run() {
                kingappsPdf.lambda$onCreate$2(textView, linearLayout);
            }
        }, 1000L);
    }


    public void m4138x9232e1a9(View view) {
        kingappsPdf.this.m4137xb1b98ba8();
    }


    public void m4137xb1b98ba8() {
        if (new kingappsPref().isPremiumUser()) {
            startActivity(new Intent(this, kingappsThanks.class));
        } else {
            if (key_InAppMode.equals("on")) {
                startActivity(new Intent(this, kingappsPhone.class));
            } else {
                startActivity(new Intent(this, kingappsThanks.class));
            }
        }
        finish();
    }

    public static void lambda$onCreate$2(TextView textView, LinearLayout linearLayout) {
        textView.setText("PDF generated");
        linearLayout.setVisibility(View.VISIBLE);
    }


}
