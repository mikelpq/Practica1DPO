
package RequestResponse;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Plan {

    @SerializedName("date")
    @Expose
    private Integer date;
    @SerializedName("from")
    @Expose
    private From from;
    @SerializedName("itineraries")
    @Expose
    private List<Itinerary> itineraries = null;
    @SerializedName("to")
    @Expose
    private To_ to;

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public From getFrom() {
        return from;
    }

    public void setFrom(From from) {
        this.from = from;
    }

    public List<Itinerary> getItineraries() {
        return itineraries;
    }

    public void setItineraries(List<Itinerary> itineraries) {
        this.itineraries = itineraries;
    }

    public To_ getTo() {
        return to;
    }

    public void setTo(To_ to) {
        this.to = to;
    }

}
