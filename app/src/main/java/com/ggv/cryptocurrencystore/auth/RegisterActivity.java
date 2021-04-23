package com.ggv.cryptocurrencystore.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ggv.cryptocurrencystore.R;

public class RegisterActivity extends AppCompatActivity {
    Button button;
    EditText editTxtName, editTxtUser, editTxtEmail, editTxtPas;
    TextView txtLogin;
    Intent intent;

    int success;

    //private String url = Server.URL + "RegisterActivity.java";

    private static final String TAG = RegisterActivity.class.getSimpleName();

    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    String tag_json_obj = "json_obj_req";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        button = findViewById(R.id.button);
        editTxtName = findViewById(R.id.editTxtName);
        editTxtUser = findViewById(R.id.editTxtUser);
        editTxtEmail = findViewById(R.id.editTxtEmail);
        editTxtPas = findViewById(R.id.editTextPassword);
        txtLogin = findViewById(R.id.txtLogin);

        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(RegisterActivity.this, LoginActivity.class);
                finish();
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}