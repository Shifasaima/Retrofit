   package com.example.shifasaima.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.util.SortedList;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Cache;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements SampleAdapter.onClickItem {

    List<Hero> heroList;
    private SampleAdapter sampleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView rec = (RecyclerView) findViewById(R.id.rv1);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(WebServices.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        WebServices api = retrofit.create(WebServices.class);

        Call<List<Hero>> serverCall = api.getValueFromServer();


        serverCall.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                heroList = response.body();
                sampleAdapter = new SampleAdapter(heroList,MainActivity.this,MainActivity.this);
                rec.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                rec.setAdapter(sampleAdapter);
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {

            }
        });

    }

    @Override
    public void onClickView(int position) {

    }
}
//this is test code
    