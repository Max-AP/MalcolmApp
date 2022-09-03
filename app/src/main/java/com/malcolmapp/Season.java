package com.malcolmapp;

import java.util.ArrayList;

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
}
