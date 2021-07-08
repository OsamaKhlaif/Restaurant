package com.example.restaurants.ViewPager;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.restaurants.R;
import com.makeramen.roundedimageview.RoundedImageView;

public class ViewPagerViewHeaven extends RecyclerView.ViewHolder {

    RoundedImageView imageView;

    public ViewPagerViewHeaven(@NonNull @io.reactivex.annotations.NonNull View itemView) {
        super(itemView);

        imageView=itemView.findViewById(R.id.imageSlide);
    }
}
