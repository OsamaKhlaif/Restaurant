package com.example.restaurants;

import java.util.List;

public class Items {

    private String titleText;
    private List<RestaurantsSearchAttributes> restaurantsTypeAttributes;

    public Items(String titleText, List<RestaurantsSearchAttributes> restaurantsTypeAttributes) {
        this.titleText = titleText;
        this.restaurantsTypeAttributes = restaurantsTypeAttributes;
    }

    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }

    public List<RestaurantsSearchAttributes> getRestaurantsTypeAttributes() {
        return restaurantsTypeAttributes;
    }

    public void setRestaurantsTypeAttributes(List<RestaurantsSearchAttributes> restaurantsTypeAttributes) {
        this.restaurantsTypeAttributes = restaurantsTypeAttributes;
    }
}
