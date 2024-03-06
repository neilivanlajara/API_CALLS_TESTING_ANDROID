package com.example.api_calls_testing_android.ui.home;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.api_calls_testing_android.R;
import com.example.api_calls_testing_android.model.ArtWork;

import java.util.List;

public class HomeAdapter extends  RecyclerView.Adapter<HomeViewHolder>{

    private LayoutInflater inflater;

    private List<ArtWork> artWorks;


    public HomeAdapter(Context context, List<ArtWork> artWorks) {
        inflater = LayoutInflater.from(context);
        this.artWorks = artWorks;
    }


    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.single_art_work_scroll, parent, false);

        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        ArtWork artWork = artWorks.get(position);
/*
        String userName = artWork.getMessage()+" haha";
         +artWork.getPrimaryImage()


*/

        try{
            if(artWork.getConstituents().get(0).getName().contains("&#39")){
                artWork.getConstituents().get(0).setName(artWork.getConstituents().get(0).getName().replace("&#39;  ", "'"));
            }
            holder.updateContent(artWork.getConstituents().get(0).getName()+"", artWork.getPrimaryImageSmall(),artWork.getTitle());

        }catch (NullPointerException e){
            Log.d("TAG", "onBindViewHolder: niente ");
        }

     /*   if (artWork.getMessage() != "ObjectID not found"){
            holder.updateContent(artWork.getConstituents().get(0).getName()+"", artWork.getPrimaryImage());
        }else{
            holder.updateContent("non esiste niente :(", " ");

        }
*/

    }

    @Override
    public int getItemCount() {
        return artWorks.size();
    }
}
