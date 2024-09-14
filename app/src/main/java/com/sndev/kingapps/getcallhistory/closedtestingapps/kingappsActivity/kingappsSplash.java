package com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsApi.kingappsInterface;
import com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsApi.kingappsPojoSqure;
import com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsApi.kingappsClient;
import com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsHome.kingappsHome;
import com.sndev.kingapps.getcallhistory.closedtestingapps.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class kingappsSplash extends AppCompatActivity {

    public static String key_InAppMode = "";
    public static String key_Ticket_Bronze = "";
    public static String key_Ticket_Silver = "";
    public static String key_Ticket_Gold = "";
    public static String key_Qureka = "";
    public static String key_GameLink = "";
    public static String key_MerchantUPI = "";
    public static String key_MerchantCODE = "";
    public static String key_Privacy = "";

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.kingappssplash);

        loadHttp();

    }

    private void loadHttp() {
        kingappsInterface kingappsInterface = kingappsClient.getData().create(kingappsInterface.class);
        kingappsInterface.getIndiaCallHistory().enqueue(new Callback<kingappsPojoSqure>() {
            @Override
            public void onResponse(Call<kingappsPojoSqure> call, Response<kingappsPojoSqure> response) {
                if (response.isSuccessful()) {
                    key_InAppMode = response.body().getCLTagInAppMode();
                    key_Ticket_Bronze = response.body().getCLTagTicketBronze();
                    key_Ticket_Silver = response.body().getCLTagTicketSilver();
                    key_Ticket_Gold = response.body().getCLTagTicketGold();
                    key_Qureka = response.body().getCLTagQureka();
                    key_GameLink = response.body().getCLTagGameLink();
                    key_MerchantUPI = response.body().getCLTagMerchantUPI();
                    key_MerchantCODE = response.body().getCLTagMerchantCODE();
                    key_Privacy = response.body().getcLTagPrivacy();
                    goSilver();
                } else {
                    Toast.makeText(kingappsSplash.this, "response: Error!", Toast.LENGTH_SHORT).show();
                    goSilver();
                }
            }

            @Override
            public void onFailure(Call<kingappsPojoSqure> call, Throwable t) {
                Toast.makeText(kingappsSplash.this, "error 404: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                goSilver();
            }
        });
    }

    private void goSilver() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(kingappsSplash.this, kingappsHome.class));
                finish();
            }
        }, 2000);
    }


    @Override
    public void onBackPressed() {
    }


}
