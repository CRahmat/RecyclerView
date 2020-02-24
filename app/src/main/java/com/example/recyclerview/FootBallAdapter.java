package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FootBallAdapter extends RecyclerView.Adapter<FootBallAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivLogo;
        private TextView tvTeamName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivLogo = itemView.findViewById(R.id.logo);
            tvTeamName = itemView.findViewById(R.id.teamName);
        }
    }

    private Context context;
    private ArrayList<FootBallModel> footBallModels;

    public FootBallAdapter (Context context){
        this.context = context;
    }

    public ArrayList<FootBallModel> getFootBallModels(){
        return footBallModels;
    }

    public void setFootBallModels(ArrayList<FootBallModel> footBallModels){
        this.footBallModels = footBallModels;
    }
    @NonNull
    @Override
    public FootBallAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_football , viewGroup, false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull FootBallAdapter.ViewHolder viewHolder, int position) {
        Glide.with(context).load(getFootBallModels().get(position).getLogo()).into(viewHolder.ivLogo);
        viewHolder.tvTeamName.setText(getFootBallModels().get(position).getTeam_name());

    }

    @Override
    public int getItemCount() {
        return getFootBallModels().size();
    }

}
