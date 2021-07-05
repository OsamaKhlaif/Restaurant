package com.example.restaurants;

public class RestaurantsAttributes {
    private String name;
    private long review;
    private double rating;
    private String image;

    public RestaurantsAttributes(String name, long review, double rating, String image) {
        this.name = name;
        this.review = review;
        this.rating = rating;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getReview() {
        return review;
    }

    public void setReview(long review) {
        this.review = review;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
