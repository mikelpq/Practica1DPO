package JsonModel;

import DataModel.*;
import com.google.gson.Gson;
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
    private String pathlocation = "src/files/localitzacions.json";
    private String pathusers = "src/files/users.json";

    public JsonModel(){

        try{
            String text = new String(Files.readAllBytes(Paths.get(pathlocation)), StandardCharsets.UTF_8);
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

    public static void insertIntoJsonUsers(User user){
        Gson gson = new Gson();


        try(FileWriter fw = new FileWriter("src/files/user.json")){
            gson.toJson(user, fw);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
