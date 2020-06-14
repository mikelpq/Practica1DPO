package Stop;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Crs {

    @SerializedName("properties")
    @Expose
    private CrsProperty properties;
    @SerializedName("type")
    @Expose
    private String type;


    public CrsProperty getProperties() {
        return properties;
    }

    public String getType() {
        return type;
    }
}
