package com.example.restaurants;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.restaurants.API.APIClient;
import com.example.restaurants.API.APIInterface;
import com.example.restaurants.APIBusinessId.RestaurantId;
import com.example.restaurants.ViewPager.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DetailsOfRestaurants extends AppCompatActivity {


    private TextView nameOfRestaurants;
    private RestaurantsSearchAttributes restaurantsAttributes;
    private TextView phoneOfRestaurants;
    private TextView addressOfRestaurants;
    private ImageButton callRestaurants;
    private APIInterface apiInterface;
    private final String TAG = DetailsOfRestaurants.class.getSimpleName();
    private List<String> imageOfRestaurant;
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_of_resturants);

        imageOfRestaurant = new ArrayList<>();
        nameOfRestaurants = findViewById(R.id.text_name_of_restaurants);
        phoneOfRestaurants = findViewById(R.id.text_phone_of_restaurants);
        addressOfRestaurants = findViewById(R.id.text_address_of_restaurants);
        callRestaurants = findViewById(R.id.call_restaurants);
        viewPager = findViewById(R.id.view_pager_of_image_of_details_of_restaurant);

        Intent intent = getIntent();
        restaurantsAttributes = intent.getParcelableExtra("details");
        findInformationOfRestaurants();
        // when the user click in call button to call the restaurants
        callRestaurants.setOnClickListener(v -> {
            Intent intentCall = new Intent(Intent.ACTION_DIAL);
            intentCall.setData(Uri.parse("tel:" + restaurantsAttributes.getPhone()));
            startActivity(intentCall);
        });
    }

    private void findInformationOfRestaurants() {

        apiInterface = APIClient.getClient().create(APIInterface.class);
        Observable<RestaurantId> apiCallId = apiInterface.getRestaurantsId(restaurantsAttributes.getId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        apiCallId.subscribe(new Observer<RestaurantId>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d(TAG, "Start the subscribe");
            }

            @Override
            public void onNext(@NonNull RestaurantId restaurantId) {
                for (int position = 0; position < restaurantId.getPhotos().size(); position++) {
                    imageOfRestaurant.add(restaurantId.getPhotos().get(position));
                }
                nameOfRestaurants.setText("\nName: " + restaurantsAttributes.getName()
                        + "\n\nRating: " + restaurantsAttributes.getRating()
                        + " Stars\n\nReview: " + restaurantsAttributes.getReview());
                phoneOfRestaurants.setText("\nPhone: " + restaurantsAttributes.getDisplayPhone());
                addressOfRestaurants.setText("\nZip Code: " + restaurantsAttributes.getZipCode()
                        + "\n\nAddress: " + displayArray(restaurantsAttributes.getAddress())
                        + "\n\nStatus: " + ((restaurantId.getHours() == null) ? "--------" :
                        (restaurantId.getHours().get(0).getIsOpenNow().equals(true) ? "Open Now" : "Close Now")) + "\n\n");
                //this command to check if the hours is null or no.
                ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(DetailsOfRestaurants.this, imageOfRestaurant);
                viewPager.setAdapter(viewPagerAdapter);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "Occur any Error");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "Finish the Process");
            }
        });
    }

    public String displayArray(List<String> data) {
        StringBuilder dataArray = new StringBuilder();
        for (int position = 0; position < data.size(); position++) {
            if (position != data.size() - 1) {
                dataArray.append(data.get(position));
                // to do the address above each other
                dataArray.append(",\n" + "                 ");
            } else {
                dataArray.append(data.get(position));
            }
        }
        return dataArray.toString();
    }
}