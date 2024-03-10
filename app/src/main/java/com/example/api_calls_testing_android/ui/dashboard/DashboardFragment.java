package com.example.api_calls_testing_android.ui.dashboard;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.api_calls_testing_android.R;
import com.example.api_calls_testing_android.model.Artwork;
import com.example.api_calls_testing_android.model.SearchQuery;
import com.example.api_calls_testing_android.repository.GetSearchQueryRepository;

import androidx.appcompat.widget.SearchView;

import java.util.List;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private DashboardAdapter dashboardAdapter;
    private RecyclerView recyclerView;

    private String TAG = "ListFollowers";

    private GridLayoutManager layoutManager;

    private SearchView searchView;

    private TextView scrittaTAG = null;
    private ImageView logo;




    public static DashboardFragment newInstance() {
        return new DashboardFragment();
    }


  /*  @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      *//*  this.listFollowersViewModel = new ViewModelProvider(this).get(ListFollowersViewModel.class);
        listFollowersViewModel.feedUserListFollowerBuffer();*//*
        layoutManager = new GridLayoutManager(getContext(), 2);

*//*
        logo = getView().findViewById(R.id.logo_MET);
*//*

    }
*/

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        this.dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
        layoutManager = new GridLayoutManager(getContext(), 2);





        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

/*
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(getClass().getSimpleName());

    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
*/

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        logo = getView().findViewById(R.id.logo_MET);

        logo.setOnClickListener( v ->{
            Toast.makeText(getContext(), "ciaoo", Toast.LENGTH_SHORT).show();

        });

        searchView = getView().findViewById(R.id.searchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
/*
                Log.d(TAG, "onQueryTextSubmit: "+ query);

*/
                performSearchQueryRequest(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d(TAG, "onQueryTextChange: "+ newText);

                return false;
            }
        });


    }
    private void performSearchQueryRequest(String query) {
        // Esegui la tua chiamata di rete qui, ad esempio con Retrofit, AsyncTask, ecc.
        // Sostituisci questo con la tua logica di chiamata di rete reale
      Toast.makeText(getActivity(), "Cercando: " + query, Toast.LENGTH_SHORT).show();

        GetSearchQueryRepository.getSearchQueryRepository(query,res->{
                checkEmptySearchQuery(res);
              //provo a togliere la lista highlights
        }, ()->{});
    }

    private void checkEmptySearchQuery(SearchQuery searchQuery) throws Exception{
            try{
                dashboardViewModel.feedArtworkByQuery(searchQuery.getArtworks());

            }catch (NullPointerException | IndexOutOfBoundsException q){
                Toast.makeText(getActivity(), "Nessun risultato " , Toast.LENGTH_SHORT).show();

            }
    }




    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.d("LISTFOLLOWERS", "onActivityCreated: ");
        recyclerView = getView().findViewById(R.id.contactsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
/*
        viewPager = getView().findViewById(R.id.viewPagerListFollower);
*/

        List<Artwork> e =     dashboardViewModel.getArtworkList().getValue();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            dashboardAdapter = new DashboardAdapter(getActivity(),e , getActivity().getMainExecutor() );
        }

        dashboardViewModel.getArtworkList().observe(getActivity(), new Observer<List<Artwork>>() {
            @Override //grazie a questo riesco a cancellare i vecchi risultati, ogni volta che modifico il model
            //devo anche notificare l'adapter altrimenti crasha
            public void onChanged(List<Artwork> artworks) {
                dashboardAdapter.setArtworkList(artworks);

            }


        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.d(TAG, "onScrollStateChanged: "+newState);
            }
        });


/*
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL, false));
*/



        recyclerView.setAdapter(dashboardAdapter);

    }

}