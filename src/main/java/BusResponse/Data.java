
package RequestResponse;

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

    public void setIbus(List<Ibu> ibus) {
        this.ibus = ibus;
    }

}
