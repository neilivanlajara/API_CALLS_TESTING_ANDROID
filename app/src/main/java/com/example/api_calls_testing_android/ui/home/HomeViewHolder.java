package com.example.api_calls_testing_android.ui.home;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.api_calls_testing_android.R;

import java.util.Arrays;

public class HomeViewHolder extends RecyclerView.ViewHolder {

    private TextView artistArtworkPeriod = null;
    private ImageView imageView = null;
    private TextView artYear= null;

    public HomeViewHolder(@NonNull View itemView) {
        super(itemView);
        artistArtworkPeriod = itemView.findViewById(R.id.textView);

        artYear = itemView.findViewById(R.id.yearTextView);

        imageView = itemView.findViewById(R.id.imageHome);

    }

    public void updateContent(String artistName, String url, String title, String accessionYear){
        title = textCleaner(title);
        artistName = textCleaner(artistName);

        this.artistArtworkPeriod.setText(title);
        this.artYear.setText(artistName+" , "+ accessionYear);
        Glide.with(itemView.getContext())
                .load(url)
                .into(imageView);
             /*   .into(new CustomTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        itemView.setBackground(resource);

                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {
                        // Can be empty
                    }
                });*/

    }

    private String textCleaner(String inputString){
        inputString = inputString.replace("\"", "");
        return  (inputString.length() > 50)
                ? String.join(" ", Arrays.copyOfRange(inputString.replaceAll("\\[.*?\\]|\\(.*?\\)", "").split("\\s+"), 0, 8))
                : inputString.replaceAll("\\[.*?\\]|\\(.*?\\)", "");
    }
}
