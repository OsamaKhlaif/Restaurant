package com.example.restaurants;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class RestaurantsSearchAttributes implements Parcelable {

    private String placeName;
    private long restaurantsReview;
    private double restaurantsRating;
    private String restaurantsImage;
    private String restaurantsDisplayPhone;
    private String restaurantsZipCode;
    private List<String> restaurantsAddress;
    private String restaurantsId;
    private String restaurantsPhoneCall;

    public RestaurantsSearchAttributes(String placeName, long restaurantsReview, double restaurantsRating, String restaurantsImage, String restaurantsDisplayPhone, String restaurantsZipCode, List<String> restaurantsAddress, String restaurantsPhoneCall, String restaurantsId) {
        this.placeName = placeName;
        this.restaurantsReview = restaurantsReview;
        this.restaurantsRating = restaurantsRating;
        this.restaurantsImage = restaurantsImage;
        this.restaurantsDisplayPhone = restaurantsDisplayPhone;
        this.restaurantsZipCode = restaurantsZipCode;
        this.restaurantsAddress = restaurantsAddress;
        this.restaurantsPhoneCall = restaurantsPhoneCall;
        this.restaurantsId = restaurantsId;
    }

    protected RestaurantsSearchAttributes(Parcel in) {
        placeName = in.readString();
        restaurantsReview = in.readLong();
        restaurantsRating = in.readDouble();
        restaurantsImage = in.readString();
        restaurantsDisplayPhone = in.readString();
        restaurantsZipCode = in.readString();
        restaurantsPhoneCall = in.readString();
        restaurantsAddress = in.createStringArrayList();
        restaurantsId = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(placeName);
        dest.writeLong(restaurantsReview);
        dest.writeDouble(restaurantsRating);
        dest.writeString(restaurantsImage);
        dest.writeString(restaurantsDisplayPhone);
        dest.writeString(restaurantsZipCode);
        dest.writeString(restaurantsPhoneCall);
        dest.writeStringList(restaurantsAddress);
        dest.writeString(restaurantsId);
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

    public String getRestaurantsId() {
        return restaurantsId;
    }

    public void setRestaurantsId(String restaurantsId) {
        this.restaurantsId = restaurantsId;
    }

    public String getRestaurantsDisplayPhone() {
        return restaurantsDisplayPhone;
    }

    public void setRestaurantsDisplayPhone(String restaurantsDisplayPhone) {
        this.restaurantsDisplayPhone = restaurantsDisplayPhone;
    }

    public String getRestaurantsZipCode() {
        return restaurantsZipCode;
    }

    public void setRestaurantsZipCode(String restaurantsZipCode) {
        this.restaurantsZipCode = restaurantsZipCode;
    }

    public String getRestaurantsPhoneCall() {
        return restaurantsPhoneCall;
    }

    public void setRestaurantsPhoneCall(String restaurantsPhoneCall) {
        this.restaurantsPhoneCall = restaurantsPhoneCall;
    }

    public List<String> getRestaurantsAddress() {
        return restaurantsAddress;
    }

    public void setRestaurantsAddress(List<String> restaurantsAddress) {
        this.restaurantsAddress = restaurantsAddress;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public long getRestaurantsReview() {
        return restaurantsReview;
    }

    public void setRestaurantsReview(long restaurantsReview) {
        this.restaurantsReview = restaurantsReview;
    }

    public double getRestaurantsRating() {
        return restaurantsRating;
    }

    public void setRestaurantsRating(double restaurantsRating) {
        this.restaurantsRating = restaurantsRating;
    }

    public String getRestaurantsImage() {
        return restaurantsImage;
    }

    public void setRestaurantsImage(String restaurantsImage) {
        this.restaurantsImage = restaurantsImage;
    }

}
