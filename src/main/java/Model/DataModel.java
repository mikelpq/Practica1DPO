package Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DataModel {
    @SerializedName("locations")
    private ArrayList<Location> locations;

    public ArrayList<Location> getLocations() {
        return locations;
    }
}
