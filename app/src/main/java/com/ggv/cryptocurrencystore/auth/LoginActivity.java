package com.ggv.cryptocurrencystore.auth;
import com.android.volley.VolleyError;
import com.ggv.cryptocurrencystore.MainActivity;
import com.ggv.cryptocurrencystore.R;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ggv.cryptocurrencystore.R;
import com.ggv.cryptocurrencystore.services.AuthService;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    EditText editTextUsername, editTextPassword;
    TextView txtRegis;
    Button btnmasuk;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword =findViewById(R.id.editTextPassword);
        btnmasuk = findViewById(R.id.btnMasuk);
        txtRegis = findViewById(R.id.txtRegis);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPref.edit();

        AuthService authService = new AuthService(this);

        btnmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authService.login(editTextUsername.getText().toString(), editTextPassword.getText().toString(), new AuthService.ResultListener() {
                    @Override
                    public void onSuccess(JSONObject response) {
                        try {
                            Log.d("login", response.toString());
                            editor.putString("token", response.getString("token"));
                            editor.commit();
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFail(JSONObject response) {
                        Log.d("login", response.toString());
                    }

                    @Override
                    public void onError(VolleyError error) {
                        error.printStackTrace();
                    }
                });

            }
        });

        txtRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(LoginActivity.this, RegisterActivity.class);
                finish();
                startActivity(intent);
            }
        });

    }


}