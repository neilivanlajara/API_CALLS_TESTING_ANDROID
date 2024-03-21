package com.example.api_calls_testing_android.ui.dashboard;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.api_calls_testing_android.R;
import com.example.api_calls_testing_android.model.Artwork;


import java.util.List;
import java.util.concurrent.Executor;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardViewHolder> {
    private final LayoutInflater inflater;
    private final Executor executor;

    private List<Artwork> users;



    public DashboardAdapter(Context context, List<Artwork> users, Executor executor) {
        inflater = LayoutInflater.from(context);
        this.users = users;
        this.executor = executor;

    }

    @NonNull
    @Override
    public DashboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_artwork_recycler_viewer, parent, false);

        return new DashboardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardViewHolder holder, int position) {
        Artwork singleDep = users.get(position);
        holder.updateContent(singleDep.getTitle(),singleDep.getConstituents().get(0).getName(), singleDep.getPrimaryImageSmall(), singleDep.getObjectID(), singleDep.getGalleryNumber());
    }




    @Override
    public int getItemCount() {
        return users.size();
    }
    public void setArtworkList(List<Artwork> artworkList) {
        this.users = artworkList;
        notifyDataSetChanged();
    }

    // Metodo per rimuovere un'opera d'arte dalla lista
    public void removeArtwork(int position) {
        if (users != null && position >= 0 && position < users.size()) {
            users.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void destroyList(){
            users.removeAll(users);
    }

    public void getItem(int id){
        Log.d("getItem", "getItem: "+ users.get(id).getPrimaryImageSmall());
    }

}
