package com.example.restaurants;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.restaurants.API.APIClient;
import com.example.restaurants.API.APIInterface;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mLinearLayout;
    private ImageButton search;
    private EditText placeEditTextSearch;
    private String place;
    private APIInterface apiInterface;
    RestaurantsAttributes restaurantsAttributes;
   //CustomRecyclerView customCostEffective;
   //CustomRecyclerView customBitPriceir;
   //CustomRecyclerView customBigSpender;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       //customCostEffective = findViewById(R.id.cost_effective);
       //customBitPriceir = findViewById(R.id.bit_pricier);
       //customBigSpender = findViewById(R.id.big_spender);



        search = findViewById(R.id.image_search);
        placeEditTextSearch = findViewById(R.id.place_edit_text_search);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                place = placeEditTextSearch.getText().toString();

                findRestaurants();

            }
        });




    }

    private void findRestaurants() {


        ///
        List<RestaurantsAttributes> restaurantsCostEffective = new ArrayList<>();
        List<RestaurantsAttributes> restaurantsBitPriceir = new ArrayList<>();
        List<RestaurantsAttributes> restaurantsBigSpender = new ArrayList<>();
        List<items> itemsList=new ArrayList<>();

        apiInterface = APIClient.getClient().create(APIInterface.class);


        Observable<Restaurant> apiCall = apiInterface.getRestaurants(place)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());


        apiCall.subscribe(new Observer<Restaurant>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Restaurant restaurant) {


                int position = 0;

                int numberOfPrice;


                while (position < restaurant.getBusinesses().size()) {

                    if (restaurant.getBusinesses().get(position).getPrice() != null) {
                        numberOfPrice = restaurant.getBusinesses().get(position).getPrice().length();
                    } else {
                        numberOfPrice = 1;
                    }


                    if (numberOfPrice == 1) {
                        restaurantsAttributes = new RestaurantsAttributes(restaurant.getBusinesses().get(position).getName(), restaurant.getBusinesses().get(position).getReviewCount(),
                                restaurant.getBusinesses().get(position).getRating(), restaurant.getBusinesses().get(position).getImageUrl());

                        restaurantsCostEffective.add(restaurantsAttributes);


                    } else if (numberOfPrice == 2) {
                        restaurantsAttributes = new RestaurantsAttributes(restaurant.getBusinesses().get(position).getName(), restaurant.getBusinesses().get(position).getReviewCount(),
                                restaurant.getBusinesses().get(position).getRating(), restaurant.getBusinesses().get(position).getImageUrl());

                        restaurantsBitPriceir.add(restaurantsAttributes);


                    } else if (numberOfPrice == 3) {

                        restaurantsAttributes = new RestaurantsAttributes(restaurant.getBusinesses().get(position).getName(), restaurant.getBusinesses().get(position).getReviewCount(),
                                restaurant.getBusinesses().get(position).getRating(), restaurant.getBusinesses().get(position).getImageUrl());

                        restaurantsBigSpender.add(restaurantsAttributes);




                    }
                    position++;
                }
                itemsList.add(new items("Cost Effective",restaurantsCostEffective));
                itemsList.add(new items("Bit Pricier",restaurantsBitPriceir));
                itemsList.add(new items("Big Spender",restaurantsBigSpender));

                if (restaurant.getBusinesses().size() != 0) {
                    Toast.makeText(MainActivity.this, restaurant.getBusinesses().get(0).getLocation().getCity(), Toast.LENGTH_SHORT).show();

                    GridView gridView =findViewById(R.id.grid_view_home_screen);
                    CustomAdapter customAdapter= new CustomAdapter(MainActivity.this,R.layout.custom_recycler_view,itemsList);
                    gridView.setAdapter(customAdapter);

                } else {

                    Toast.makeText(MainActivity.this, "This " + place + " not have any registrar restaurant", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(MainActivity.this, "Enter the correct City Or this application doesn't cover this City", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {

            }
        });


    }
}