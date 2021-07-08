package com.example.restaurants.RecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurants.R;
import com.example.restaurants.RecyclerView.RecyclerAdapter;

public class RecyclerViewHeaven extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView imageOfRestaurant;
    TextView descriptionOfRestaurant;
    private RecyclerAdapter.RecyclerViewClickListener listener;

    public RecyclerViewHeaven(@NonNull View itemView, RecyclerAdapter.RecyclerViewClickListener listener) {
        super(itemView);

        imageOfRestaurant = itemView.findViewById(R.id.image_of_restaurant);
        descriptionOfRestaurant = itemView.findViewById(R.id.description_of_restaurant);
        itemView.setOnClickListener(this);
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        listener.onClick(v, getAdapterPosition());
    }
}
