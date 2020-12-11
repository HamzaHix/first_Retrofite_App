package com.hixman.first_retrofite_app.GETRequestQUERYandPATH;

import com.hixman.first_retrofite_app.FirstExample.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface2 {

    /**
     * GET("our resource") ==>example:  https://jsonplaceholder.typicode.com/posts  >> posts is our resource
     * Call< what we will return from our resource >
     * */
    @GET("posts")
    public Call<List<Post2>> getPost(@Query("userId") String userId);
}
