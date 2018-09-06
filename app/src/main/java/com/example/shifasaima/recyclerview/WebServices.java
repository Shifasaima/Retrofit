package com.example.shifasaima.recyclerview;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebServices{
    String BASE_URL = "https://simplifiedcoding.net/demos/";
    @GET("marvel")
    Call<List<Hero>> getValueFromServer();

}