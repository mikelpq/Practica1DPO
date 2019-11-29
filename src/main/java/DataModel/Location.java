package DataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("coordinates")
    @Expose
    private float[] coordinates;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("architect")
    @Expose
    private String architect;
    @SerializedName("innauguration")
    @Expose
    private int innaguration;
}
