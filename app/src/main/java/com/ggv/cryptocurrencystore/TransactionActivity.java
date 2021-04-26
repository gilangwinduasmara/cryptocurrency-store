package com.ggv.cryptocurrencystore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.ggv.cryptocurrencystore.models.Asset;
import com.ggv.cryptocurrencystore.services.AssetService;
import com.ggv.cryptocurrencystore.services.TransactionService;
import com.google.android.material.button.MaterialButton;

import org.json.JSONObject;

public class TransactionActivity extends AppCompatActivity {
    TextView textViewPrice;
    TextView textViewAssetName;
    TextView textViewTotal;
    EditText editTextAmount;
    MaterialButton materialButtonBuy, materialButtonSell;
    Asset asset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        asset = getIntent().getParcelableExtra("asset");
        textViewPrice = findViewById(R.id.textViewPrice);
        textViewAssetName = findViewById(R.id.textViewAssetName);
        textViewTotal = findViewById(R.id.textViewTotal);
        editTextAmount = findViewById(R.id.editTextAmount);

        materialButtonBuy = findViewById(R.id.materialButtonBuy);
        materialButtonSell = findViewById(R.id.materialButtonSell);

        textViewPrice.setText(asset.getPrice_usd()+"");
        textViewAssetName.setText(asset.getName());

        materialButtonBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createTransaction("BUY");
            }
        });

        materialButtonSell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createTransaction("SELL");
            }
        });

        editTextAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().isEmpty()){
                    textViewTotal.setText(0+" usd");
                    return;
                }
                double total = Double.valueOf(editable.toString()) * Double.valueOf(asset.getPrice_usd());
                textViewTotal.setText(total+" usd");
            }
        });
    }

    public void createTransaction(String status){
        TransactionService transactionService = new TransactionService(TransactionActivity.this);
        transactionService.create(asset.getAsset_id(), editTextAmount.getText().toString(), status, new AssetService.ResultListener() {
            @Override
            public void onSuccess(JSONObject response) {
                Log.d("response", response.toString());
            }

            @Override
            public void onFail(JSONObject response) {
                Log.d("response", response.toString());
            }

            @Override
            public void onError(VolleyError error) {
                error.printStackTrace();
            }
        });
    }

}