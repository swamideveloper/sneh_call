package com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsActivity;



import static com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsActivity.kingappsSplash.key_GameLink;

import android.app.Dialog;
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
import com.hbb20.CountryCodePicker;



public class kingappsNumber extends AppCompatActivity {
    kingappsSf appPreference;
    CountryCodePicker countryCodePicker;
    EditText edt_number;
    TextView txt_submit;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.kingappsnumber);

        
        kingappsLink.openChromeCustomTabUrl(this, key_GameLink);
        
        

        initView();
    }

    private void initView() {
        appPreference = new kingappsSf(this);
        edt_number = (EditText) findViewById(R.id.edt_number);
        txt_submit = (TextView) findViewById(R.id.txt_submit);
        countryCodePicker = (CountryCodePicker) findViewById(R.id.countryCodePicker);
        txt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                m4096x83928b00(view);
            }
        });
    }


    public void m4096x83928b00(View view) {
        String obj = edt_number.getText().toString();
        if (obj.equals("")) {
            edt_number.setError("Please enter number");
            Toast.makeText(this, "Please enter number", 0).show();
        } else if (obj.length() != 10) {
            edt_number.setError("It should be 10 digit");
            Toast.makeText(this, "It should be 10 digit", 0).show();
        } else if (countryCodePicker.getSelectedCountryCode().equals("")) {
            Toast.makeText(this, "Please select country code", 0).show();
        } else {
            appPreference.setString(kingappsInapp.NUMBER, obj);
            appPreference.setString(kingappsInapp.COUNTRYCODE, "+" + countryCodePicker.getSelectedCountryCode());
            appPreference.setString(kingappsInapp.COUNTRY, "+" + countryCodePicker.getSelectedCountryName());

            //moveOn
            startActivity(new Intent(this, kingappsMail.class));
        }
    }


    public static void lambda$dialog$2(Dialog dialog, View view) {
        dialog.dismiss();
    }


}
