package com.malcolmapp;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class FileManager {
    private static FileManager instance = null;
    private static AssetManager assetManager = null;
    private static String[] fileList;
    private static ArrayList<Season> seasonList = null;

    private FileManager(){
        seasonList = new ArrayList<>();
        try {
            fileList = assetManager.list("");
        } catch (IOException e) {
            System.out.println("Error opening assets");
        }

        for (int i = 0; i < fileList.length -2; i++) {
            BufferedReader reader = null;
            ArrayList<Episode> episodeList = new ArrayList<>();
            try{
                reader = new BufferedReader(
                        new InputStreamReader((assetManager.open(fileList[i]))));
                String episodeInfo;
                while ((episodeInfo = reader.readLine()) != null){
                    String[] info = episodeInfo.split("\\^");
                    episodeList.add(new Episode(info[1], Integer.parseInt(info[0]), info[2]));
                }
            } catch (Exception e){
                System.out.println("Error reading files");
            }
            seasonList.add(new Season(i + 1, episodeList));
        }
        for (Season s:seasonList
             ) {
            System.out.println(s);
        }
    }

    public static FileManager getInstance(Context context){

        if (instance == null){
            assetManager = context.getAssets();
            instance = new FileManager();
        }
        return instance;
    }

    public static Season getRandomSeason(){
        int index = new Random().nextInt(seasonList.size());
        return seasonList.get(index);
    }

    public static ArrayList<Season> getSeasonList() {
        return seasonList;
    }

    public static void printFileList(){
        for (int i = 0; i < fileList.length -2; i++) {
            System.out.println(fileList[i]);
        }
    }
}
