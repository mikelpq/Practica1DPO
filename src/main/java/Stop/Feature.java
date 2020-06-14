package Stop;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Feature {
    @SerializedName("geometry")
    @Expose
    private Geometry geometry;
    @SerializedName("geometry_name")
    @Expose
    private String geometryName;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("properties")
    @Expose
    private FeatureProperty properties;


    public Geometry getGeometry() {
        return geometry;
    }

    public String getGeometryName() {
        return geometryName;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public FeatureProperty getProperties() {
        return properties;
    }
}
