package com.example.restaurants;

import java.util.List;

public class items {

    private String textTitle;
    private List<RestaurantsAttributes> typeOfRestaurants;

    public items(String textTitle, List<RestaurantsAttributes> typeOfRestaurants) {
        this.textTitle = textTitle;
        this.typeOfRestaurants = typeOfRestaurants;
    }

    public String getTextTitle() {
        return textTitle;
    }

    public void setTextTitle(String textTitle) {
        this.textTitle = textTitle;
    }

    public List<RestaurantsAttributes> getTypeOfRestaurants() {
        return typeOfRestaurants;
    }

    public void setTypeOfRestaurants(List<RestaurantsAttributes> typeOfRestaurants) {
        this.typeOfRestaurants = typeOfRestaurants;
    }
}
