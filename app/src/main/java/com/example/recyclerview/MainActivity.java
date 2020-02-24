package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvTeam;
    private ArrayList<FootBallModel> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvTeam = findViewById(R.id.rv_team_list);
        rvTeam.setHasFixedSize(true);
        list.addAll(FootBallData.getListData());

        showRecyclerList();
    }

    private void showRecyclerList() {
        rvTeam.setLayoutManager(new LinearLayoutManager(this));
        FootBallAdapter footBallAdapter = new FootBallAdapter(this);
        footBallAdapter.setFootBallModels(list);
        rvTeam.setAdapter(footBallAdapter);
    }
}
