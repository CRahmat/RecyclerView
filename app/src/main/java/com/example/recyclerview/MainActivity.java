package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvHeroes;
    private ArrayList<HeroesModel> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHeroes = findViewById(R.id.rv_heroesList);
        rvHeroes.setHasFixedSize(true);
        list.addAll(HeroesData.getHeroList());

        showRecyclerList();
    }

    private void showRecyclerList() {
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        HeroesAdapter footBallAdapter = new HeroesAdapter(this);
        footBallAdapter.setHeroesModels(list);
        rvHeroes.setAdapter(footBallAdapter);

    }
}
