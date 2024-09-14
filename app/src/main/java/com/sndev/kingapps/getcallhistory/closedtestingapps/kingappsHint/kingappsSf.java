package com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsHint;

import android.content.Context;
import android.content.SharedPreferences;
import com.sndev.kingapps.getcallhistory.closedtestingapps.R;
import org.json.JSONArray;
import org.json.JSONException;


public class kingappsSf {
    Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor sharedPreferencesEditor;

    public kingappsSf(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name) + "AppPreferences", 0);
        this.sharedPreferences = sharedPreferences;
        this.sharedPreferencesEditor = sharedPreferences.edit();
        this.context = context;
    }

    public void clear() {
        this.sharedPreferencesEditor.clear();
        this.sharedPreferencesEditor.commit();
    }

    public void setJsonArray(String str, JSONArray jSONArray) {
        this.sharedPreferencesEditor.putString(str, jSONArray.toString());
        this.sharedPreferencesEditor.commit();
    }

    public JSONArray getJsonArray(String str) {
        JSONArray jSONArray = new JSONArray();
        if (this.sharedPreferences.contains(str)) {
            try {
                return new JSONArray(this.sharedPreferences.getString(str, ""));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONArray;
    }

    public void setString(String str, String str2) {
        this.sharedPreferencesEditor.putString(str, str2);
        this.sharedPreferencesEditor.commit();
    }

    public String getString(String str) {
        return this.sharedPreferences.getString(str, "");
    }

    public void setInt(String str, int i) {
        this.sharedPreferencesEditor.putInt(str, i);
        this.sharedPreferencesEditor.commit();
    }

    public Integer getInt(String str) {
        return Integer.valueOf(this.sharedPreferences.getInt(str, 0));
    }

    public boolean hasInt(String str) {
        return this.sharedPreferences.contains(str);
    }

    public void setBoolean(String str, Boolean bool) {
        this.sharedPreferencesEditor.putBoolean(str, bool.booleanValue());
        this.sharedPreferencesEditor.commit();
    }

    public Boolean getBoolean(String str) {
        return Boolean.valueOf(this.sharedPreferences.getBoolean(str, false));
    }
}
