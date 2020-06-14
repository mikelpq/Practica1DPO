package Stop;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CrsProperty {

    @SerializedName("name")
    @Expose
    private String name;

    public String getName() {
        return name;
    }
}

