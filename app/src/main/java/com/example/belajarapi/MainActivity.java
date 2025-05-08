package com.example.belajarapi;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TeamAdapter adapter;
    private List<Team> teamList = new ArrayList<>();

    ProgressBar pbLoding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pbLoding = findViewById(R.id.pbLoding);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TeamAdapter(teamList);
        recyclerView.setAdapter(adapter);

        String url = getIntent().getStringExtra("LEAGUE_URL");
        TeamApi api = ApiClient.getClient().create(TeamApi.class);
        //api.getAllTeams("English Premier League").enqueue(new Callback<TeamResponse>() {
        api.getTeamsFromUrl(url).enqueue(new Callback<TeamResponse>(){

            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    teamList.addAll(response.body().getTeams());
                    adapter.notifyDataSetChanged();

                    recyclerView.setVisibility(View.GONE);

                }
                pbLoding.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Gagal ambil data", Toast.LENGTH_SHORT).show();
            }
   });
}
}