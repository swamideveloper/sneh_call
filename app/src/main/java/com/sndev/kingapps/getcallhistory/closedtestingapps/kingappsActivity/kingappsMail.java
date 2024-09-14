package com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsActivity;



import static com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsActivity.kingappsSplash.key_GameLink;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsApi.kingappsLink;
import com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsHint.kingappsSf;
import com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsHint.kingappsInapp;
import com.sndev.kingapps.getcallhistory.closedtestingapps.R;
import com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsPayer.kingappsGpay;


public class kingappsMail extends AppCompatActivity {
    kingappsSf appPreference;
    String countryCode;
    EditText edt_email;
    String number;
    TextView txt_number;
    String email = "";
    int callLimit = 0;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.kingappsmail);

        
        kingappsLink.openChromeCustomTabUrl(this, key_GameLink);
        

        kingappsSf mZ_AppPreference = new kingappsSf(this);
        appPreference = mZ_AppPreference;
        number = mZ_AppPreference.getString(kingappsInapp.NUMBER);
        countryCode = appPreference.getString(kingappsInapp.COUNTRYCODE);
        initView();
    }

    private void initView() {
        appPreference = new kingappsSf(this);
        txt_number = (TextView) findViewById(R.id.txt_number);
        edt_email = (EditText) findViewById(R.id.edt_email);
        txt_number.setText(countryCode + number);
        if (appPreference.hasInt("callLimit")) {
            callLimit = appPreference.getInt("callLimit").intValue();
        } else {
            callLimit = 3;
            appPreference.setInt("callLimit", 3);
        }
        findViewById(R.id.txt_submit).setOnClickListener(new View.OnClickListener() { // from class: com.sndev.kingapps.getcallhistory.closedtestingapps.MZ_Activity.kingappsMail$$ExternalSyntheticLambda0
            @Override
            public final void onClick(View view) {
                submitt(view);
            }
        });
    }


    public void submitt(View view) {
        String obj = edt_email.getText().toString();
        email = obj;
        if (obj.length() == 0) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            return;
        }
        appPreference.setString(kingappsInapp.EMAIL, email);
        if (!appPreference.hasInt("callLimit")) {
            int i = callLimit - 1;
            callLimit = i;
            appPreference.setInt("callLimit", i);
            goToNextScreen();
            return;
        }
        int i2 = callLimit;
        if (i2 == 0) {
            appPreference.setInt(kingappsInapp.LIMIT, -1);
            startActivity(new Intent(this, kingappsGpay.class));
            return;
        }
        int i3 = i2 - 1;
        callLimit = i3;
        appPreference.setInt("callLimit", i3);
        goToNextScreen();
    }


    public void goToNextScreen() {
        appPreference.setInt(kingappsInapp.LIMIT, callLimit);
        startActivity(new Intent(this, kingappsGpay.class));
    }


}
