package com.malcolmapp;

public class Episode {
    private final String episodeName;
    private final int episodeNumber;
    private final String episodeDescription;

    public Episode(String episodeName, int episodeNumber, String episodeDescription){
        this.episodeName = episodeName;
        this.episodeNumber = episodeNumber;
        this.episodeDescription = episodeDescription;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public String getEpisodeDescription() {
        return episodeDescription;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "episodeName='" + episodeName + '\'' +
                ", episodeNumber=" + episodeNumber +
                ", episodeDescription='" + episodeDescription + '\'' +
                '}';
    }
}
