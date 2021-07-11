package com.example.restaurants;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CustomRecyclerView extends LinearLayout {

    TextView titleTextView;
    RecyclerView recyclerView;

    public CustomRecyclerView(Context context) {
        super(context);
        init(context, null);
    }

    public CustomRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public void init(Context context, AttributeSet attrs) {
        inflate(context, R.layout.custom_recycler_view, this);
        titleTextView = findViewById(R.id.title_text_view);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
    }


}
