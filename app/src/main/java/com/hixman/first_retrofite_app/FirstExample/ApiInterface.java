package com.hixman.first_retrofite_app.FirstExample;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    // here we get specific ressource
//    @GET("posts/1")
//    public Call<Post> getPost();

    // if we want to get a specific resource dynamically
    @GET("posts/{id}")
    public Call<Post> getPost(@Path("id") int postId);
}
