package Stop;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FeatureProperty {
    @SerializedName("ADRECA")
    @Expose
    private String adreca;
    @SerializedName("CODI_GRUP_ESTACIO")
    @Expose
    private Integer codi_grup_estacio;
    @SerializedName("CODI_INTERC")
    @Expose
    private Integer codi_interc;
    @SerializedName("CODI_PARADA")
    @Expose
    private Integer codi_parada;
    @SerializedName("DATA")
    @Expose
    private String data;
    @SerializedName("DATA_FI")
    @Expose
    private String data_fi;
    @SerializedName("DATA_INAUGURACIO")
    @Expose
    private String data_inauguracio;
    @SerializedName("DATA_INICI")
    @Expose
    private String data_inici;
    @SerializedName("DESC_PARADA")
    @Expose
    private String desc_parada;
    @SerializedName("DESC_TIPUS_PARADA")
    @Expose
    private String desc_tipus_parada;
    @SerializedName("ID_DISTRICTE")
    @Expose
    private String id_districte;
    @SerializedName("ID_ESTACIO")
    @Expose
    private Integer id_estacio;
    @SerializedName("ID_PARADA")
    @Expose
    private Integer id_parada;
    @SerializedName("ID_POBLACIO")
    @Expose
    private Integer id_poblacio;
    @SerializedName("ID_TIPUS_ESTAT")
    @Expose
    private Integer id_tipus_estat;
    @SerializedName("NOM_DISTRICTE")
    @Expose
    private String nom_districte;
    @SerializedName("NOM_ESTACIO")
    @Expose
    private String nom_estacio;
    @SerializedName("NOM_INTERC")
    @Expose
    private String nom_interc;
    @SerializedName("NOM_PARADA")
    @Expose
    private String nom_parada;
    @SerializedName("NOM_POBLACIO")
    @Expose
    private String nom_poblacio;
    @SerializedName("NOM_PROPERA_VIA")
    @Expose
    private String nom_propera_via;
    @SerializedName("NOM_TIPUS_PARADA")
    @Expose
    private String nom_tipus_parada;
    @SerializedName("NOM_VIA")
    @Expose
    private String nom_via;
    @SerializedName("PICTO")
    @Expose
    private String picto;
    @SerializedName("TIPIFICACIO_PARADA")
    @Expose
    private String tipificacio_parada;


    public String getAdreca() {
        return adreca;
    }

    public Integer getCodi_grup_estacio() {
        return codi_grup_estacio;
    }

    public Integer getCodi_interc() {
        return codi_interc;
    }

    public Integer getCodi_parada() {
        return codi_parada;
    }

    public String getData_fi() {
        return data_fi;
    }

    public String getData_inauguracio() {
        return data_inauguracio;
    }

    public String getDesc_parada() {
        return desc_parada;
    }

    public String getDesc_tipus_parada() {
        return desc_tipus_parada;
    }

    public String getId_districte() {
        return id_districte;
    }

    public Integer getId_parada() {
        return id_parada;
    }

    public Integer getId_poblacio() {
        return id_poblacio;
    }

    public String getNom_districte() {
        return nom_districte;
    }

    public String getNom_interc() {
        return nom_interc;
    }

    public String getNom_parada() {
        return nom_parada;
    }

    public String getNom_poblacio() {
        return nom_poblacio;
    }

    public String getNom_propera_via() {
        return nom_propera_via;
    }

    public String getNom_tipus_parada() {
        return nom_tipus_parada;
    }

    public String getNom_via() {
        return nom_via;
    }

    public Integer getId_estacio() {
        return id_estacio;
    }

    public Integer getId_tipus_estat() {
        return id_tipus_estat;
    }

    public String getNom_estacio() {
        return nom_estacio;
    }

    public String getPicto() {
        return picto;
    }

    public String getTipificacio_parada() {
        return tipificacio_parada;
    }
}
