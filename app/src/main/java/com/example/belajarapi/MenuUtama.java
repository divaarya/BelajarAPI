package com.example.belajarapi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MenuUtama extends AppCompatActivity {
    Button btnPremier;
    Button btnLaLiga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);
        Button btnPremier = findViewById(R.id.btnPremier);

        btnPremier = findViewById(R.id.btnPremier);
        btnLaLiga = findViewById(R.id.btnLaLiga);


        btnPremier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuUtama.this, MainActivity.class);
                intent.putExtra("LEAGUE_URL", "https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?l=English%20Premier%20League");
                startActivity(intent);
            }
        });

        Button btnLaLiga = findViewById(R.id.btnLaLiga);
        btnLaLiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuUtama.this, MainActivity.class);
                intent.putExtra("LEAGUE_URL", "https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?l=Spanish%20La%20Liga");
                startActivity(intent);
            }
        });
}
}