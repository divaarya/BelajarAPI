package com.example.belajarapi;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import com.example.belajarapi.TeamResponse;

public interface TeamApi {
    @GET("search_all_teams.php")
    Call<TeamResponse> getAllTeams(@Query("l") String league);

   @GET
  Call<TeamResponse> getAllTeamsFromUrl(@retrofit2.http.Url String Spain);

    Call<TeamResponse> getTeamsFromUrl(String url);
}
