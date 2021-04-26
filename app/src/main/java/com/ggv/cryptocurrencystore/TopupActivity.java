package com.ggv.cryptocurrencystore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.android.volley.VolleyError;
import com.ggv.cryptocurrencystore.services.UserService;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONObject;

public class TopupActivity extends AppCompatActivity {

    TextInputEditText editTextAmount;
    MaterialButton materialButtonSubmitTopup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup);
        editTextAmount = findViewById(R.id.editTextAmount);
        materialButtonSubmitTopup = findViewById(R.id.materialButtonSubmitTopup);
        materialButtonSubmitTopup.setEnabled(false);
        editTextAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!editable.toString().isEmpty() && Double.valueOf(editable.toString()) >= 10){
                    materialButtonSubmitTopup.setEnabled(true);
                    editTextAmount.setError(null);
                    return;
                }
                editTextAmount.setError("Minimum amount is $10");
                materialButtonSubmitTopup.setEnabled(false);
            }
        });

        materialButtonSubmitTopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserService userService = new UserService(TopupActivity.this);
                userService.topup(editTextAmount.getText().toString(), new UserService.ResultListener() {
                    @Override
                    public void onSuccess(JSONObject response) {
                        Log.d("topup", response.toString());
                        finish();
                    }

                    @Override
                    public void onFail(JSONObject response) {
                        Log.d("topup", response.toString());
                    }

                    @Override
                    public void onError(VolleyError error) {
                        error.printStackTrace();
                    }
                });
            }
        });
    }

    public void back(View view){
        onBackPressed();
    }
}