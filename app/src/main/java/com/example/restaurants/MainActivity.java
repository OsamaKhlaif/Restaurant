package com.example.restaurants;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.example.restaurants.API.APIClient;
import com.example.restaurants.API.APIInterface;
import com.example.restaurants.APIBusinessSearch.Restaurant;
import com.example.restaurants.RecyclerView.RecyclerAdapter;
import java.util.ArrayList;
import java.util.List;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private ImageButton search;
    private EditText placeEditTextSearch;
    private String place;
    private APIInterface apiInterface;
    private RestaurantsSearchAttributes restaurantsAttributes;
    private final String TAG = MainActivity.class.getSimpleName();
    private List<RestaurantsSearchAttributes> restaurantsCostEffective;
    private List<RestaurantsSearchAttributes> restaurantsBitPricier;
    private List<RestaurantsSearchAttributes> restaurantsBigSpender;
    private RecyclerAdapter.RecyclerViewClickListener listener;
    private RecyclerAdapter recyclerAdapter;
    private Items item;
    private LinearLayout linearLayoutHomeScreen;
    private CustomRecyclerView customComponentsOfRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayoutHomeScreen = findViewById(R.id.linear_layout_home_screen);
        search = findViewById(R.id.image_search);
        placeEditTextSearch = findViewById(R.id.place_edit_text_search);
        search.setOnClickListener(v -> {
            place = placeEditTextSearch.getText().toString();
            linearLayoutHomeScreen.removeAllViews();
            findRestaurants();

        });
    }

    private void findRestaurants() {

        restaurantsCostEffective = new ArrayList<>();
        restaurantsBitPricier = new ArrayList<>();
        restaurantsBigSpender = new ArrayList<>();
        apiInterface = APIClient.getClient().create(APIInterface.class);

        Observable<Restaurant> apiCall = apiInterface.getRestaurants(place)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        apiCall.subscribe(new Observer<Restaurant>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d(TAG, "Start the subscribe");
            }

            @Override
            public void onNext(@NonNull Restaurant restaurant) {

                int position = 0;
                int numberOfPrice;

                while (position < restaurant.getBusinesses().size()) {
                    if (restaurant.getBusinesses().get(position).getPrice() != null) {
                        numberOfPrice = restaurant.getBusinesses().get(position).getPrice().length();
                    } else {
                        numberOfPrice = 1;
                    }

                    if (numberOfPrice == 1) {
                        restaurantsCostEffective.add(restaurantsAttributes(restaurant, position));
                    } else if (numberOfPrice == 2) {
                        restaurantsBitPricier.add(restaurantsAttributes(restaurant, position));
                    } else if (numberOfPrice == 3) {
                        restaurantsBigSpender.add(restaurantsAttributes(restaurant, position));
                    }
                    position++;
                }

                if (restaurant.getBusinesses().size() != 0) {
                    addCustomComponents("Cost Effective", restaurantsCostEffective);
                    addCustomComponents("Bit Pricier", restaurantsBitPricier);
                    addCustomComponents("Bit Pricier", restaurantsBigSpender);
                } else {
                    Toast.makeText(MainActivity.this, "This " + place + " not have any registrar restaurant", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onError(@NonNull Throwable e) {

                boolean connected = false;
                ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                        connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                    //we are connected to a network
                    connected = true;
                } else {
                    connected = false;
                }

                if (connected == false) {
                    Toast.makeText(MainActivity.this, "The Internet connection failed", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Enter the correct City Or this application doesn't cover this City", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "Finish the Process");
            }
        });

    }

    public RestaurantsSearchAttributes restaurantsAttributes(Restaurant restaurant, int position) {

        restaurantsAttributes = new RestaurantsSearchAttributes(restaurant.getBusinesses().get(position).getName(),
                restaurant.getBusinesses().get(position).getReviewCount(), restaurant.getBusinesses().get(position).getRating(),
                restaurant.getBusinesses().get(position).getImageUrl(), restaurant.getBusinesses().get(position).getDisplayPhone(),
                restaurant.getBusinesses().get(position).getLocation().getZipCode(),
                restaurant.getBusinesses().get(position).getLocation().getDisplayAddress(),
                restaurant.getBusinesses().get(position).getPhone(), restaurant.getBusinesses().get(position).getId());

        return restaurantsAttributes;
    }

    public void addCustomComponents(String title, List<RestaurantsSearchAttributes> restaurantsAttributes) {
        item = new Items(title, restaurantsAttributes);
        setOnClickListener(item);
        recyclerAdapter = new RecyclerAdapter(MainActivity.this, item.getTypeOfRestaurants(), listener);
        customComponentsOfRecyclerView = new CustomRecyclerView(MainActivity.this);
        customComponentsOfRecyclerView.title.setText(item.getTextTitle());
        customComponentsOfRecyclerView.recyclerView.setAdapter(recyclerAdapter);
        linearLayoutHomeScreen.addView(customComponentsOfRecyclerView);
    }

    private void setOnClickListener(Items item) {
        listener = (v, position) -> {

            Intent intent = new Intent(getApplicationContext(), DetailsOfRestaurants.class);
            RestaurantsSearchAttributes restaurantsAttributes = new RestaurantsSearchAttributes(
                    item.getTypeOfRestaurants().get(position).getName(),
                    item.getTypeOfRestaurants().get(position).getReview(),
                    item.getTypeOfRestaurants().get(position).getRating(),
                    item.getTypeOfRestaurants().get(position).getImage(),
                    item.getTypeOfRestaurants().get(position).getDisplayPhone(),
                    item.getTypeOfRestaurants().get(position).getZipCode(),
                    item.getTypeOfRestaurants().get(position).getAddress(),
                    item.getTypeOfRestaurants().get(position).getPhone(),
                    item.getTypeOfRestaurants().get(position).getId());
            intent.putExtra("details", restaurantsAttributes);
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,
                    customComponentsOfRecyclerView.recyclerView, "recycler_view");
            startActivity(intent, optionsCompat.toBundle());

        };
    }

}