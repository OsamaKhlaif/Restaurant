package com.example.restaurants.RecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurants.R;

public class RecyclerViewHeaven extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView restaurantsImageView;
    TextView restaurantsDescriptionTextView;
    private RecyclerAdapter.RecyclerViewClickListener listener;

    public RecyclerViewHeaven(@NonNull View itemView, RecyclerAdapter.RecyclerViewClickListener listener) {
        super(itemView);

        restaurantsImageView = itemView.findViewById(R.id.restaurants_image_view);
        restaurantsDescriptionTextView = itemView.findViewById(R.id.restaurants_description_text_view);
        itemView.setOnClickListener(this);
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        listener.onClick(v, getAdapterPosition());
    }
}
