package com.hixman.first_retrofite_app.GETRequestQUERYandPATH;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import com.hixman.first_retrofite_app.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // define the views in the activity
        TextView Post_title1 = findViewById(R.id.Post_title1);

        // use Retrofit
        // create a retrofit builder
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface2 apiInterface = retrofit.create(ApiInterface2.class);

        Call<List<Post2>> call = apiInterface.getPost("2");
        call.enqueue(new Callback<List<Post2>>() {
            @Override
            public void onResponse(Call<List<Post2>> call, Response<List<Post2>> response) {
                Post_title1.setText(response.body().get(3).getTitle());
            }

            @Override
            public void onFailure(Call<List<Post2>> call, Throwable t) {
                Post_title1.setText(t.getMessage());
            }
        });


    }
}