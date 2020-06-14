package Stop;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Geometry {
    @SerializedName("coordinates")
    @Expose
    public float[] coordinates;
    @SerializedName("type")
    @Expose
    public String type;

    public float[] getCoordinates() {
        return coordinates;
    }

    public String getType() {
        return type;
    }
}
