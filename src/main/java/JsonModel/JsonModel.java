package JsonModel;

import DataModel.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import java.io.FileWriter;
import javax.swing.*;
import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonModel {
    private DataModel dataModel;
    private static String pathlocation = "src/files/localitzacions.json";
    private static String pathusers = "src/files/users.json";

    /** reading locations.json file **/
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

    public DataModel getDataModel() {
        return dataModel;
    }


    /** adding new user to user.json **/
    public static void insertIntoJsonUsers(User user){
        Gson gson = new Gson();


        try(FileWriter fw = new FileWriter("src/files/users.json")){
            gson.toJson(user, fw);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /** inserting new locations to user **/
    public static void insertIntoJsonLocations(Location location, User user){
        JsonObject object_locations_to_insert = new JsonObject();
        Gson gson = new Gson();


        object_locations_to_insert.addProperty("name", location.getName());
        object_locations_to_insert.addProperty("latitud", location.getCoordinates()[0]);
        object_locations_to_insert.addProperty("longitud", location.getCoordinates()[1]);
        object_locations_to_insert.addProperty("description", location.getDescription());


        try {
            String text = Files.readString(Paths.get(pathusers));

            try (FileWriter fw = new FileWriter(text)) {
                gson.toJson(object_locations_to_insert.toString());
                //object_user.get("locations").getAsJsonArray().add(object_locations_to_insert);

            } catch (JsonSyntaxException jse) {
                JOptionPane.showMessageDialog(
                        new Frame(),
                        jse.getMessage(),
                        "Json File Error",
                        JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }catch (IOException e){
            e.printStackTrace();
            System.exit(0);
        }
    }

}
