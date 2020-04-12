
package Model.RouteResponse;

import java.math.BigInteger;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Leg {

    @SerializedName("agencyId")
    @Expose
    private String agencyId;
    @SerializedName("agencyName")
    @Expose
    private String agencyName;
    @SerializedName("agencyTimeZoneOffset")
    @Expose
    private Integer agencyTimeZoneOffset;
    @SerializedName("agencyUrl")
    @Expose
    private String agencyUrl;
    @SerializedName("alerts")
    @Expose
    private List<Alert> alerts = null;
    @SerializedName("alightRule")
    @Expose
    private String alightRule;
    @SerializedName("arrivalDelay")
    @Expose
    private Integer arrivalDelay;
    @SerializedName("boardRule")
    @Expose
    private String boardRule;
    @SerializedName("departureDelay")
    @Expose
    private Integer departureDelay;
    @SerializedName("distance")
    @Expose
    private double distance;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("endTime")
    @Expose
    private BigInteger endTime;
    @SerializedName("from")
    @Expose
    private Place from;
    @SerializedName("headsign")
    @Expose
    private String headsign;
    @SerializedName("headway")
    @Expose
    private Integer headway;
    @SerializedName("interlineWithPreviousLeg")
    @Expose
    private Boolean interlineWithPreviousLeg;
    @SerializedName("intermediateStops")
    @Expose
    private List<IntermediateStop> intermediateStops = null;
    @SerializedName("isNonExactFrequency")
    @Expose
    private Boolean isNonExactFrequency;
    @SerializedName("legGeometry")
    @Expose
    private LegGeometry legGeometry;
    @SerializedName("mode")
    @Expose
    private String mode;
    @SerializedName("pathway")
    @Expose
    private Boolean pathway;
    @SerializedName("realTime")
    @Expose
    private Boolean realTime;
    @SerializedName("rentedBike")
    @Expose
    private Boolean rentedBike;
    @SerializedName("route")
    @Expose
    private String route;
    @SerializedName("routeColor")
    @Expose
    private String routeColor;
    @SerializedName("routeId")
    @Expose
    private String routeId;
    @SerializedName("routeLongName")
    @Expose
    private String routeLongName;
    @SerializedName("routeShortName")
    @Expose
    private String routeShortName;
    @SerializedName("routeTextColor")
    @Expose
    private String routeTextColor;
    @SerializedName("routeType")
    @Expose
    private Integer routeType;
    @SerializedName("serviceDate")
    @Expose
    private String serviceDate;
    @SerializedName("startTime")
    @Expose
    private BigInteger startTime;
    @SerializedName("steps")
    @Expose
    private List<Step> steps = null;
    @SerializedName("to")
    @Expose
    private Place place;
    @SerializedName("transitLeg")
    @Expose
    private Boolean transitLeg;
    @SerializedName("tripBlockId")
    @Expose
    private String tripBlockId;
    @SerializedName("tripId")
    @Expose
    private String tripId;
    @SerializedName("tripShortName")
    @Expose
    private String tripShortName;

    public String getAgencyId() {
        return agencyId;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public Integer getAgencyTimeZoneOffset() {
        return agencyTimeZoneOffset;
    }

    public String getAgencyUrl() {
        return agencyUrl;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public String getAlightRule() {
        return alightRule;
    }

    public Integer getArrivalDelay() {
        return arrivalDelay;
    }

    public String getBoardRule() {
        return boardRule;
    }

    public Integer getDepartureDelay() {
        return departureDelay;
    }

    public double getDistance() {
        return distance;
    }

    public Integer getDuration() {
        return duration;
    }

    public BigInteger getEndTime() {
        return endTime;
    }

    public Place getFrom() {
        return from;
    }

    public String getHeadsign() {
        return headsign;
    }

    public Integer getHeadway() {
        return headway;
    }

    public Boolean getInterlineWithPreviousLeg() {
        return interlineWithPreviousLeg;
    }

    public List<IntermediateStop> getIntermediateStops() {
        return intermediateStops;
    }

    public Boolean getIsNonExactFrequency() {
        return isNonExactFrequency;
    }

    public LegGeometry getLegGeometry() {
        return legGeometry;
    }

    public String getMode() {
        return mode;
    }

    public Boolean getPathway() {
        return pathway;
    }

    public Boolean getRealTime() {
        return realTime;
    }

    public Boolean getRentedBike() {
        return rentedBike;
    }

    public String getRoute() {
        return route;
    }

    public String getRouteColor() {
        return routeColor;
    }

    public String getRouteId() {
        return routeId;
    }

    public String getRouteLongName() {
        return routeLongName;
    }

    public String getRouteShortName() {
        return routeShortName;
    }

    public String getRouteTextColor() {
        return routeTextColor;
    }

    public Integer getRouteType() {
        return routeType;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public BigInteger getStartTime() {
        return startTime;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public Place getPlace() {
        return place;
    }

    public Boolean getTransitLeg() {
        return transitLeg;
    }

    public String getTripBlockId() {
        return tripBlockId;
    }

    public String getTripId() {
        return tripId;
    }

    public String getTripShortName() {
        return tripShortName;
    }
}
