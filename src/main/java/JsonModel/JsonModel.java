package JsonModel;

import DataModel.*;
import com.google.gson.*;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class JsonModel {
    private DataModel dataModel;
    private static String pathlocation = "src/files/localitzacions.json";
    private static String pathusers = "src/files/users.json";
    private static String pathuserlocations = "src/files/userlocations.json";


    public DataModel getDataModel() {
        return dataModel;
    }

    /** reading and extracting info from localitzacions.json file **/
    public JsonModel(){
        try{
            String text = Files.readString(Paths.get(pathlocation));
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
            }
        }catch (IOException e1){
            e1.fillInStackTrace();
        }
    }


    /** adding new user to user.json and its locations**/
    public static void insertIntoJsonUsers(ArrayList<Location> location_created, ArrayList<Location> location_fav, ArrayList<Location> location_searched, User user){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject object_locations_to_insert = new JsonObject();



        try(FileWriter fw = new FileWriter("src/files/users.json")){
            gson.toJson(user, fw);

            JsonElement jsonElement = gson.toJsonTree(object_locations_to_insert);
            //jsonElement.getAsJsonObject().addProperty(user);
            addToJsonElement(location_created, jsonElement);

            addToJsonElement(location_searched, jsonElement);

            addToJsonElement(location_fav, jsonElement);

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

}
