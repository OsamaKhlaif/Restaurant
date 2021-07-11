package com.example.restaurants.RecyclerView;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.restaurants.R;
import com.example.restaurants.RestaurantsSearchAttributes;
import com.squareup.picasso.Picasso;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHeaven> {

    Context context;
    List<RestaurantsSearchAttributes> restaurants;
    private final RecyclerViewClickListener listener;

    public RecyclerAdapter(Context context, List<RestaurantsSearchAttributes> restaurants, RecyclerViewClickListener listener) {
        this.context = context;
        this.restaurants = restaurants;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerViewHeaven onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_view, parent, false);
        return new RecyclerViewHeaven(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHeaven holder, int position) {
        Picasso.with(context).load(Uri.parse(restaurants.get(position).getImage())).into(holder.imageOfRestaurant);
        holder.descriptionOfRestaurant.setText(restaurants.get(position).getName()
                + "\n" + restaurants.get(position).getRating() + " Stars, Reviews "
                + restaurants.get(position).getReview());
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }


    public interface RecyclerViewClickListener {
        void onClick(View v, int position);
    }

}
