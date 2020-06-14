
package RouteResponse;

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


    public Integer getDuration() {
        return duration;
    }

    public Place getFrom() {
        return from;
    }

    public String getMode() {
        return mode;
    }

    public String getRoute() {
        return route;
    }

    public Place getPlace() {
        return place;
    }

}
