
package com.example.restaurants.APIBusinessId;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class RestaurantId {

    @SerializedName("alias")
    private String mAlias;
    @SerializedName("categories")
    private List<CategoryId> mCategories;
    @SerializedName("coordinates")
    private CoordinatesId mCoordinates;
    @SerializedName("display_phone")
    private String mDisplayPhone;
    @SerializedName("hours")
    private List<Hour> mHours;
    @SerializedName("id")
    private String mId;
    @SerializedName("image_url")
    private String mImageUrl;
    @SerializedName("is_claimed")
    private Boolean mIsClaimed;
    @SerializedName("is_closed")
    private Boolean mIsClosed;
    @SerializedName("location")
    private LocationId mLocation;
    @SerializedName("name")
    private String mName;
    @SerializedName("phone")
    private String mPhone;
    @SerializedName("photos")
    private List<String> mPhotos;
    @SerializedName("rating")
    private Double mRating;
    @SerializedName("review_count")
    private Long mReviewCount;
    @SerializedName("transactions")
    private List<Object> mTransactions;
    @SerializedName("url")
    private String mUrl;

    public String getAlias() {
        return mAlias;
    }

    public void setAlias(String alias) {
        mAlias = alias;
    }

    public List<CategoryId> getCategories() {
        return mCategories;
    }

    public void setCategories(List<CategoryId> categories) {
        mCategories = categories;
    }

    public CoordinatesId getCoordinates() {
        return mCoordinates;
    }

    public void setCoordinates(CoordinatesId coordinates) {
        mCoordinates = coordinates;
    }

    public String getDisplayPhone() {
        return mDisplayPhone;
    }

    public void setDisplayPhone(String displayPhone) {
        mDisplayPhone = displayPhone;
    }

    public List<Hour> getHours() {
        return mHours;
    }

    public void setHours(List<Hour> hours) {
        mHours = hours;
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

    public Boolean getIsClaimed() {
        return mIsClaimed;
    }

    public void setIsClaimed(Boolean isClaimed) {
        mIsClaimed = isClaimed;
    }

    public Boolean getIsClosed() {
        return mIsClosed;
    }

    public void setIsClosed(Boolean isClosed) {
        mIsClosed = isClosed;
    }

    public LocationId getLocation() {
        return mLocation;
    }

    public void setLocation(LocationId location) {
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

    public List<String> getPhotos() {
        return mPhotos;
    }

    public void setPhotos(List<String> photos) {
        mPhotos = photos;
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

    public List<Object> getTransactions() {
        return mTransactions;
    }

    public void setTransactions(List<Object> transactions) {
        mTransactions = transactions;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

}
