
package RequestResponse;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Error {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("missing")
    @Expose
    private List<String> missing = null;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("noPath")
    @Expose
    private Boolean noPath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getMissing() {
        return missing;
    }

    public void setMissing(List<String> missing) {
        this.missing = missing;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getNoPath() {
        return noPath;
    }

    public void setNoPath(Boolean noPath) {
        this.noPath = noPath;
    }

}
