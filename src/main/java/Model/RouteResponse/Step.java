
package Model.RouteResponse;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Step {

    @SerializedName("absoluteDirection")
    @Expose
    private String absoluteDirection;
    @SerializedName("alerts")
    @Expose
    private List<Alert> alerts = null;
    @SerializedName("area")
    @Expose
    private Boolean area;
    @SerializedName("bogusName")
    @Expose
    private Boolean bogusName;
    @SerializedName("distance")
    @Expose
    private double distance;
    @SerializedName("elevation")
    @Expose
    private List<String> elevation = null;
    @SerializedName("exit")
    @Expose
    private String exit;
    @SerializedName("lat")
    @Expose
    private double lat;
    @SerializedName("lon")
    @Expose
    private double lon;
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

    public List<Alert> getAlerts() {
        return alerts;
    }

    public Boolean getArea() {
        return area;
    }

    public Boolean getBogusName() {
        return bogusName;
    }

    public double getDistance() {
        return distance;
    }

    public List<String> getElevation() {
        return elevation;
    }

    public String getExit() {
        return exit;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getRelativeDirection() {
        return relativeDirection;
    }

    public Boolean getStayOn() {
        return stayOn;
    }

    public String getStreetName() {
        return streetName;
    }

}
