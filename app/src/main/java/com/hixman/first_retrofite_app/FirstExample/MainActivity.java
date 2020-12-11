package com.hixman.first_retrofite_app.FirstExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hixman.first_retrofite_app.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // define the views in the activity
        TextView Post_title = findViewById(R.id.Post_title);
        Button  btn_go = findViewById(R.id.btn_go);

        // use Retrofit
        // create a retrofit builder
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<Post> call = apiInterface.getPost(1);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Post_title.setText(response.body().getTitle());

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Post_title.setText(t.getMessage());

            }
        });

        // use the btn to go to the mainActivity2
        btn_go.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent1 = new Intent("android.intent.action.MainActivity2");
                startActivity(intent1);
            }


        });








    }
}