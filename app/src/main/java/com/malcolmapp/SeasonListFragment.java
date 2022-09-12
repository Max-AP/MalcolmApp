package com.malcolmapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.malcolmapp.databinding.FragmentSeasonListBinding;

public class SeasonListFragment extends Fragment {

    private FragmentSeasonListBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        System.out.println(this.getId());
        binding = FragmentSeasonListBinding.inflate(inflater, container, false);

        RecyclerView seasonRecyclerView =
                (RecyclerView) binding.getRoot().findViewById(R.id.season_recycler_view);
        System.out.println(seasonRecyclerView);
        Adapter seasonAdapter = new Adapter();
        seasonRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        seasonRecyclerView.setAdapter(seasonAdapter);

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SeasonListFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public boolean isEpisodeListFragment(){
        return false;
    }

}