package com.example.restaurants.API;

import com.example.restaurants.APIBusinessId.RestaurantId;
import com.example.restaurants.APIBusinessSearch.Restaurant;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryName;

public interface APIInterface {

    @GET("/v3/businesses/search?")
    Observable<Restaurant> getRestaurants(@Query("location") String Location);

    @GET("/v3/businesses/{id}")
    Observable<RestaurantId> getRestaurantsId(@Path("id") String Id);

}
