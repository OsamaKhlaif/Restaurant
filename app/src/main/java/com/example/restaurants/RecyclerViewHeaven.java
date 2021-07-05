package com.example.restaurants;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewHeaven extends RecyclerView.ViewHolder {
    ImageView imageOfRestaurant;
    TextView descriptionOfRestaurant;

    public RecyclerViewHeaven(@NonNull  View itemView) {
        super(itemView);
        imageOfRestaurant=itemView.findViewById(R.id.image_of_restaurant);
        descriptionOfRestaurant=itemView.findViewById(R.id.description_of_restaurant);
    }
}
