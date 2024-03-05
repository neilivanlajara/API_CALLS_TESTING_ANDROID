package com.example.api_calls_testing_android.ui.home;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.api_calls_testing_android.model.ArtWork;
import com.example.api_calls_testing_android.repository.GetArtworkRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class HomeViewModel extends AndroidViewModel {

    AtomicInteger q= new AtomicInteger(0);

    private final MutableLiveData<List<ArtWork>> artWorkBuffer = new MutableLiveData<>(new ArrayList<>());


    public HomeViewModel(@NonNull Application application) {
        super(application);
    }


    public MutableLiveData<List<ArtWork>> getArtWorkBuffer (){
/*
        if (this.twokBuffer.getValue() != null && this.twokBuffer.getValue().size() == 0) feedTwokBuffer();
*/
        return this.artWorkBuffer;
    }
   /* public void feedArtworkBuffer(){
        for (int i = 0; i <4 ; i++) {
            ArtWork h = new ArtWork(i + " prova");
            Objects.requireNonNull(artWorkBuffer.getValue()).add(h);
            artWorkBuffer.setValue(artWorkBuffer.getValue());


        }
    }
*/


    public void feedArtworkBuffer(){
        Integer[] monet = {435664,435665,435666,435668,435669,435670,435671,435672,435673,435678,435680,435682,435683,435684,435685,435686,435687,435688,435689,435690,435691,435692,435693,435694,435695,435696,435697,435698,435699,435700,435701,435702,435703,435704,435705,435706,435707,435708,435709,435711,435713,435714,435715,435716,435717,435718,435719,435720,435721,435722,435723,435724,435725,435726,435727};
        for ( AtomicInteger indexRequest = new AtomicInteger(0);  indexRequest.get()< 4; indexRequest.set(indexRequest.get()+1)) {
            q.set(q.get()+1);

            GetArtworkRepository.getObject(
                    monet[q.get()],
                artwork->{

                    //se è vuoto
                    try{
                        Log.d("please", "feedArtworkBuffer:  "+ q.get()+ "<->" + artwork.getObjectID()+ "<->"+artwork.isHighLight()+"<->"+ artwork.getPrimaryImage() + " "+ artwork.getPeriod());
                        Objects.requireNonNull(artWorkBuffer.getValue()).add(artwork);
                        artWorkBuffer.setValue(artWorkBuffer.getValue());



                    }catch(NullPointerException e){
                        Log.d("please", "feedArtworkBuffer: devo rifare ");
                    }



                },
                ()->{
                    Log.d("errors", "feedArtworkBuffer: error ");
                }
            );

        }


    }


}