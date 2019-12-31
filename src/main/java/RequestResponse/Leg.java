
package RequestResponse;

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
    private Integer distance;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("endTime")
    @Expose
    private Integer endTime;
    @SerializedName("from")
    @Expose
    private From_ from;
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
    private Integer startTime;
    @SerializedName("steps")
    @Expose
    private List<Step> steps = null;
    @SerializedName("to")
    @Expose
    private To to;
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

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public Integer getAgencyTimeZoneOffset() {
        return agencyTimeZoneOffset;
    }

    public void setAgencyTimeZoneOffset(Integer agencyTimeZoneOffset) {
        this.agencyTimeZoneOffset = agencyTimeZoneOffset;
    }

    public String getAgencyUrl() {
        return agencyUrl;
    }

    public void setAgencyUrl(String agencyUrl) {
        this.agencyUrl = agencyUrl;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;
    }

    public String getAlightRule() {
        return alightRule;
    }

    public void setAlightRule(String alightRule) {
        this.alightRule = alightRule;
    }

    public Integer getArrivalDelay() {
        return arrivalDelay;
    }

    public void setArrivalDelay(Integer arrivalDelay) {
        this.arrivalDelay = arrivalDelay;
    }

    public String getBoardRule() {
        return boardRule;
    }

    public void setBoardRule(String boardRule) {
        this.boardRule = boardRule;
    }

    public Integer getDepartureDelay() {
        return departureDelay;
    }

    public void setDepartureDelay(Integer departureDelay) {
        this.departureDelay = departureDelay;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public From_ getFrom() {
        return from;
    }

    public void setFrom(From_ from) {
        this.from = from;
    }

    public String getHeadsign() {
        return headsign;
    }

    public void setHeadsign(String headsign) {
        this.headsign = headsign;
    }

    public Integer getHeadway() {
        return headway;
    }

    public void setHeadway(Integer headway) {
        this.headway = headway;
    }

    public Boolean getInterlineWithPreviousLeg() {
        return interlineWithPreviousLeg;
    }

    public void setInterlineWithPreviousLeg(Boolean interlineWithPreviousLeg) {
        this.interlineWithPreviousLeg = interlineWithPreviousLeg;
    }

    public List<IntermediateStop> getIntermediateStops() {
        return intermediateStops;
    }

    public void setIntermediateStops(List<IntermediateStop> intermediateStops) {
        this.intermediateStops = intermediateStops;
    }

    public Boolean getIsNonExactFrequency() {
        return isNonExactFrequency;
    }

    public void setIsNonExactFrequency(Boolean isNonExactFrequency) {
        this.isNonExactFrequency = isNonExactFrequency;
    }

    public LegGeometry getLegGeometry() {
        return legGeometry;
    }

    public void setLegGeometry(LegGeometry legGeometry) {
        this.legGeometry = legGeometry;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Boolean getPathway() {
        return pathway;
    }

    public void setPathway(Boolean pathway) {
        this.pathway = pathway;
    }

    public Boolean getRealTime() {
        return realTime;
    }

    public void setRealTime(Boolean realTime) {
        this.realTime = realTime;
    }

    public Boolean getRentedBike() {
        return rentedBike;
    }

    public void setRentedBike(Boolean rentedBike) {
        this.rentedBike = rentedBike;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getRouteColor() {
        return routeColor;
    }

    public void setRouteColor(String routeColor) {
        this.routeColor = routeColor;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getRouteLongName() {
        return routeLongName;
    }

    public void setRouteLongName(String routeLongName) {
        this.routeLongName = routeLongName;
    }

    public String getRouteShortName() {
        return routeShortName;
    }

    public void setRouteShortName(String routeShortName) {
        this.routeShortName = routeShortName;
    }

    public String getRouteTextColor() {
        return routeTextColor;
    }

    public void setRouteTextColor(String routeTextColor) {
        this.routeTextColor = routeTextColor;
    }

    public Integer getRouteType() {
        return routeType;
    }

    public void setRouteType(Integer routeType) {
        this.routeType = routeType;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public To getTo() {
        return to;
    }

    public void setTo(To to) {
        this.to = to;
    }

    public Boolean getTransitLeg() {
        return transitLeg;
    }

    public void setTransitLeg(Boolean transitLeg) {
        this.transitLeg = transitLeg;
    }

    public String getTripBlockId() {
        return tripBlockId;
    }

    public void setTripBlockId(String tripBlockId) {
        this.tripBlockId = tripBlockId;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getTripShortName() {
        return tripShortName;
    }

    public void setTripShortName(String tripShortName) {
        this.tripShortName = tripShortName;
    }

}
