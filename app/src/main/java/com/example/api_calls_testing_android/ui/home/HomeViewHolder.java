package com.example.api_calls_testing_android.ui.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.api_calls_testing_android.R;

public class HomeViewHolder extends RecyclerView.ViewHolder {
    private  TextView artistName = null;
    private TextView artistArtworkPeriod = null;
    private ImageView artistWorkImage = null;

    public HomeViewHolder(@NonNull View itemView) {
        super(itemView);
        artistName = itemView.findViewById(R.id.textView);
        artistWorkImage = itemView.findViewById(R.id.imageView);
        artistArtworkPeriod = itemView.findViewById(R.id.ArtworkTitle);
    }

    public void updateContent(String artistName, String url, String title){
        this.artistName.setText(artistName);
        this.artistArtworkPeriod.setText(title);
        Glide.with(itemView.getContext())
                .load(url)
                .into(artistWorkImage);
    }
}
