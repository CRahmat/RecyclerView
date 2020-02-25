package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivHeroesImage;
        private TextView tvHeroesName;
        private TextView tvHeroesDetails;
        private Button bttnSee;
        private Button btnShare;
        private ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivHeroesImage = itemView.findViewById(R.id.heroesImage);
            tvHeroesName = itemView.findViewById(R.id.heroesName);
            tvHeroesDetails = itemView.findViewById(R.id.heroesDetails);
            bttnSee = itemView.findViewById(R.id.btn_see);
            btnShare = itemView.findViewById(R.id.btn_share);
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
    public void onBindViewHolder(@NonNull HeroesAdapter.ViewHolder viewHolder, final int position) {
        Glide.with(context).load(getHeroesModels().get(position).getHeroesImage()).into(viewHolder.ivHeroesImage);
        viewHolder.tvHeroesName.setText(getHeroesModels().get(position).getHeroesName());
        viewHolder.tvHeroesDetails.setText(getHeroesModels().get(position).getHeroesDetails());
        viewHolder.ivHeroesImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Toast.makeText(context, "Heroes Name : " + getHeroesModels().get(position).getHeroesName(), Toast.LENGTH_SHORT).show();
            }
        });

        viewHolder.bttnSee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, HeroeDetails.class);
                intent.putExtra("img_url",getHeroesModels().get(position).getHeroesImage());
                intent.putExtra("heroes_name",getHeroesModels().get(position).getHeroesName());
                intent.putExtra("heroes_details",getHeroesModels().get(position).getHeroesDetails());
                context.startActivity(intent);
            }

        });
        viewHolder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String heroesDetails = "Hello saya ingin memberi kamu informasi tentang PAHLAWAN DI INDONESIA \n Nama Pahlawan : " + getHeroesModels().get(position).getHeroesName() +"\n" + getHeroesModels().get(position).getHeroesDetails();
                intent.putExtra(Intent.EXTRA_TEXT, heroesDetails);
                context.startActivity(Intent.createChooser(intent, "Share To "));
            }
        });

    }

    @Override
    public int getItemCount() {
        return getHeroesModels().size();
    }

}
