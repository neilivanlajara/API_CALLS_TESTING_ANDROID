package com.example.api_calls_testing_android.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.api_calls_testing_android.MainActivity;
import com.example.api_calls_testing_android.R;
import com.example.api_calls_testing_android.databinding.FragmentHomeBinding;



public class HomeFragment extends Fragment {

    private ViewPager2 viewPager;
    private  HomeViewModel homeViewModel;
    private HomeAdapter homeAdapter;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainActivity) requireActivity()).getSupportActionBar().hide();

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        viewPager = getView().findViewById(R.id.viewPager);
        homeAdapter = new HomeAdapter(getActivity(), homeViewModel.getArtWorkBuffer().getValue());
        homeViewModel.feedArtworkBuffer();


        homeViewModel.getArtWorkBuffer().observe(getActivity(), v->{
            homeAdapter.notifyItemInserted(homeViewModel.getArtWorkBuffer().getValue().size()-1);

        });

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (homeViewModel.getArtWorkBuffer().getValue().size()<position+2){
                    Toast.makeText(getContext(), "carico altre opere!", Toast.LENGTH_SHORT).show();
                    homeViewModel.feedArtworkBuffer();
                     Log.d("please", "onViewCreated: "+ homeAdapter.getItemCount());

                }
            }
        });
        viewPager.setAdapter(homeAdapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
