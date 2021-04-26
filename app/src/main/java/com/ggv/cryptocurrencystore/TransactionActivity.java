package com.ggv.cryptocurrencystore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.ggv.cryptocurrencystore.models.Asset;

public class TransactionActivity extends AppCompatActivity {
    TextView textViewPrice;
    TextView textViewAssetName;
    EditText editTextAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        Asset asset = getIntent().getParcelableExtra("asset");
        textViewPrice = findViewById(R.id.textViewPrice);
        textViewAssetName = findViewById(R.id.textViewAssetName);
        editTextAmount = findViewById(R.id.editTextAmount);

        textViewPrice.setText(asset.getPrice_usd()+"");
        textViewAssetName.setText(asset.getName());
    }
}