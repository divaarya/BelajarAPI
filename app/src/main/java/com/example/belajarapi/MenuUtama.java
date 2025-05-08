package com.example.belajarapi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MenuUtama extends AppCompatActivity {
    Button btnPremier, btnLaLiga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);

        btnPremier = findViewById(R.id.btnPremier);
        btnLaLiga = findViewById(R.id.btnLaLiga);

        btnPremier.setOnClickListener(v -> {
            Intent intent = new Intent(MenuUtama.this, MainActivity.class);
            intent.putExtra("LEAGUE_URL", "https://www.thesportsdb.com/api/v1/json/3/search_all_teams.php?l=English Premier League");
            startActivity(intent);
        });

        btnLaLiga.setOnClickListener(v -> {
            Intent intent = new Intent(MenuUtama.this, MainActivity.class);
            intent.putExtra("LEAGUE_URL", "https://www.thesportsdb.com/api/v1/json/3/search_all_teams.php?s=Soccer&c=Spain");
            startActivity(intent);
   });
}
}