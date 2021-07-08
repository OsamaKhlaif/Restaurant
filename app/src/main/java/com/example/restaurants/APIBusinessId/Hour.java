
package com.example.restaurants.APIBusinessId;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Hour {

    @SerializedName("hours_type")
    private String mHoursType;
    @SerializedName("is_open_now")
    private Boolean mIsOpenNow;
    @SerializedName("open")
    private List<Open> mOpen;

    public String getHoursType() {
        return mHoursType;
    }

    public void setHoursType(String hoursType) {
        mHoursType = hoursType;
    }

    public Boolean getIsOpenNow() {
        return mIsOpenNow;
    }

    public void setIsOpenNow(Boolean isOpenNow) {
        mIsOpenNow = isOpenNow;
    }

    public List<Open> getOpen() {
        return mOpen;
    }

    public void setOpen(List<Open> open) {
        mOpen = open;
    }

}
