package com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsHome;



import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsActivity.kingappsNumber;
import com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsActivity.kingappsPrivacy;
import com.sndev.kingapps.getcallhistory.closedtestingapps.R;


public class kingappsHome extends AppCompatActivity {
    ConstraintLayout btnNext;
    ImageView btnPolicy;
    ImageView btnRate;
    ImageView btnShare;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.kingappshome);
        
        this.btnNext = (ConstraintLayout) findViewById(R.id.btnNext);
        this.btnShare = (ImageView) findViewById(R.id.btnShare);
        this.btnRate = (ImageView) findViewById(R.id.btnRate);
        this.btnPolicy = (ImageView) findViewById(R.id.btnPolicy);

        this.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), kingappsNumber.class));
            }
        });
        this.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                shareApp();
            }
        });
        this.btnRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                rateApp();
            }
        });
        this.btnPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), kingappsPrivacy.class));
            }
        });
    }


    private void shareApp() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", "Check out this app: https://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName());
        intent.setType("text/plain");
        startActivity(Intent.createChooser(intent, "Share via"));
    }

    private void rateApp() {
        String packageName = getApplicationContext().getPackageName();
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName)));
        } catch (ActivityNotFoundException unused) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + packageName)));
        }
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

}
