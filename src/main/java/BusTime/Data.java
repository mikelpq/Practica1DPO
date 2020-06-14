
package BusTime;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("ibus")
    @Expose
    private List<Ibu> ibus = null;

    public List<Ibu> getIbus() {
        return ibus;
    }

}
