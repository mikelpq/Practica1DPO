
package RouteResponse;

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

    public DebugOutput getDebugOutput() {
        return debugOutput;
    }

    public void setDebugOutput(DebugOutput debugOutput) {
        this.debugOutput = debugOutput;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public RequestParameters getRequestParameters() {
        return requestParameters;
    }

    public void setRequestParameters(RequestParameters requestParameters) {
        this.requestParameters = requestParameters;
    }

}
