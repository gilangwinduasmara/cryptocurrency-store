package com.ggv.cryptocurrencystore.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ggv.cryptocurrencystore.R;
import com.ggv.cryptocurrencystore.models.Asset;
import com.ggv.cryptocurrencystore.models.Transaction;

import org.w3c.dom.Text;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder> {
    List<Transaction> transactions;

    public TransactionAdapter(List<Transaction> transactions){
        this.transactions = transactions;
    }

    @NonNull
    @Override
    public TransactionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.transaction_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionAdapter.ViewHolder holder, int position) {
        Transaction transaction = transactions.get(position);
        holder.textViewName.setText(transaction.getAsset().getName());
        holder.cardViewTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("cardview", transaction.getAsset().getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private TextView textViewAmmount;
        private TextView textViewDate;
        private TextView textViewTotal;
        private CardView cardViewTransaction;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewTotal = itemView.findViewById(R.id.textViewTotal);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewAmmount = itemView.findViewById(R.id.textViewAmmount);
            cardViewTransaction = itemView.findViewById(R.id.cardViewTransaction);
        }
    }
}
