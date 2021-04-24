package com.ggv.cryptocurrencystore.adapter;

import android.content.Context;

import com.ggv.cryptocurrencystore.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.ggv.cryptocurrencystore.models.Slide;

import java.util.List;
public class OnBoardingAdapter extends RecyclerView.Adapter<OnBoardingAdapter.OnboardingViewHolder>{
    private List<Slide> slides;
    public OnBoardingAdapter(List<Slide> slides) {
        this.slides = slides;
    }
    @NonNull
    @Override
    public OnboardingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OnboardingViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.on_boarding_slide_layout, parent, false
                )
        );
    }
    @Override
    public void onBindViewHolder(@NonNull OnboardingViewHolder holder, int position) {
        holder.setOnBoardingData(slides.get(position));
    }
    @Override
    public int getItemCount() {
        return slides.size();
    }
    class OnboardingViewHolder extends RecyclerView.ViewHolder {
        private TextView textTitle;
        private TextView textDescription;
        private ImageView imageOnboarding;
        OnboardingViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            textDescription = itemView.findViewById(R.id.textDescription);
            imageOnboarding = itemView.findViewById(R.id.imageOnboarding);
        }
        void setOnBoardingData(Slide slide){
            textTitle.setText(slide.getTitle());
            textDescription.setText(slide.getDescription());
            imageOnboarding.setImageResource(slide.getImage());
        }
    }
}