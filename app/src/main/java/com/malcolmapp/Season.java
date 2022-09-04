package com.malcolmapp;

import java.util.ArrayList;
import java.util.Random;

public class Season {
    private final int seasonNumber;
    private final ArrayList<Episode> episodeList;

    public Season(int seasonNumber, ArrayList<Episode> episodeList){
        this.seasonNumber = seasonNumber;
        this.episodeList = episodeList;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public ArrayList<Episode> getEpisodeList() {
        return episodeList;
    }

    public int getEpisodeAmount(){
        return episodeList.size();
    }

    public Episode getRandomEpisode(){
        int index = new Random().nextInt(getEpisodeAmount());
        return episodeList.get(index);
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonNumber=" + seasonNumber +
                ", episodeList=" + episodeList +
                '}';
    }
}
