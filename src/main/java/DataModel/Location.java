package DataModel;

import Environment.EnvironmentKeys;
import ServerRequests.ServerRequest;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import okhttp3.HttpUrl;
import okhttp3.Request;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Formatter;
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

    /** inici metodes classe **/
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
    /** fi metodes classe **/




    /** inici funcionalitats classe **/
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


    //opcio 3
    public void routePlanifier(DataModel dataModel){
        boolean found = false;
        int i = 0;
        Scanner sc = new Scanner(System.in);
        String name_src = "", name_dst = "", kk = "", arrive = "true", distancia = "0";
        float[] coordinates_src = new float[2], coordinates_dst = new float[2];
        String[] trash = new String[2];

        //comprovem si existeix el origen
        while(!found){
            System.out.println("Origen? (lat,lon/nom localització)");

            //comprovem si s'introdueix el nom de la localitzacio o les coordenades
            name_src = sc.nextLine();
            String[] res = name_dst.split(",");
            if (res.length > 1){
                if (res.length > 2){
                    System.out.println("ERROR! Format incorrecte");
                }else{
                    try{
                        coordinates_dst[1] = Float.parseFloat(res[1]);
                        coordinates_dst[0] = Float.parseFloat(res[0]);
                    }catch (NumberFormatException e){
                        e.printStackTrace();
                    }
                }
            }


            while(!found && i < dataModel.getLocations().size()){
                if (name_src.toLowerCase().equals(dataModel.getLocations().get(i).getName()) ||
                        (coordinates_src[0] == dataModel.getLocations().get(i).getCoordinates()[0] &&
                                coordinates_src[1] == dataModel.getLocations().get(i).getCoordinates()[1])){
                    found = true;
                }
                i++;
            }
            if (i == dataModel.getLocations().size()){
                System.out.println("Ho sentim, aquesta localització no existeix");
                i = 0;
            }
        }

        found = false;

        //comprovem si existeix el desti
        while(!found){
            System.out.println("Desti? (lat,lon/nom localització)");

            //comprovem si s'introdueix el nom de la localitzacio o les coordenades
            name_dst = sc.nextLine();
            String[] res = name_dst.split(",");
            if (res.length > 1){
                if (res.length > 2){
                    System.out.println("ERROR! Format incorrecte");
                }else{
                    try{
                        coordinates_dst[1] = Float.parseFloat(res[1]);
                        coordinates_dst[0] = Float.parseFloat(res[0]);
                    }catch (NumberFormatException e){
                        e.printStackTrace();
                    }
                }
            }


            while(!found && i < dataModel.getLocations().size()){
                if (name_dst.toLowerCase().equals(dataModel.getLocations().get(i).getName()) ||
                        (coordinates_dst[0] == dataModel.getLocations().get(i).getCoordinates()[0] &&
                                coordinates_dst[1] == dataModel.getLocations().get(i).getCoordinates()[1])){
                    found = true;
                }
                i++;
            }
            if (i == dataModel.getLocations().size()){
                System.out.println("Ho sentim, aquesta localització no existeix");
                i = 0;
            }
        }

        found = false;

        while (!found){
            System.out.println("Dia/Hora seran de sortida o d'arribada? s/a");
            kk = sc.nextLine();
            if (kk.equals("s") || kk.equals("a")){
                found = true;
                if(kk.equals("s")){
                    arrive = "false";
                }
            }else {
                System.out.println("Error! S'ha d'introduir s o a");
            }
        }

        System.out.println("Dia? (MM-DD-YYYY)");
        String dateString = sc.next();


        System.out.println("Hora? HH:MMam/HH:MMpm");
        dateString = sc.next();

        System.out.println("Maxima distancia caminant en metres?");
        distancia = sc.nextLine();

        //inici peticio HTTP
        ServerRequest.createLocationRequest(name_dst, name_src, arrive, dateString, distancia);

    }


    /** fi funcionalitats classe **/
}
