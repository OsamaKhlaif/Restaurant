package com.example.restaurants;

import java.util.List;

public class Items {

    private String textTitle;
    private List<RestaurantsSearchAttributes> typeOfRestaurants;

    public Items(String textTitle, List<RestaurantsSearchAttributes> typeOfRestaurants) {
        this.textTitle = textTitle;
        this.typeOfRestaurants = typeOfRestaurants;
    }

    public String getTextTitle() {
        return textTitle;
    }

    public void setTextTitle(String textTitle) {
        this.textTitle = textTitle;
    }

    public List<RestaurantsSearchAttributes> getTypeOfRestaurants() {
        return typeOfRestaurants;
    }

    public void setTypeOfRestaurants(List<RestaurantsSearchAttributes> typeOfRestaurants) {
        this.typeOfRestaurants = typeOfRestaurants;
    }
}
