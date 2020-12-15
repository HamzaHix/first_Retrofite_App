package com.hixman.first_retrofite_app.RetrofitPOSTrequestBody;

import com.hixman.first_retrofite_app.GETRequestQUERYandPATH.Post2;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface3 {

    /**
     * GET("our resource") ==>example:  https://jsonplaceholder.typicode.com/posts  >> posts is our resource
     * Call< what we will return from our resource >
     * StorePost: inside this method we set our Post Body if it's a map or an object
     * */
    @GET("posts")
    public Call<List<Post3>> getPost(@Query("userId") String userId);

    // if we use object
    /*@POST("posts")
    public Call<Post3> StorePost(@Body Post3 post);*/

    // if we use maps
    @POST("posts")
    public Call<Post3> StorePost(@Body HashMap<Object,Object> map);
}
