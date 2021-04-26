package com.ggv.cryptocurrencystore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import com.ggv.cryptocurrencystore.auth.LoginActivity;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String token = sharedPref.getString("token", "");
        Log.d("token", token);
        if(token.isEmpty()){
            intent = new Intent(MainActivity.this, OnBoardingActivity.class);
            finish();
            startActivity(intent);
        }else{
//            ke dashboard
            intent = new Intent(MainActivity.this, DashboardActivity.class);
            finish();
            startActivity(intent);
//            Toast.makeText(this, token, Toast.LENGTH_SHORT).show();
        }

    }
}