import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import javax.annotation.processing.FilerException;
import javax.swing.*;
import java.awt.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonModel {
    private static String pathlocation = "src/files/localitzacions.json";
    private static String pathuser = "src/files/user.json";
    private DataModel dataModel;


    /** reading JSON file **/
    public JsonModel() throws FilerException {
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
    public static void insertIntoJsonUsers(User user){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //User[] users = gson.fromJson(pathuser, User[].class);

        try(FileWriter fw = new FileWriter(pathuser)){
            gson.toJson(user, fw);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
