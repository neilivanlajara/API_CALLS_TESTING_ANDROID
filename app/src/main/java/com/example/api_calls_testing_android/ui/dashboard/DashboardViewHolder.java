package com.example.api_calls_testing_android.ui.dashboard;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.api_calls_testing_android.R;

public class DashboardViewHolder extends RecyclerView.ViewHolder{


    private final TextView titleArtwork;
    private final TextView artistNameArtwork;

    private final TextView artID;
    private final TextView departmentName;

    private final ImageView imageArtwork;
    /*private ImageView userPicture;*/
    private final Bundle args;

    public DashboardViewHolder(@NonNull View itemView) {
        super(itemView);
        departmentName = itemView.findViewById(R.id.fromWhatDepartment);
        titleArtwork = itemView.findViewById(R.id.titleArtwork);
        artistNameArtwork = itemView.findViewById(R.id.artistNameArtwork);
        imageArtwork = itemView.findViewById(R.id.imageArtwok);
        artID = itemView.findViewById(R.id.artID);
        args = new Bundle();



    }

    public void updateContent( String titleArtwork, String artistNameArtwork,String pic, int id, String departmentName){
        this.artistNameArtwork.setText(artistNameArtwork);
        this.titleArtwork.setText((titleArtwork));
        this.departmentName.setText((departmentName));
        this.args.putInt("id",id);

        imageArtwork.setOnClickListener( v ->{
            Navigation.findNavController(v).navigate(R.id.action_navigation_dashboard_to_onlyArtFragment,args);
        });






        Glide.with(itemView.getContext())
                .load(pic)
                .into(imageArtwork);


    }


    /*public void updateUserPicture(Bitmap userPicture){

        int desiredWidth = 200;
        int desiredHeight = 200;

        Bitmap resizedBitmap = Bitmap.createScaledBitmap(userPicture, desiredWidth, desiredHeight, false);

        this.userPicture.setImageBitmap(resizedBitmap);
    }*/

}
