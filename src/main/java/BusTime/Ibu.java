
package BusTime;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ibu {

    @SerializedName("line")
    @Expose
    private String line;
    @SerializedName("routeId")
    @Expose
    private String routeId;
    @SerializedName("t-in-min")
    @Expose
    private Integer tInMin;
    @SerializedName("t-in-s")
    @Expose
    private Integer tInS;
    @SerializedName("text-ca")
    @Expose
    private String textCa;

    public String getLine() {
        return line;
    }

    public String getRouteId() {
        return routeId;
    }

    public Integer getTInMin() {
        return tInMin;
    }

    public Integer getTInS() {
        return tInS;
    }

    public String getTextCa() {
        return textCa;
    }

}
