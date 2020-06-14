package Stop;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Stop {

    @SerializedName("crs")
    @Expose
    private Crs crs;
    @SerializedName("totalFeatures")
    @Expose
    private Integer totalFeatures;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("features")
    @Expose
    private List<Feature> features = null;

    private String nom_estacio;
    private String picto;
    private String data_inauguracio;

    public Stop(String nom_estacio, String picto, String data_inauguracio) {
        this.nom_estacio = nom_estacio;
        this.picto = picto;
        this.data_inauguracio = data_inauguracio;

    }

    public Crs getCrs() {
        return crs;
    }

    public Integer getTotalFeatures() {
        return totalFeatures;
    }

    public String getType() {
        return type;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public String getNom_estacio() {
        return nom_estacio;
    }

    public String getPicto() {
        return picto;
    }

    public String getData_inauguracio() {
        return data_inauguracio;
    }
}
