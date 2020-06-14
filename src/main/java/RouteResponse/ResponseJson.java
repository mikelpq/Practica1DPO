
package RouteResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseJson {

    @SerializedName("plan")
    @Expose
    private Plan plan;

    public Plan getPlan() {
        return plan;
    }
}
