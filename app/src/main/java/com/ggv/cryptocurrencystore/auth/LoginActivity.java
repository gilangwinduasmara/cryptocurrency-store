package com.ggv.cryptocurrencystore.auth;
import com.ggv.cryptocurrencystore.R;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ggv.cryptocurrencystore.R;
import com.ggv.cryptocurrencystore.services.AuthService;

public class LoginActivity extends AppCompatActivity {
    EditText editTextUsername, editTextPassword;
    Button btnmasuk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword =findViewById(R.id.editTextPassword);
        btnmasuk = findViewById(R.id.btnMasuk);

        AuthService authService = new AuthService(this);

        btnmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authService.login(editTextUsername.getText().toString(), editTextPassword.getText().toString());

            }
        });

    }


}