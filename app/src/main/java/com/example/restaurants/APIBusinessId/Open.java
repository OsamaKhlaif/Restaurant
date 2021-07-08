
package com.example.restaurants.APIBusinessId;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Open {

    @SerializedName("day")
    private Long mDay;
    @SerializedName("end")
    private String mEnd;
    @SerializedName("is_overnight")
    private Boolean mIsOvernight;
    @SerializedName("start")
    private String mStart;

    public Long getDay() {
        return mDay;
    }

    public void setDay(Long day) {
        mDay = day;
    }

    public String getEnd() {
        return mEnd;
    }

    public void setEnd(String end) {
        mEnd = end;
    }

    public Boolean getIsOvernight() {
        return mIsOvernight;
    }

    public void setIsOvernight(Boolean isOvernight) {
        mIsOvernight = isOvernight;
    }

    public String getStart() {
        return mStart;
    }

    public void setStart(String start) {
        mStart = start;
    }

}
