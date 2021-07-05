
package com.example.restaurants;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Restaurant {

    @SerializedName("businesses")
    private List<Business> mBusinesses;
    @SerializedName("region")
    private Region mRegion;
    @SerializedName("total")
    private Long mTotal;

    public List<Business> getBusinesses() {
        return mBusinesses;
    }

    public void setBusinesses(List<Business> businesses) {
        mBusinesses = businesses;
    }

    public Region getRegion() {
        return mRegion;
    }

    public void setRegion(Region region) {
        mRegion = region;
    }

    public Long getTotal() {
        return mTotal;
    }

    public void setTotal(Long total) {
        mTotal = total;
    }

}
