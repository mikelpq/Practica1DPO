package JsonModel;

import DataModel.DataModel;
import DataModel.Location;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonModel {
    private DataModel dataModel;
    String path = "src/files/localitzacions.json";

    public JsonModel(){

        try{
            String text = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
            try{
                Gson gson = new Gson();
                dataModel = gson.fromJson(new FileReader(path), DataModel.class);
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

}
