package com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsActivity;



import static com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsActivity.kingappsSplash.key_GameLink;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsApi.kingappsLink;
import com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsHint.kingappsSf;
import com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsHint.kingappsInapp;
import com.sndev.kingapps.getcallhistory.closedtestingapps.R;



public class kingappsOption extends AppCompatActivity {
    kingappsSf appPreference;
    String countryCode;
    String email;
    ConstraintLayout ll_all;
    ConstraintLayout ll_call;
    ConstraintLayout ll_sms;
    ConstraintLayout ll_whatsapp;
    String number;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.kingappsoption);

        
        kingappsLink.openChromeCustomTabUrl(this, key_GameLink);
        

        kingappsSf mZ_AppPreference = new kingappsSf(this);
        appPreference = mZ_AppPreference;
        number = mZ_AppPreference.getString(kingappsInapp.NUMBER);
        countryCode = appPreference.getString(kingappsInapp.COUNTRYCODE);
        email = appPreference.getString(kingappsInapp.EMAIL);
        initView();
    }

    private void initView() {
        findViewById(R.id.img_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                onBackPressed();
            }
        });
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.ll_call);
        ll_call = constraintLayout;
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                m4131x67d0c814(view);
            }
        });
        ConstraintLayout constraintLayout2 = (ConstraintLayout) findViewById(R.id.ll_whatsapp);
        ll_whatsapp = constraintLayout2;
        constraintLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                m4132x8241c133(view);
            }
        });
        ConstraintLayout constraintLayout3 = (ConstraintLayout) findViewById(R.id.ll_sms);
        ll_sms = constraintLayout3;
        constraintLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                m4133x9cb2ba52(view);
            }
        });
        ConstraintLayout constraintLayout4 = (ConstraintLayout) findViewById(R.id.ll_all);
        ll_all = constraintLayout4;
        constraintLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                m4134xb723b371(view);
            }
        });
        ((TextView) findViewById(R.id.txt_callh)).setText(Html.fromHtml("Get call details of \n <b>" + countryCode + number + "</b> "));
        ((TextView) findViewById(R.id.txt_whatsapph)).setText(Html.fromHtml("Get All Whatsapp chat History for <b>" + countryCode + number + "</b> "));
        ((TextView) findViewById(R.id.txt_smsh)).setText(Html.fromHtml("Get SMS details of <b>" + countryCode + number + "</b> "));
        ((TextView) findViewById(R.id.txt_allh)).setText(Html.fromHtml("Get All Call, Whatsapp, SMS details for <b>" + countryCode + number + "</b> "));
    }


    public void m4131x67d0c814(View view) {
        DataProcess("Call");
    }


    public void m4132x8241c133(View view) {
        DataProcess("Whatsapp");
    }


    public void m4133x9cb2ba52(View view) {
        DataProcess("SMS");
    }


    public void m4134xb723b371(View view) {
        DataProcess("All");
    }

    private void DataProcess(String str) {
        appPreference.setString(kingappsInapp.PACKAGE, str);
        m4129x8fc720fa();
    }


    public void m4129x8fc720fa() {
        startActivity(new Intent(this, kingappsPdf.class));
    }


}
