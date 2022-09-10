package com.malcolmapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.malcolmapp.databinding.FragmentEpisodeSelectorBinding;


public class EpisodeSelectorFragment extends Fragment {

    private FragmentEpisodeSelectorBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentEpisodeSelectorBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Season randomSeason = FileManager.getRandomSeason();
        Episode randomEpisode = randomSeason.getRandomEpisode();
        TextView seasonTextView = requireActivity().findViewById(R.id.seasonTextView);
        TextView episodeNumberTextView = getActivity().findViewById(R.id.episodeNumberTextView);
        TextView episodeTitleTextView = getActivity().findViewById(R.id.episodeTitleTextView);
        TextView episodeDescriptionTextView = getActivity().findViewById(R.id.episodeSummaryTextView);

        seasonTextView.setText(String.valueOf(randomSeason.getSeasonNumber()));
        episodeNumberTextView.setText(String.valueOf(randomEpisode.getEpisodeNumber()));
        episodeTitleTextView.setText(randomEpisode.getEpisodeName());
        episodeDescriptionTextView.setText(randomEpisode.getEpisodeDescription());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}