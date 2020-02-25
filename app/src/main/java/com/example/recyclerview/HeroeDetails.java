package com.example.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class HeroeDetails extends AppCompatActivity {
    private ImageView ivHeroesImageDetails;
    private TextView tvHeroesNameDetails;
    private TextView tvHeroesDetailDetails;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.heroe_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ivHeroesImageDetails = findViewById(R.id.heroes_image_details);
        tvHeroesNameDetails = findViewById(R.id.heroes_name_details);
        tvHeroesDetailDetails = findViewById(R.id.heroes_details_details);

        getIncomingIntent();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void getIncomingIntent() {
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            int heroesImage = bundle.getInt("img_url");
            Glide.with(getApplicationContext()).load(heroesImage).into(ivHeroesImageDetails);
            String getDetails = bundle.getString("heroes_details");
            String getTitle = bundle.getString("heroes_name");
            tvHeroesDetailDetails.setText(getDetails);
            tvHeroesNameDetails.setText(getTitle);
        }
    }

}
