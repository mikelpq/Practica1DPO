
package RouteResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IntermediateStop {

    @SerializedName("lat")
    @Expose
    private double lat;
    @SerializedName("lon")
    @Expose
    private double lon;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("orig")
    @Expose
    private String orig;
    @SerializedName("stopCode")
    @Expose
    private String stopCode;
    @SerializedName("vertexType")
    @Expose
    private String vertexType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
