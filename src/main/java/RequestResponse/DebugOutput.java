
package RequestResponse;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DebugOutput {

    @SerializedName("pathCalculationTime")
    @Expose
    private Integer pathCalculationTime;
    @SerializedName("pathTimes")
    @Expose
    private List<Integer> pathTimes = null;
    @SerializedName("precalculationTime")
    @Expose
    private Integer precalculationTime;
    @SerializedName("renderingTime")
    @Expose
    private Integer renderingTime;
    @SerializedName("timedOut")
    @Expose
    private Boolean timedOut;
    @SerializedName("totalTime")
    @Expose
    private Integer totalTime;

    public Integer getPathCalculationTime() {
        return pathCalculationTime;
    }

    public void setPathCalculationTime(Integer pathCalculationTime) {
        this.pathCalculationTime = pathCalculationTime;
    }

    public List<Integer> getPathTimes() {
        return pathTimes;
    }

    public void setPathTimes(List<Integer> pathTimes) {
        this.pathTimes = pathTimes;
    }

    public Integer getPrecalculationTime() {
        return precalculationTime;
    }

    public void setPrecalculationTime(Integer precalculationTime) {
        this.precalculationTime = precalculationTime;
    }

    public Integer getRenderingTime() {
        return renderingTime;
    }

    public void setRenderingTime(Integer renderingTime) {
        this.renderingTime = renderingTime;
    }

    public Boolean getTimedOut() {
        return timedOut;
    }

    public void setTimedOut(Boolean timedOut) {
        this.timedOut = timedOut;
    }

    public Integer getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
    }

}
