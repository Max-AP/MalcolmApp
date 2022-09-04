package com.malcolmapp;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
    private static FileManager instance = null;
    private static AssetManager assetManager = null;
    private static String[] fileList;
    private ArrayList<Season> seasonList = null;

    private FileManager(){

        try {
            fileList = assetManager.list("");
        } catch (IOException e) {
            System.out.println("memes");
        }
    }

    public static FileManager getInstance(Context context){

        if (instance == null){
            assetManager = context.getAssets();
            instance = new FileManager();
        }
        return instance;
    }

    public static void printFileList(){
        for (String fileName: fileList) {
            System.out.println(fileName);
        }
    }
}
