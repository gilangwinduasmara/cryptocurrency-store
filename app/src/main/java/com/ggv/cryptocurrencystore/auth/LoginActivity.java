package com.ggv.cryptocurrencystore.auth;
import com.ggv.cryptocurrencystore.R;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ggv.cryptocurrencystore.R;
import com.ggv.cryptocurrencystore.services.AuthService;

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

        AuthService authService = new AuthService(this);

        btnmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authService.login(editTextUsername.getText().toString(), editTextPassword.getText().toString());

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