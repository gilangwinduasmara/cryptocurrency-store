package com.ggv.cryptocurrencystore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ggv.cryptocurrencystore.models.Asset;

public class TransactionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        Asset asset = getIntent().getParcelableExtra("asset");
    }
}