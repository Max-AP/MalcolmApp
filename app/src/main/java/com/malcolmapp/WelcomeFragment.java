package com.malcolmapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.malcolmapp.databinding.FragmentWelcomeBinding;

public class WelcomeFragment extends Fragment {

    private FragmentWelcomeBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentWelcomeBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FileManager.getInstance(getContext());

        binding.buttonRandomEpisode.setOnClickListener(view1 -> NavHostFragment
                .findNavController(WelcomeFragment.this)
                .navigate(R.id.action_WelcomeFragment_to_EpisodeSelectorFragment));

        binding.buttonSeasonList.setOnClickListener(view12 -> NavHostFragment
                .findNavController(WelcomeFragment.this)
                .navigate(R.id.action_WelcomeFragment_to_SeasonListFragment));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}