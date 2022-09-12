package com.malcolmapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private static ArrayList<Season> seasonList;

    public Adapter(){
        seasonList = FileManager.getSeasonList();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.season_list_item, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Season season = seasonList.get(position);
        System.out.println(season.getSeasonNumber());
        holder.seasonNumber.setText(String.valueOf(season.getSeasonNumber()));
        holder.linearLayout.setOnClickListener(view ->
                Toast.makeText(view.getContext()
                ,"Season: "+ season.getSeasonNumber()
                ,Toast.LENGTH_LONG).show());
    }

    @Override
    public int getItemCount() {
        return seasonList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView seasonNumber;
        public LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.seasonNumber = (TextView) itemView.findViewById(R.id.textview_season_number);
            this.linearLayout = (LinearLayout) itemView.findViewById(R.id.layout_season_item);
        }
    }
}
