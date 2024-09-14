package com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class kingappsClient {

    public static String URL = "https://decodeking.com/";
    public static Retrofit retrofit = null;

    public static Retrofit getData() {

        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}