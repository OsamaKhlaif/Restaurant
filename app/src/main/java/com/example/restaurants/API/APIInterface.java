package com.example.restaurants.API;

import com.example.restaurants.Restaurant;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("/v3/businesses/search?")
    Observable<Restaurant> getRestaurants(@Query("location") String Location);

}
