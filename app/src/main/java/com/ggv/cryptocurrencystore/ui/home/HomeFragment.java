package com.ggv.cryptocurrencystore.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.VolleyError;
import com.ggv.cryptocurrencystore.R;
import com.ggv.cryptocurrencystore.adapter.AssetAdapter;
import com.ggv.cryptocurrencystore.adapter.TransactionAdapter;
import com.ggv.cryptocurrencystore.models.Asset;
import com.ggv.cryptocurrencystore.models.Transaction;
import com.ggv.cryptocurrencystore.services.AssetService;
import com.ggv.cryptocurrencystore.services.TransactionService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView recyclerView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        TransactionService transactionService = new TransactionService(getActivity());
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewTransaction);
        transactionService.get(new AssetService.ResultListener() {
            @Override
            public void onSuccess(JSONObject response) {
                try{
                    Log.d("transactions",response.toString());
                    List<Transaction> transactions = new ArrayList<>();
                    JSONArray assetsResponse = response.getJSONArray("data");
                    for(int i = 0; i < assetsResponse.length(); i++){
                        JSONObject transactionObject = assetsResponse.getJSONObject(i);
                        JSONObject assetObject = transactionObject.getJSONObject("asset");
                        Asset asset = new Asset();
                        asset.setAsset_id(assetObject.getString("asset_id"));
                        asset.setName(assetObject.getString("name"));
                        asset.setType_is_crypto(assetObject.getString("type_is_crypto"));
                        asset.setData_start(assetObject.getString("data_start"));
                        asset.setData_end(assetObject.getString("data_end"));
                        asset.setData_quote_start(assetObject.getString("data_quote_start"));
                        asset.setData_quote_end(assetObject.getString("data_quote_end"));
                        asset.setData_orderbook_start(assetObject.getString("data_orderbook_start"));
                        asset.setData_orderbook_end(assetObject.getString("data_orderbook_end"));
                        asset.setData_trade_start(assetObject.getString("data_trade_start"));
                        asset.setData_trade_end(assetObject.getString("data_trade_end"));
                        asset.setData_symbols_count(assetObject.getString("data_symbols_count"));
                        asset.setVolume_1hrs_usd(assetObject.getString("volume_1hrs_usd"));
                        asset.setVolume_1day_usd(assetObject.getString("volume_1day_usd"));
                        asset.setVolume_1mth_usd(assetObject.getString("volume_1mth_usd"));
                        asset.setPrice_usd(assetObject.getString("price_usd"));
                        asset.setId_icon(assetObject.getString("id_icon"));
                        Transaction transaction = new Transaction();
                        transaction.setId(transactionObject.getString("id"));
                        transaction.setAsset_id(transactionObject.getString("asset_id"));
                        transaction.setPrice_usd(transactionObject.getDouble("price_usd"));
                        transaction.setStatus(transactionObject.getString("status"));
                        transaction.setAmmount(transactionObject.getDouble("ammount"));
                        transaction.setCreated_at(transactionObject.getString("createdAt"));
                        transaction.setUpdated_at(transactionObject.getString("updatedAt"));
                        transaction.setAsset(asset);
                        transactions.add(transaction);
                        Log.d("asset name", asset.getName());
                    }
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(layoutManager);
                    TransactionAdapter adapter = new TransactionAdapter(transactions);
                    recyclerView.setAdapter(adapter);
                }catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFail(JSONObject response) {

            }

            @Override
            public void onError(VolleyError error) {

            }
        });

//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return view;
    }
}