package com.ggv.cryptocurrencystore.adapter;

import android.content.Context;
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
    Context context;

    public TransactionAdapter(List<Transaction> transactions, Context context){
        this.transactions = transactions;
        this.context = context;
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
        holder.textViewAmmount.setText("x"+transaction.getAmmount()+"");
        holder.textViewDate.setText(transaction.getCreated_at().split("T")[0]);
        holder.textViewTotal.setText("$"+(transaction.getPrice_usd() * transaction.getAmmount())+"");
        if(transaction.getStatus().equals("BUY")){
            holder.textViewStatus.setText("Buy");
            holder.cardViewStatus.setCardBackgroundColor(context.getResources().getColor(R.color.status_buy));
        }else if (transaction.getStatus().equals("SELL")){
            holder.textViewStatus.setText("Sell");
            holder.cardViewStatus.setCardBackgroundColor(context.getResources().getColor(R.color.status_sell));
        }else if (transaction.getStatus().equals("TOPUP")){
            holder.textViewStatus.setText("Topup");
            holder.cardViewStatus.setCardBackgroundColor(context.getResources().getColor(R.color.purple_500));
        }
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
        private TextView textViewStatus;
        private CardView cardViewTransaction;
        private CardView cardViewStatus;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewTotal = itemView.findViewById(R.id.textViewTotal);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewAmmount = itemView.findViewById(R.id.textViewAmmount);
            cardViewTransaction = itemView.findViewById(R.id.cardViewTransaction);
            textViewStatus = itemView.findViewById(R.id.textViewStatus);
            cardViewStatus = itemView.findViewById(R.id.cardViewStatus);
        }
    }
}
