package com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsApi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface kingappsInterface {
    @GET("HappyNewYear/sneh-dev/callhistory/getPhp.json")
    Call<kingappsPojoSqure> getIndiaCallHistory();
}