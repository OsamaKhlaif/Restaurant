
package com.example.restaurants.APIBusinessId;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class LocationId {

    @SerializedName("address1")
    private String mAddress1;
    @SerializedName("address2")
    private String mAddress2;
    @SerializedName("address3")
    private String mAddress3;
    @SerializedName("city")
    private String mCity;
    @SerializedName("country")
    private String mCountry;
    @SerializedName("cross_streets")
    private String mCrossStreets;
    @SerializedName("display_address")
    private List<String> mDisplayAddress;
    @SerializedName("state")
    private String mState;
    @SerializedName("zip_code")
    private String mZipCode;

    public String getAddress1() {
        return mAddress1;
    }

    public void setAddress1(String address1) {
        mAddress1 = address1;
    }

    public String getAddress2() {
        return mAddress2;
    }

    public void setAddress2(String address2) {
        mAddress2 = address2;
    }

    public String getAddress3() {
        return mAddress3;
    }

    public void setAddress3(String address3) {
        mAddress3 = address3;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public String getCrossStreets() {
        return mCrossStreets;
    }

    public void setCrossStreets(String crossStreets) {
        mCrossStreets = crossStreets;
    }

    public List<String> getDisplayAddress() {
        return mDisplayAddress;
    }

    public void setDisplayAddress(List<String> displayAddress) {
        mDisplayAddress = displayAddress;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public String getZipCode() {
        return mZipCode;
    }

    public void setZipCode(String zipCode) {
        mZipCode = zipCode;
    }

}
