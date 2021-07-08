package com.example.restaurants;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
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
    private List<items> itemsList;
    private RecyclerAdapter.RecyclerViewClickListener listener;
    private CustomAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search = findViewById(R.id.image_search);
        placeEditTextSearch = findViewById(R.id.place_edit_text_search);
        search.setOnClickListener(v -> {
            place = placeEditTextSearch.getText().toString();
            findRestaurants();
        });
    }

    private void findRestaurants() {

        itemsList = new ArrayList<>();
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
                itemsList.add(new items("Cost Effective", restaurantsCostEffective));
                itemsList.add(new items("Bit Pricier", restaurantsBitPricier));
                itemsList.add(new items("Big Spender", restaurantsBigSpender));

                if (restaurant.getBusinesses().size() != 0) {
                    Toast.makeText(MainActivity.this, restaurant.getBusinesses().get(0).getLocation().getCity(), Toast.LENGTH_SHORT).show();
                    GridView gridView = findViewById(R.id.grid_view_home_screen);
                    customAdapter = new CustomAdapter(MainActivity.this, R.layout.custom_recycler_view, itemsList, listener);
                    gridView.setAdapter(customAdapter);

                } else {
                    Toast.makeText(MainActivity.this, "This " + place + " not have any registrar restaurant", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onError(@NonNull Throwable e) {
                Toast.makeText(MainActivity.this, "Enter the correct City Or this application doesn't cover this City", Toast.LENGTH_SHORT).show();
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
                restaurant.getBusinesses().get(position).getLocation().getZipCode(), restaurant.getBusinesses().get(position).getLocation().getDisplayAddress(),
                restaurant.getBusinesses().get(position).getPhone(), restaurant.getBusinesses().get(position).getId());

        return restaurantsAttributes;
    }


    /** Custom Adapter Class */
    public class CustomAdapter extends ArrayAdapter<items> {

        private List<items> itemsList;
        private int customLayoutId;
        private TextView title;
        private RecyclerView recyclerView;
        private items item;
        private RecyclerAdapter.RecyclerViewClickListener listener;
        private RecyclerAdapter recyclerAdapter;
        private Context context;

        public CustomAdapter(@androidx.annotation.NonNull Context context, int resource, @androidx.annotation.NonNull List<items> itemsList, RecyclerAdapter.RecyclerViewClickListener listener) {
            super(context, resource, itemsList);
            this.itemsList = itemsList;
            customLayoutId = resource;
            this.listener = listener;
            this.context = context;

        }

        @Override
        public int getCount() {
            return itemsList.size();
        }

        @androidx.annotation.NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @androidx.annotation.NonNull ViewGroup parent) {

            View view = convertView;

            if (view == null) {
                LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = layoutInflater.inflate(customLayoutId, null);
            }

            title = view.findViewById(R.id.title_text_view);
            recyclerView = view.findViewById(R.id.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
            item = itemsList.get(position);
            title.setText(item.getTextTitle());
            setOnClickListener(position);
            recyclerAdapter = new RecyclerAdapter(getContext().getApplicationContext(), item.getTypeOfRestaurants(), listener);
            recyclerView.setAdapter(recyclerAdapter);

            return view;
        }


        private void setOnClickListener(int positionRecyclerView) {
            listener = (v, position) -> {

                Intent intent = new Intent(getContext().getApplicationContext(), DetailsOfRestaurants.class);
                RestaurantsSearchAttributes restaurantsAttributes = new RestaurantsSearchAttributes(
                        itemsList.get(positionRecyclerView).getTypeOfRestaurants().get(position).getName(),
                        itemsList.get(positionRecyclerView).getTypeOfRestaurants().get(position).getReview(),
                        itemsList.get(positionRecyclerView).getTypeOfRestaurants().get(position).getRating(),
                        itemsList.get(positionRecyclerView).getTypeOfRestaurants().get(position).getImage(),
                        itemsList.get(positionRecyclerView).getTypeOfRestaurants().get(position).getDisplayPhone(),
                        itemsList.get(positionRecyclerView).getTypeOfRestaurants().get(position).getZipCode(),
                        itemsList.get(positionRecyclerView).getTypeOfRestaurants().get(position).getAddress(),
                        itemsList.get(positionRecyclerView).getTypeOfRestaurants().get(position).getPhone(),
                        itemsList.get(positionRecyclerView).getTypeOfRestaurants().get(position).getId());

                intent.putExtra("details", restaurantsAttributes);
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, recyclerView, "recycler_view");
                getContext().startActivity(intent, optionsCompat.toBundle());


            };
        }


    }


}