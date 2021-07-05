package com.example.restaurants.API;

import com.example.restaurants.Restaurant;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface APIInterface {

    @GET("/v3/businesses/search?")
    Observable<Restaurant> getRestaurants(@Query("location") String Location);

}
