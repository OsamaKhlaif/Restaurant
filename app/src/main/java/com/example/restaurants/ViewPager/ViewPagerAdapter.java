package com.example.restaurants.ViewPager;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurants.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerViewHeaven> {

    private Context context;
    private List<String> restaurantsImage;

    public ViewPagerAdapter(Context context, List<String> restaurantsImage) {
        this.context = context;
        this.restaurantsImage = restaurantsImage;
    }

    @NonNull
    @Override
    public ViewPagerViewHeaven onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_item, parent, false);
        return new ViewPagerViewHeaven(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerViewHeaven holder, int position) {
        Picasso.with(context).load(Uri.parse(restaurantsImage.get(position))).into(holder.roundedImageView);
    }

    @Override
    public int getItemCount() {
        return restaurantsImage.size();
    }
}
