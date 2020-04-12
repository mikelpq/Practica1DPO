
package Model.RouteResponse;

import java.math.BigInteger;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Itinerary {

    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("elevationGained")
    @Expose
    private Integer elevationGained;
    @SerializedName("elevationLost")
    @Expose
    private Integer elevationLost;
    @SerializedName("endTime")
    @Expose
    private BigInteger endTime;
    @SerializedName("fare")
    @Expose
    private Fare fare;
    @SerializedName("legs")
    @Expose
    private List<Leg> legs = null;
    @SerializedName("startTime")
    @Expose
    private BigInteger startTime;
    @SerializedName("tooSloped")
    @Expose
    private Boolean tooSloped;
    @SerializedName("transfers")
    @Expose
    private Integer transfers;
    @SerializedName("transitTime")
    @Expose
    private Integer transitTime;
    @SerializedName("waitingTime")
    @Expose
    private Integer waitingTime;
    @SerializedName("walkDistance")
    @Expose
    private double walkDistance;
    @SerializedName("walkLimitExceeded")
    @Expose
    private Boolean walkLimitExceeded;
    @SerializedName("walkTime")
    @Expose
    private Integer walkTime;

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getElevationGained() {
        return elevationGained;
    }

    public void setElevationGained(Integer elevationGained) {
        this.elevationGained = elevationGained;
    }

    public Integer getElevationLost() {
        return elevationLost;
    }

    public void setElevationLost(Integer elevationLost) {
        this.elevationLost = elevationLost;
    }

    public BigInteger getEndTime() {
        return endTime;
    }

    public void setEndTime(BigInteger endTime) {
        this.endTime = endTime;
    }

    public Fare getFare() {
        return fare;
    }

    public void setFare(Fare fare) {
        this.fare = fare;
    }

    public List<Leg> getLegs() {
        return legs;
    }

    public void setLegs(List<Leg> legs) {
        this.legs = legs;
    }

    public BigInteger getStartTime() {
        return startTime;
    }

    public void setStartTime(BigInteger startTime) {
        this.startTime = startTime;
    }

    public Boolean getTooSloped() {
        return tooSloped;
    }

    public void setTooSloped(Boolean tooSloped) {
        this.tooSloped = tooSloped;
    }

    public Integer getTransfers() {
        return transfers;
    }

    public void setTransfers(Integer transfers) {
        this.transfers = transfers;
    }

    public Integer getTransitTime() {
        return transitTime;
    }

    public void setTransitTime(Integer transitTime) {
        this.transitTime = transitTime;
    }

    public Integer getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(Integer waitingTime) {
        this.waitingTime = waitingTime;
    }

    public double getWalkDistance() {
        return walkDistance;
    }

    public void setWalkDistance(double walkDistance) {
        this.walkDistance = walkDistance;
    }

    public Boolean getWalkLimitExceeded() {
        return walkLimitExceeded;
    }

    public void setWalkLimitExceeded(Boolean walkLimitExceeded) {
        this.walkLimitExceeded = walkLimitExceeded;
    }

    public Integer getWalkTime() {
        return walkTime;
    }

    public void setWalkTime(Integer walkTime) {
        this.walkTime = walkTime;
    }

}
