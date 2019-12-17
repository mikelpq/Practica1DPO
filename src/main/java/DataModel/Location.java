package DataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Scanner;

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

    //constructor per insertar info al json
    public Location(String name, float[] coordinates, String description) {
        this.name = name;
        this.coordinates = coordinates;
        this.description = description;
    }

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


    public void findAndInsertLocations(DataModel dataModel){
        String name, desc;
        float[] coordinates = new float[2];
        boolean stop = false;
        String opt;
        Scanner sc = new Scanner(System.in);

        opt = "";

        for (int i = 0; i < dataModel.getLocations().size() && !stop; i++) {
            System.out.println("Introdueix el nom d'uan localitzacio");
            opt = sc.nextLine();
            if (dataModel.getLocations().get(i).getName().toLowerCase().equals(opt)){
                stop = true;
            }
        }

        if (!stop){
            System.out.println("Ho sentim, no hi ha cap localitzacio amb aquest nom");
        }else{

        }
    }
}
