
package RouteResponse;

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

    public List<Leg> getLegs() {
        return legs;
    }
}
