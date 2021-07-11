package com.example.restaurants.ViewPager;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurants.R;
import com.makeramen.roundedimageview.RoundedImageView;

public class ViewPagerViewHeaven extends RecyclerView.ViewHolder {

    RoundedImageView roundedImageView;

    public ViewPagerViewHeaven(@NonNull @io.reactivex.annotations.NonNull View itemView) {
        super(itemView);

        roundedImageView = itemView.findViewById(R.id.rounded_image_view);
    }
}
