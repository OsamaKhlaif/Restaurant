
package com.example.restaurants.APIBusinessSearch;

import java.util.List;
import javax.annotation.Generated;

import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Business {

    @SerializedName("alias")
    private String mAlias;
    @SerializedName("categories")
    private List<Category> mCategories;
    @SerializedName("coordinates")
    private Coordinates mCoordinates;
    @SerializedName("display_phone")
    private String mDisplayPhone;
    @SerializedName("distance")
    private Double mDistance;
    @SerializedName("id")
    private String mId;
    @SerializedName("image_url")
    private String mImageUrl;
    @SerializedName("is_closed")
    private Boolean mIsClosed;
    @SerializedName("location")
    private Location mLocation;
    @SerializedName("name")
    private String mName;
    @SerializedName("phone")
    private String mPhone;
    @SerializedName("price")
    private String mPrice;
    @SerializedName("rating")
    private Double mRating;
    @SerializedName("review_count")
    private Long mReviewCount;
    @SerializedName("transactions")
    private List<String> mTransactions;
    @SerializedName("url")
    private String mUrl;

    public String getAlias() {
        return mAlias;
    }

    public void setAlias(String alias) {
        mAlias = alias;
    }

    public List<Category> getCategories() {
        return mCategories;
    }

    public void setCategories(List<Category> categories) {
        mCategories = categories;
    }

    public Coordinates getCoordinates() {
        return mCoordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        mCoordinates = coordinates;
    }

    public String getDisplayPhone() {
        return mDisplayPhone;
    }

    public void setDisplayPhone(String displayPhone) {
        mDisplayPhone = displayPhone;
    }

    public Double getDistance() {
        return mDistance;
    }

    public void setDistance(Double distance) {
        mDistance = distance;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public Boolean getIsClosed() {
        return mIsClosed;
    }

    public void setIsClosed(Boolean isClosed) {
        mIsClosed = isClosed;
    }

    public Location getLocation() {
        return mLocation;
    }

    public void setLocation(Location location) {
        mLocation = location;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        mPrice = price;
    }

    public Double getRating() {
        return mRating;
    }

    public void setRating(Double rating) {
        mRating = rating;
    }

    public Long getReviewCount() {
        return mReviewCount;
    }

    public void setReviewCount(Long reviewCount) {
        mReviewCount = reviewCount;
    }

    public List<String> getTransactions() {
        return mTransactions;
    }

    public void setTransactions(List<String> transactions) {
        mTransactions = transactions;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

}
