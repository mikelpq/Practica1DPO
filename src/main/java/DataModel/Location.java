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
    @SerializedName("characteristics")
    @Expose
    private String[] characteristics;
    @SerializedName("stars")
    @Expose
    private int stars;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(float[] coordinates) {
        this.coordinates = coordinates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArchitect() {
        return architect;
    }

    public void setArchitect(String architect) {
        this.architect = architect;
    }

    public int getInnaguration() {
        return innaguration;
    }

    public void setInnaguration(int innaguration) {
        this.innaguration = innaguration;
    }

    public String[] getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String[] characteristics) {
        this.characteristics = characteristics;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
