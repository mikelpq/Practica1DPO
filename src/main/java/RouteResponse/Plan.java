
package RouteResponse;

import java.math.BigInteger;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Plan {

    @SerializedName("date")
    @Expose
    private BigInteger date;
    @SerializedName("from")
    @Expose
    private Place from;
    @SerializedName("itineraries")
    @Expose
    private List<Itinerary> itineraries = null;
    @SerializedName("to")
    @Expose
    private Place place;

    public BigInteger getDate() {
        return date;
    }

    public Place getFrom() {
        return from;
    }

    public List<Itinerary> getItineraries() {
        return itineraries;
    }

    public Place getPlace() {
        return place;
    }
}
