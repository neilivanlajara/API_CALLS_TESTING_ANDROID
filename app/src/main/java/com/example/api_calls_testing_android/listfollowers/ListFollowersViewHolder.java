package com.example.api_calls_testing_android.listfollowers;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.api_calls_testing_android.R;
import com.example.api_calls_testing_android.repository.GetArtworkRepository;


public class ListFollowersViewHolder extends RecyclerView.ViewHolder {


    private final TextView userName;
    private final TextView userID;
/*
    private final EditText editText;
*/
    private final ImageView userIMG;
    private ImageView userPicture;
    private final Bundle args;

    public ListFollowersViewHolder(@NonNull View itemView) {
        super(itemView);
        userName = itemView.findViewById(R.id.DepartmentID);
        userID = itemView.findViewById(R.id.DepartmentNAME);
        userIMG = itemView.findViewById(R.id.DepartmentIMG);
        EditText simpleEditText = (EditText) itemView.findViewById(R.id.search_bar_edit);
        args = new Bundle();


    }

    public void updateContent( String userName, int pversion){
        this.userName.setText(userName);
        this.userID.setText(Integer.toString(pversion));



        String url = "https://images.metmuseum.org/CRDImages/as/web-large/DP122162.jpg";
        Glide.with(itemView.getContext())
                .load(url)
                .into(userIMG);
    }

    public void updateUserPicture(Bitmap userPicture){

        int desiredWidth = 200;
        int desiredHeight = 200;

        Bitmap resizedBitmap = Bitmap.createScaledBitmap(userPicture, desiredWidth, desiredHeight, false);

        this.userPicture.setImageBitmap(resizedBitmap);
    }


}
