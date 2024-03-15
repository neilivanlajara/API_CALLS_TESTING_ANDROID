package com.example.api_calls_testing_android.ui.onlyArt;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.api_calls_testing_android.R;
import com.example.api_calls_testing_android.databinding.FragmentOnlyArtBinding;
import com.example.api_calls_testing_android.repository.GetArtworkRepository;
import com.github.chrisbanes.photoview.PhotoView;


public class OnlyArtFragment extends Fragment {


    private final String TAG = "OnlyArt";
    private TextView artistArtworkPeriod = null;
    private PhotoView imageView = null;
    private TextView artYear= null;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        return inflater.inflate(R.layout.single_art_work_scroll, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {

            artistArtworkPeriod = getView().findViewById(R.id.textView);

            artYear = getView().findViewById(R.id.yearTextView);

            imageView = getView().findViewById(R.id.imageHome);

            GetArtworkRepository.getObject(
                   Integer.parseInt( getArguments().get("id").toString()),
                    artWork -> {

                        this.artistArtworkPeriod.setText(artWork.getTitle());
                        this.artYear.setText(artWork.getConstituents().get(0).getName()+" , "+ artWork.getAccessionYear());


                        Glide.with(getContext())
                                .load(artWork.getPrimaryImageSmall())
                                .into(imageView);
                    },
                    ()->{}

            );


            Log.d(TAG, "onCreateView: "+getArguments().get("id"));
/*
            specificUserProfileViewModel.setExecutor(requireActivity().getMainExecutor());
*/
        }
    }





}