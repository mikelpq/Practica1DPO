package Model;

import com.google.gson.*;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class JsonModel {
    private static String pathlocation = "src/files/localitzacions.json";
    private static String pathuser = "src/files/user.json";
    private DataModel dataModel;


    /** reading JSON file **/
    public JsonModel(){
        System.out.println("reading JSON file...");
        try{
            Gson gson = new Gson();
            dataModel = gson.fromJson(new FileReader(pathlocation), DataModel.class);
        }catch (JsonSyntaxException jse){
            JOptionPane.showMessageDialog(
                    new Frame(),
                    jse.getMessage(),
                    "Json File Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }catch (IOException e1){
            e1.fillInStackTrace();
        }
        System.out.println("success!\n");
    }

    public DataModel getDataModel() {
        return dataModel;
    }

    /** adding new user to user.json and its locations**/
    public static void insertIntoJsonUsers(ArrayList<Location> location_created, ArrayList<LocationFav> location_fav, ArrayList<Location> location_searched, User user){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject object_locations_to_insert = new JsonObject();

        try(FileWriter fw = new FileWriter(pathuser)){
            gson.toJson(user, fw);

            JsonElement jsonElement = gson.toJsonTree(object_locations_to_insert);
            //jsonElement.getAsJsonObject().addProperty(user);
            addToJsonElement(location_created, jsonElement);

            addToJsonElement(location_searched, jsonElement);

            addToJsonElementBis(location_fav, jsonElement);

            gson.toJson(jsonElement, fw);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void addToJsonElement(ArrayList<Location> location, JsonElement jsonElement) {
        for (int i = 0; i < location.size(); i++) {
            jsonElement.getAsJsonObject().addProperty("name", location.get(i).getName());
            jsonElement.getAsJsonObject().addProperty("latitud", location.get(i).getCoordinates()[0]);
            jsonElement.getAsJsonObject().addProperty("longitud", location.get(i).getCoordinates()[1]);
            jsonElement.getAsJsonObject().addProperty("description", location.get(i).getDescription());
        }
    }

    private static void addToJsonElementBis(ArrayList<LocationFav> location, JsonElement jsonElement) {
        for (int i = 0; i < location.size(); i++) {
            jsonElement.getAsJsonObject().addProperty("name", location.get(i).getName());
            jsonElement.getAsJsonObject().addProperty("latitud", location.get(i).getCoordinates()[0]);
            jsonElement.getAsJsonObject().addProperty("longitud", location.get(i).getCoordinates()[1]);
            jsonElement.getAsJsonObject().addProperty("description", location.get(i).getDescription());
        }
    }

}
