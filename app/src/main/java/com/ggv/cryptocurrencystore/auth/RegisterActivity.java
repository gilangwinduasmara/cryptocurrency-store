package com.ggv.cryptocurrencystore.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.ggv.cryptocurrencystore.R;
import com.ggv.cryptocurrencystore.services.AuthService;

import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {
    Button button;
    EditText editTxtName, editTxtUser, editTxtEmail, editTxtPas, editTxtConfir;
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
        editTxtPas = findViewById(R.id.editTxtPass);
        editTxtConfir = findViewById(R.id.editTxtConfir);
        txtLogin = findViewById(R.id.txtLogin);

        Context context = this;
        AuthService authService = new AuthService(this);

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
                String name = editTxtName.getText().toString();
                String user = editTxtUser.getText().toString();
                String email = editTxtEmail.getText().toString();
                String password = editTxtPas.getText().toString();
                String confirm = editTxtConfir.getText().toString();

                authService.register(editTxtName.getText().toString(), editTxtUser.getText().toString(), editTxtEmail.getText().toString(), editTxtPas.getText().toString(),
                        new AuthService.ResultListener() {

                            @Override
                            public void onSuccess(JSONObject response) {
                                Log.d("register", response.toString());
                                intent = new Intent(RegisterActivity.this, LoginActivity.class);
//                                intent.putExtra("name", name);
//                                intent.putExtra("username", user);
//                                intent.putExtra("email", email);
//                                intent.putExtra("password", password);
//                                intent.putExtra("confirm", confirm);
                                finish();
                                startActivity(intent);
                            }

                            @Override
                            public void onFail(JSONObject response) {
                                Log.d("register", response.toString());
                            }

                            @Override
                            public void onError(VolleyError error) {
                                error.printStackTrace();
                            }
                        });



                if(name.isEmpty()){
                    Toast.makeText(context,"Sorry. Please Input Your Name",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if(user.isEmpty()){
                    Toast.makeText(context,"Sorry. Please Input Your Username",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if(email.isEmpty()){
                    Toast.makeText(context,"Sorry. Please Input Your Email",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if(password.isEmpty()){
                    Toast.makeText(context,"Sorry. Please Confirm Your Password",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!password.equals(confirm)){
                    Toast.makeText(context,"Please Check Your Password",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
//                intent = new Intent(RegisterActivity.this, LoginActivity.class);
//                intent.putExtra("name", name);
//                intent.putExtra("username", user);
//                intent.putExtra("email", email);
//                intent.putExtra("password", password);
//                intent.putExtra("confirm", confirm);
//                finish();
//                startActivity(intent);
            }
        });



    }
}