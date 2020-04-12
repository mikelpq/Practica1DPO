
package Model.RouteResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseJson {

    @SerializedName("debugOutput")
    @Expose
    private DebugOutput debugOutput;
    @SerializedName("error")
    @Expose
    private Error error;
    @SerializedName("plan")
    @Expose
    private Plan plan;
    @SerializedName("requestParameters")
    @Expose
    private RequestParameters requestParameters;

    private Boolean ok;

    public DebugOutput getDebugOutput() {
        return debugOutput;
    }

    public Error getError() {
        return error;
    }

    public Plan getPlan() {
        return plan;
    }

    public RequestParameters getRequestParameters() {
        return requestParameters;
    }

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }
}
