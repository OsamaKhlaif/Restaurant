package com.example.restaurants;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<items> {

    List<items> itemsList;
    int customLayoutId;
    TextView title;
    RecyclerView recyclerView;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<items> itemsList) {
        super(context, resource, itemsList);
        this.itemsList = itemsList;
        customLayoutId = resource;

    }

    @Override
    public int getCount() {
        return itemsList.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(customLayoutId, null);
        }

        title = view.findViewById(R.id.title_text_view);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        items item = itemsList.get(position);
        title.setText(item.getTextTitle());
        RecyclerAdapter myAdapter = new RecyclerAdapter(getContext().getApplicationContext(), item.getTypeOfRestaurants());
        recyclerView.setAdapter(myAdapter);

        return view;
    }
}
