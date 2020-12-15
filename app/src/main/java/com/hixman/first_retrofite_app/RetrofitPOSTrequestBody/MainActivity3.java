package com.hixman.first_retrofite_app.RetrofitPOSTrequestBody;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.hixman.first_retrofite_app.R;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // define the views in the activity
        TextView Post_title2 = findViewById(R.id.Post_title2);


        // use Retrofit
        // create a retrofit builder
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface3 apiInterface = retrofit.create(ApiInterface3.class);
        // when we want do a GET for fetch data
        Call<List<Post3>> call = apiInterface.getPost("2");
        call.enqueue(new Callback<List<Post3>>() {
            @Override
            public void onResponse(Call<List<Post3>> call, Response<List<Post3>> response) {
                Post_title2.setText(response.body().get(3).getTitle());
            }

            @Override
            public void onFailure(Call<List<Post3>> call, Throwable t) {
                Post_title2.setText(t.getMessage());
            }
        });
        /*// when we want do a POST for upload data using object
        // this is the post that we want upload to the server
        Post3 post = new Post3(1,"kingcoder","hi kids you still in that level");
        Call<Post3> call_1 = apiInterface.StorePost(post);
        call_1.enqueue(new Callback<Post3>() {
            @Override
            public void onResponse(Call<Post3> call, Response<Post3> response) {
                Post_title2.setText(response.body().getTitle());
            }

            @Override
            public void onFailure(Call<Post3> call, Throwable t) {

            }
        });*/

        // when we want do a POST for upload data using maps
        // this is the post that we want upload to the server
        HashMap<Object, Object> map = new HashMap<>();
        map.put("title","this is the man");
        map.put("body","how are you guys , how are you doing");
        map.put("userId","15");

        Call<Post3> call_1 = apiInterface.StorePost(map);
        call_1.enqueue(new Callback<Post3>() {
            @Override
            public void onResponse(Call<Post3> call, Response<Post3> response) {
                Post_title2.setText(response.body().getTitle());
            }

            @Override
            public void onFailure(Call<Post3> call, Throwable t) {

            }
        });
        // this is the post that we want upload to the server




    }
}