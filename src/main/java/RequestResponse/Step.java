
package RequestResponse;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Step {

    @SerializedName("absoluteDirection")
    @Expose
    private String absoluteDirection;
    @SerializedName("alerts")
    @Expose
    private List<Alert_> alerts = null;
    @SerializedName("area")
    @Expose
    private Boolean area;
    @SerializedName("bogusName")
    @Expose
    private Boolean bogusName;
    @SerializedName("distance")
    @Expose
    private Integer distance;
    @SerializedName("elevation")
    @Expose
    private List<String> elevation = null;
    @SerializedName("exit")
    @Expose
    private String exit;
    @SerializedName("lat")
    @Expose
    private Integer lat;
    @SerializedName("lon")
    @Expose
    private Integer lon;
    @SerializedName("relativeDirection")
    @Expose
    private String relativeDirection;
    @SerializedName("stayOn")
    @Expose
    private Boolean stayOn;
    @SerializedName("streetName")
    @Expose
    private String streetName;

    public String getAbsoluteDirection() {
        return absoluteDirection;
    }

    public void setAbsoluteDirection(String absoluteDirection) {
        this.absoluteDirection = absoluteDirection;
    }

    public List<Alert_> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Alert_> alerts) {
        this.alerts = alerts;
    }

    public Boolean getArea() {
        return area;
    }

    public void setArea(Boolean area) {
        this.area = area;
    }

    public Boolean getBogusName() {
        return bogusName;
    }

    public void setBogusName(Boolean bogusName) {
        this.bogusName = bogusName;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public List<String> getElevation() {
        return elevation;
    }

    public void setElevation(List<String> elevation) {
        this.elevation = elevation;
    }

    public String getExit() {
        return exit;
    }

    public void setExit(String exit) {
        this.exit = exit;
    }

    public Integer getLat() {
        return lat;
    }

    public void setLat(Integer lat) {
        this.lat = lat;
    }

    public Integer getLon() {
        return lon;
    }

    public void setLon(Integer lon) {
        this.lon = lon;
    }

    public String getRelativeDirection() {
        return relativeDirection;
    }

    public void setRelativeDirection(String relativeDirection) {
        this.relativeDirection = relativeDirection;
    }

    public Boolean getStayOn() {
        return stayOn;
    }

    public void setStayOn(Boolean stayOn) {
        this.stayOn = stayOn;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

}
