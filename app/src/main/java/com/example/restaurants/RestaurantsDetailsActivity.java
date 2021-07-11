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

public class RestaurantsDetailsActivity extends AppCompatActivity {

    private TextView restaurantsName;
    private RestaurantsSearchAttributes restaurantsAttributes;
    private TextView restaurantsPhone;
    private TextView restaurantsAddress;
    private ImageButton restaurantsCallButton;
    private APIInterface apiInterface;
    private static final String TAG = RestaurantsDetailsActivity.class.getSimpleName();
    private List<String> restaurantImage;
    private ViewPager2 imageViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_of_resturants);

        restaurantImage = new ArrayList<>();
        restaurantsName = findViewById(R.id.restaurants_name_text_view);
        restaurantsPhone = findViewById(R.id.restaurants_phone_text_view);
        restaurantsAddress = findViewById(R.id.restaurants_address_text_view);
        restaurantsCallButton = findViewById(R.id.restaurants_call_button);
        imageViewPager = findViewById(R.id.restaurants_images_view_pager);

        Intent intent = getIntent();
        restaurantsAttributes = intent.getParcelableExtra("details");
        findInformationOfRestaurants();
        // when the user click in call button to call the restaurants
        restaurantsCallButton.setOnClickListener(v -> {
            Intent intentCall = new Intent(Intent.ACTION_DIAL);
            intentCall.setData(Uri.parse("tel:" + restaurantsAttributes.getRestaurantsPhoneCall()));
            startActivity(intentCall);
        });
    }

    private void findInformationOfRestaurants() {

        apiInterface = APIClient.getClient().create(APIInterface.class);
        Observable<RestaurantId> apiCallId = apiInterface.getRestaurantsId(restaurantsAttributes.getRestaurantsId())
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
                    restaurantImage.add(restaurantId.getPhotos().get(position));
                }
                restaurantsName.setText("\nName: " + restaurantsAttributes.getPlaceName()
                        + "\n\nRating: " + restaurantsAttributes.getRestaurantsRating()
                        + " Stars\n\nReview: " + restaurantsAttributes.getRestaurantsReview());
                restaurantsPhone.setText("\nPhone: " + restaurantsAttributes.getRestaurantsDisplayPhone());
                restaurantsAddress.setText("\nZip Code: " + restaurantsAttributes.getRestaurantsZipCode()
                        + "\n\nAddress: " + displayArray(restaurantsAttributes.getRestaurantsAddress())
                        + "\n\nStatus: " + ((restaurantId.getHours() == null) ? "--------" :
                        (restaurantId.getHours().get(0).getIsOpenNow().equals(true) ? "Open Now" : "Close Now")) + "\n\n");
                //this command to check if the hours is null or no.
                ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(RestaurantsDetailsActivity.this, restaurantImage);
                imageViewPager.setAdapter(viewPagerAdapter);
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