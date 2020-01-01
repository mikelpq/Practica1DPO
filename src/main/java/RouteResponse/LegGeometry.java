
package RouteResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LegGeometry {

    @SerializedName("length")
    @Expose
    private Integer length;
    @SerializedName("points")
    @Expose
    private String points;

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

}
