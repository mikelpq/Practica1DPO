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
    //opcio 1-A: crear localitzacions i veure les creades
    public static void userCreatedLocations(ArrayList<Location> locations){
        boolean stop = false, found = false;
        Scanner sc = new Scanner(System.in);
        String opcio, name, desc;
        float[] coordinates = new float[2];

        name = "";
        opcio = "";

        while (!stop){
            System.out.println("Vols crear una nova localització?(si/no)");
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
                System.out.println("Nom de la localització: ");
                name = sc.nextLine();
                for (int i = 0; i < locations.size() && !found; i++) {
                    if (name.equals(locations.get(i).getName())){
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

            //creem nova localitzacio
            Location location = new Location(name, coordinates, desc);
            //afegim la nova localitzacio
            locations.add(location);

        }
    }

    //OPCIO 1-B: veure les localitzacions buscades a la opcio 2
    public static void userSearchedLocations(ArrayList<Location> location){
        if (location.size() == 0){
            System.out.println("Encara no has buscat cap localització!\n Per buscar-ne una, accedeix a l'opció 2 del menú principal.");
        }else{
            System.out.println("Localitzacions buscades: ");
            for (int i = 0; i < location.size(); i++) {
                System.out.println("  - " + location.get(i).getName());
            }
        }
    }

    /** fi funcioanlitats classe **/
}