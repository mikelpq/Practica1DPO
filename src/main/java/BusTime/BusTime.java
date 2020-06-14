
package BusTime;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BusTime {

    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("status")
    @Expose
    private String status;

    public Data getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }

}
