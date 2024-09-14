package com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsPayer;



import static com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsActivity.kingappsSplash.key_GameLink;

import android.content.Intent;
import android.graphics.BlurMaskFilter;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.MaskFilterSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsActivity.kingappsOption;
import com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsApi.kingappsLink;
import com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsHint.kingappsSf;
import com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsHint.kingappsInapp;
import com.sndev.kingapps.getcallhistory.closedtestingapps.R;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class kingappsGpay extends AppCompatActivity {
    kingappsSf appPreference;
    String country;
    String countryCode;
    String email;
    int limit;
    LinearLayout ll_animation;
    LinearLayout ll_retry;
    String number;
    ScrollView sv_user_data;
    TextView textView_carrier;
    TextView textView_city;
    TextView textView_countrycode;
    TextView textView_email;
    TextView textView_gender;
    TextView textView_name;
    TextView textView_phone;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.kingappsdetails);

        
        kingappsLink.openChromeCustomTabUrl(this, key_GameLink);
        

        kingappsSf mZ_AppPreference = new kingappsSf(this);
        this.appPreference = mZ_AppPreference;
        this.number = mZ_AppPreference.getString(kingappsInapp.NUMBER);
        this.countryCode = this.appPreference.getString(kingappsInapp.COUNTRYCODE);
        this.country = this.appPreference.getString(kingappsInapp.COUNTRY);
        this.email = this.appPreference.getString(kingappsInapp.EMAIL);
        this.limit = this.appPreference.getInt(kingappsInapp.LIMIT).intValue();
        setLayout();
    }

    private void setLayout() {
        findViewById(R.id.img_back).setOnClickListener(new View.OnClickListener() { 
            @Override
            public final void onClick(View view) {
                m4147xadd5ebdf(view);
            }
        });
        findViewById(R.id.ll_download).setOnClickListener(new View.OnClickListener() { 
            @Override
            public final void onClick(View view) {
                m4148xc6d73d7e(view);
            }
        });
        this.ll_retry = (LinearLayout) findViewById(R.id.ll_retry);
        this.ll_animation = (LinearLayout) findViewById(R.id.ll_animation);
        this.sv_user_data = (ScrollView) findViewById(R.id.sv_user_data);
        this.textView_name = (TextView) findViewById(R.id.textView_name);
        this.textView_gender = (TextView) findViewById(R.id.textView_gender);
        this.textView_phone = (TextView) findViewById(R.id.textView_phone);
        this.textView_email = (TextView) findViewById(R.id.textView_email);
        this.textView_carrier = (TextView) findViewById(R.id.textView_carrier);
        this.textView_city = (TextView) findViewById(R.id.textView_city);
        this.textView_countrycode = (TextView) findViewById(R.id.textView_countrycode);
        this.ll_retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                m4149xdfd88f1d(view);
            }
        });
        if (this.limit < 0) {
            dummyData();
        } else {
            getUser();
        }
    }


    public void m4149xdfd88f1d(View view) {
        this.ll_retry.setVisibility(View.GONE);
        m4148xc6d73d7e(view);
    }


    public void m4148xc6d73d7e(View view) {
        m4144x3c9dd2d5();
    }


    public void m4144x3c9dd2d5() {
        startActivity(new Intent(this, kingappsOption.class));
        finish();
    }

    public void dummyData() {
        runOnUiThread(new Runnable() {
            @Override
            public final void run() {
                m4145x31164b55();
            }
        });
    }

    public void m4145x31164b55() {
        findViewById(R.id.animatiom).setVisibility(View.GONE);
        findViewById(R.id.ll_download).setVisibility(View.GONE);
        this.ll_animation.setVisibility(View.GONE);
        this.sv_user_data.setVisibility(View.VISIBLE);
        this.ll_retry.setVisibility(View.VISIBLE);
        this.textView_name.setText(getBlurString("David backam"));
        this.textView_email.setText(getBlurString("David@backam.com"));
        this.textView_city.setText(getBlurString("city"));
        this.textView_carrier.setText(getBlurString("Aircel"));
        this.textView_countrycode.setText(this.countryCode);
        this.textView_gender.setText(getBlurString("male"));
        this.textView_phone.setText(this.countryCode + this.number);
    }

    private void getUser() {
        new OkHttpClient().newCall(new Request.Builder().url(kingappsInapp.truecallerAPI + "countryCode=" + this.countryCode + "&phone=" + this.number).get().addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,/;q=0.8,application/signed-exchange;v=b3;q=0.9").addHeader("Accept-Language", "en-GB,en-US;q=0.9,en;q=0.8").addHeader("Cache-Control", "max-age=0").addHeader("Connection", "keep-alive").addHeader("If-None-Match", "W/\"207-aVT3AB9znwm/FMqinJ1v+y8rhIk\"").addHeader("Sec-Fetch-Dest", "document").addHeader("Sec-Fetch-Mode", "navigate").addHeader("Sec-Fetch-Site", "none").addHeader("Sec-Fetch-User", "?1").addHeader("Upgrade-Insecure-Requests", "1").addHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36").addHeader("sec-ch-ua", "\"Chromium\";v=\"104\", \" Not A;Brand\";v=\"99\", \"Google Chrome\";v=\"104\"").addHeader("sec-ch-ua-mobile", "?0").addHeader("sec-ch-ua-platform", "\"Linux\"").build()).enqueue(new AnonymousClass1());
    }

    public class AnonymousClass1 implements Callback {
        AnonymousClass1() {
        }


        public void m4150x196f3a0d() {
            dummyData();
        }

        @Override
        public void onFailure(Call call, IOException iOException) {
            runOnUiThread(new Runnable() {
                @Override 
                public final void run() {
                    AnonymousClass1.this.m4150x196f3a0d();
                }
            });
            call.cancel();
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            final String string = response.body().string();
            runOnUiThread(new Runnable() { 
                @Override 
                public void run() {
                    try {
                        JSONObject jSONObject = new JSONObject(string);
                        String string2 = jSONObject.has("name") ? jSONObject.getString("name") : "";
                        String string3 = jSONObject.has("email") ? jSONObject.getString("email") : "";
                        if (jSONObject.has("country")) {
                            jSONObject.getString("country");
                        }
                        String string4 = jSONObject.has("iSO3166-1Alpha-2Code") ? jSONObject.getString("iSO3166-1Alpha-2Code") : "";
                        String string5 = jSONObject.has("telephoneNumber") ? jSONObject.getString("telephoneNumber") : "";
                        String string6 = jSONObject.has("telecomProvider") ? jSONObject.getString("telecomProvider") : "";
                        if (jSONObject.has("networkType")) {
                            jSONObject.getString("networkType");
                        }
                        String string7 = jSONObject.has("timeZone") ? jSONObject.getString("timeZone") : "";
                        if (jSONObject.has("gender") && !jSONObject.getString("gender").equals("UNKNOWN")) {
                            String string8 = jSONObject.getString("gender");
                            if (jSONObject.has("image")) {
                                jSONObject.getString("image");
                            }
                            if (!isEmpty(string2)) {
                                findViewById(R.id.ll_name).setVisibility(View.GONE);
                            } else {
                                textView_name.setText(string2);
                            }
                            if (!isEmpty(string3)) {
                                findViewById(R.id.ll_email).setVisibility(View.GONE);
                            } else {
                                textView_email.setText(string3);
                            }
                            if (!isEmpty(string7)) {
                                findViewById(R.id.ll_city).setVisibility(View.GONE);
                            } else {
                                textView_city.setText(string7);
                            }
                            if (!isEmpty(string8)) {
                                findViewById(R.id.ll_gender).setVisibility(View.GONE);
                            } else {
                                textView_gender.setText(string8);
                            }
                            if (!isEmpty(string6)) {
                                findViewById(R.id.ll_carrier).setVisibility(View.GONE);
                            } else {
                                textView_carrier.setText(string6);
                            }
                            if (!isEmpty(string4)) {
                                findViewById(R.id.ll_countrycode).setVisibility(View.GONE);
                            } else {
                                textView_countrycode.setText(string4);
                            }
                            if (!isEmpty(string5)) {
                                findViewById(R.id.ll_phone).setVisibility(View.GONE);
                            } else {
                                textView_phone.setText(string5);
                            }
                            if (jSONObject.length() != 0) {
                                findViewById(R.id.imageView_user).setVisibility(View.VISIBLE);
                                findViewById(R.id.ll_name).setVisibility(View.VISIBLE);
                                findViewById(R.id.ll_email).setVisibility(View.VISIBLE);
                                findViewById(R.id.ll_city).setVisibility(View.VISIBLE);
                                findViewById(R.id.ll_carrier).setVisibility(View.VISIBLE);
                                findViewById(R.id.ll_countrycode).setVisibility(View.VISIBLE);
                                findViewById(R.id.ll_gender).setVisibility(View.VISIBLE);
                                findViewById(R.id.ll_phone).setVisibility(View.VISIBLE);
                                dummyData();
                                return;
                            }
                            sv_user_data.setVisibility(View.VISIBLE);
                            ll_animation.setVisibility(View.GONE);
                            ll_retry.setVisibility(View.GONE);
                            return;
                        }
                        jSONObject.has("image");
                        isEmpty(string2);
                        isEmpty(string3);
                        isEmpty(string7);
                        isEmpty("");
                        isEmpty(null);
                        isEmpty(string6);
                        isEmpty(string4);
                        isEmpty(string5);
                        jSONObject.length();
                    } catch (JSONException e) {
                        dummyData();
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public SpannableString getBlurString(String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new MaskFilterSpan(new BlurMaskFilter(20.0f, BlurMaskFilter.Blur.NORMAL)), 0, spannableString.length(), 33);
        return spannableString;
    }

    public boolean isEmpty(String str) {
        return str.isEmpty();
    }


    public void m4147xadd5ebdf(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        m4146x8b3a53ca();
    }


    public void m4146x8b3a53ca() {
        super.onBackPressed();
    }
}
