
package RequestResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestParameters {

    @SerializedName("app_id")
    @Expose
    private String appId;
    @SerializedName("app_key")
    @Expose
    private String appKey;
    @SerializedName("arriveBy")
    @Expose
    private String arriveBy;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("fromPlace")
    @Expose
    private String fromPlace;
    @SerializedName("maxWalkDistance")
    @Expose
    private String maxWalkDistance;
    @SerializedName("mode")
    @Expose
    private String mode;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("toPlace")
    @Expose
    private String toPlace;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getArriveBy() {
        return arriveBy;
    }

    public void setArriveBy(String arriveBy) {
        this.arriveBy = arriveBy;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFromPlace() {
        return fromPlace;
    }

    public void setFromPlace(String fromPlace) {
        this.fromPlace = fromPlace;
    }

    public String getMaxWalkDistance() {
        return maxWalkDistance;
    }

    public void setMaxWalkDistance(String maxWalkDistance) {
        this.maxWalkDistance = maxWalkDistance;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getToPlace() {
        return toPlace;
    }

    public void setToPlace(String toPlace) {
        this.toPlace = toPlace;
    }

}
