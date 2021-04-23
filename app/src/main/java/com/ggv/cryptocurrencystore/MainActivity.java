package com.ggv.cryptocurrencystore;

import androidx.appcompat.app.AppCompatActivity;

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

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String token = sharedPref.getString("token", "");
        Log.d("token", token);
        if(token.isEmpty()){
            intent = new Intent(MainActivity.this, LoginActivity.class);
            finish();
            startActivity(intent);
        }else{
//            ke dashboard
            Toast.makeText(this, token, Toast.LENGTH_SHORT).show();
        }

    }
}