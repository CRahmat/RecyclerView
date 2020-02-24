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

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivHeroesImage;
        private TextView tvHeroesName;
        private TextView tvHeroesDetails;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivHeroesImage = itemView.findViewById(R.id.heroesImage);
            tvHeroesName = itemView.findViewById(R.id.heroesName);
            tvHeroesDetails = itemView.findViewById(R.id.heroesDetails);
        }
    }

    private Context context;
    private ArrayList<HeroesModel> heroesModels;

    public HeroesAdapter(Context context){
        this.context = context;
    }

    public ArrayList<HeroesModel> getHeroesModels(){
        return heroesModels;
    }

    public void setHeroesModels(ArrayList<HeroesModel> heroesModels){
        this.heroesModels = heroesModels;
    }
    @NonNull
    @Override
    public HeroesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_heroes, viewGroup, false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroesAdapter.ViewHolder viewHolder, int position) {
        Glide.with(context).load(getHeroesModels().get(position).getHeroesImage()).into(viewHolder.ivHeroesImage);
        viewHolder.tvHeroesName.setText(getHeroesModels().get(position).getHeroesName());
        viewHolder.tvHeroesDetails.setText(getHeroesModels().get(position).getHeroesDetails());

    }

    @Override
    public int getItemCount() {
        return getHeroesModels().size();
    }

}
