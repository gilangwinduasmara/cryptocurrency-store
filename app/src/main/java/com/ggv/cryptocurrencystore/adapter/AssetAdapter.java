package com.ggv.cryptocurrencystore.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ggv.cryptocurrencystore.R;
import com.ggv.cryptocurrencystore.models.Asset;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AssetAdapter extends RecyclerView.Adapter<AssetAdapter.ViewHolder> {
    List<Asset> assets;

    public AssetAdapter(List<Asset> assets){
        this.assets = assets;
    }

    @NonNull
    @Override
    public AssetAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.asset_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AssetAdapter.ViewHolder holder, int position) {
        Asset asset = assets.get(position);
        holder.textViewName.setText(asset.getName());
        holder.textViewHarga.setText(asset.getPrice_usd());
        if(asset.getId_icon() != null) {
            Picasso.get().load("https://s3.eu-central-1.amazonaws.com/bbxt-static-icons/type-id/png_16/"+asset.getId_icon()).into(holder.imageView);
        }
        holder.cardViewAsset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("cardview", asset.getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return assets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewName, textViewHarga;
        private CardView cardViewAsset;
        private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            cardViewAsset = itemView.findViewById(R.id.cardViewAsset);
            imageView = itemView.findViewById(R.id.imageView);
            textViewHarga = itemView.findViewById(R.id.textViewHarga);
        }
    }
}
