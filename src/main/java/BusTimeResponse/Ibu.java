
package BusTimeResponse;

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

    public void setLine(String line) {
        this.line = line;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public Integer getTInMin() {
        return tInMin;
    }

    public void setTInMin(Integer tInMin) {
        this.tInMin = tInMin;
    }

    public Integer getTInS() {
        return tInS;
    }

    public void setTInS(Integer tInS) {
        this.tInS = tInS;
    }

    public String getTextCa() {
        return textCa;
    }

    public void setTextCa(String textCa) {
        this.textCa = textCa;
    }

}
