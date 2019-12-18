package DataModel;

import JsonModel.JsonModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("mail")
    @Expose
    private String mail;
    @SerializedName("year")
    @Expose
    private int year;
    @SerializedName("locations")
    @Expose
    private ArrayList<Location> locations;

    public User(String name, String mail, int year){
        this.name = name;
        this.mail = mail;
        this.year = year;
    }

    /** inici metodes classe **/
    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", year=" + year +
                ", location=" + locations +
                '}';
    }

    /** fi metodes classe **/




    /** funcionalitats classe **/
    //opcio 1-A
    public static void userHistoryLocations(DataModel dataModel, User user){
        boolean stop = false, found = false;
        Scanner sc = new Scanner(System.in);
        String opcio, name, desc;
        float[] coordinates = new float[2];

        name = "";
        opcio = "";

        while (!stop){
            System.out.println("Vols crear una nova localització?");
            opcio = sc.nextLine();
            if (opcio.toLowerCase().equals("si") || opcio.toLowerCase().equals("no")){
                stop = true;
            }else{
                System.out.println("Error! S'ha d'introduir si o no");
            }
        }

        if (opcio.equals("si")){
            stop = false;

            //bucle que no parara fins que no s'hagi crear una localitzacio
            while(!stop){
                System.out.println("Nom de la localització: (si/no)");
                name = sc.nextLine();
                for (int i = 0; i < dataModel.getLocations().size() && !found; i++) {
                    if (name.equals(dataModel.getLocations().get(i).getName())){
                        found = true;
                    }
                }

                if (found){
                    System.out.println("Error! Aquesta localització ja existeix");
                    found = false;
                }else{
                    stop = true;
                }
            }

            System.out.println("Latitud: ");
            coordinates[0] = sc.nextFloat();
            System.out.println("Latitud: ");
            coordinates[1] = sc.nextFloat();
            System.out.println("Descripció");
            desc = sc.nextLine();

            Location location = new Location(name, coordinates, desc);

            JsonModel.insertIntoJsonLocations(location, user);
        }
    }

    /** fi funcioanlitats classe **/
}