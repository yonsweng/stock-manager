package com.yeonung.stocker;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MyAPI {
    @GET("/")
    Call<Item> get(@Query("id") int id);

    @POST("/")
    Call<Object> post(Item item);
}
