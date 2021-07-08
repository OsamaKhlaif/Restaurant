package com.example.restaurants;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class RestaurantsSearchAttributes implements Parcelable {

    private String name;
    private long review;
    private double rating;
    private String image;
    private String displayPhone;
    private String zipCode;
    private List<String> address;
    private String id;
    private String phone;

    public RestaurantsSearchAttributes(String name, long review, double rating, String image, String displayPhone, String zipCode, List<String> address, String phone, String id) {
        this.name = name;
        this.review = review;
        this.rating = rating;
        this.image = image;
        this.displayPhone = displayPhone;
        this.zipCode = zipCode;
        this.address = address;
        this.phone = phone;
        this.id = id;
    }

    protected RestaurantsSearchAttributes(Parcel in) {
        name = in.readString();
        review = in.readLong();
        rating = in.readDouble();
        image = in.readString();
        displayPhone = in.readString();
        zipCode = in.readString();
        phone = in.readString();
        address = in.createStringArrayList();
        id = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeLong(review);
        dest.writeDouble(rating);
        dest.writeString(image);
        dest.writeString(displayPhone);
        dest.writeString(zipCode);
        dest.writeString(phone);
        dest.writeStringList(address);
        dest.writeString(id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<RestaurantsSearchAttributes> CREATOR = new Creator<RestaurantsSearchAttributes>() {
        @Override
        public RestaurantsSearchAttributes createFromParcel(Parcel in) {
            return new RestaurantsSearchAttributes(in);
        }

        @Override
        public RestaurantsSearchAttributes[] newArray(int size) {
            return new RestaurantsSearchAttributes[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayPhone() {
        return displayPhone;
    }

    public void setDisplayPhone(String displayPhone) {
        this.displayPhone = displayPhone;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
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
