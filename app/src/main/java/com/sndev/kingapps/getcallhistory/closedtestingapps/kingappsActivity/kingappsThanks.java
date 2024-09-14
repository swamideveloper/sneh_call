package com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsActivity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsHint.kingappsSf;
import com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsHint.kingappsInapp;
import com.sndev.kingapps.getcallhistory.closedtestingapps.R;


public class kingappsThanks extends AppCompatActivity {
    kingappsSf appPreference;
    String countryCode;
    String email;
    String number;
    String packages;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.kingappsthanks);

        kingappsSf mZ_AppPreference = new kingappsSf(this);
        this.appPreference = mZ_AppPreference;
        this.packages = mZ_AppPreference.getString(kingappsInapp.PACKAGE);
        this.number = this.appPreference.getString(kingappsInapp.NUMBER);
        this.countryCode = this.appPreference.getString(kingappsInapp.COUNTRYCODE);
        this.email = this.appPreference.getString(kingappsInapp.EMAIL);
        ((TextView) findViewById(R.id.txtGenerateText)).setText("All History of " + this.countryCode + this.number + " \n Generated!!");
    }

}
