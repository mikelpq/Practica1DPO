package Model;

import Model.Stop.Feature;
import Model.Stop.Stop;
import Utilities.Haversine;
import Utilities.Printing;
import Controller.ServerRequest;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
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
    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public int getYear() {
        return year;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    /** fi metodes classe **/



    /** funcionalitats classe **/

    //opcio 1-A: crear localitzacions i veure les creades
    public static void userCreateLocations(ArrayList<Location> locations, ArrayList<Location> jsonLocations){
        boolean stop = false, found = false;
        Scanner sc = new Scanner(System.in);
        String opcio, name, desc;
        double[] coordinates = new double[2];

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
                for (int i = 0; i < jsonLocations.size(); i++) {
                    //System.out.println(name +  " vs " + locations.get(i).getName());
                    if (name.equals(jsonLocations.get(i).getName())){
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
            Double input = Double.parseDouble(sc.next());
            coordinates[0] = input;
            System.out.println("Longitud: ");
            input = Double.parseDouble(sc.next());
            coordinates[1] = input;
            System.out.println("Descripció");
            desc = sc.next();

            //creem nova localitzacio
            Location location = new Location(name, coordinates, desc);
            //afegim la nova localitzacio al usuari i al datamodel
            locations.add(location);
            //jsonModel.getUserCreatedLocations().add(location);
        }
    }


    //OPCIO 1-B: veure les localitzacions buscades a la opcio 2
    public static void userSearchedLocations(ArrayList<Location> location){
        if (location.isEmpty()){
            System.out.println(" Encara no has buscat cap localització!\n Per buscar-ne una, accedeix a l'opció 2 del menú principal.\n");
        }else{
            System.out.println("Localitzacions buscades: ");
            for (int i = 0; i < location.size(); i++) {
                System.out.println("  - " + location.get(i).getName());
            }
        }
    }


    //OPCIO 1-C: veure les rutes creades a la opcio 3
    public static void userCreatedRoutes(ArrayList<Route> routes){
        if (routes.isEmpty()){
            System.out.println(" Encara no has realitzat cap ruta :( \n Per buscar-ne una, accedeix a l'opció 3 del menú principal\n");
        }else{
            for (int i = 0; i < routes.size(); i++) {
                System.out.println("->Ruta " + (i+1) );
                System.out.println("\t - Origen: " + routes.get(i).getOrigin());
                System.out.println("\t - Destiny: " + routes.get(i).getDestiny());
                System.out.println("\t - Dia de sortida " + routes.get(i).getDate() + " a les " + routes.get(i).getTime());
                System.out.println("\t - Màxima distància caminant:" + routes.get(i).getDistance());
                Printing.showRoute(routes.get(i).getRoute());
            }
        }
    }


    //OPCIO 1-D:
    public static void userNearStations(ArrayList<LocationFav> locations) throws IOException {
        Stop stationsBus, stationsMetro;
        ArrayList<Location> solution = new ArrayList<>();

        if (locations.isEmpty()){
            System.out.println("Error, no hi ha localitzacions preferides");
        }else {
            stationsBus = ServerRequest.createStationsRequest(true);
            stationsMetro = ServerRequest.createStationsRequest(false);

            for (int i = 0; i < locations.size(); i++) {
                searchInRadius(locations.get(i), stationsBus, solution, "BUS");
                searchInRadius(locations.get(i), stationsMetro, solution, "METRO");
                sortByDistance(solution);
                Printing.showNearStationsFromFavorite(solution, locations.get(i));
                solution = new ArrayList<>();
            }
        }
    }

    private static void searchInRadius(Location current, Stop stations, ArrayList<Location> solution, String type) {
        Location location;
        for (int j = 0; j < stations.getFeatures().size(); j++) {
            int distance = Haversine.calculateDistanceByHaversineFormula(current.getCoordinates()[0], current.getCoordinates()[0], stations.getFeatures().get(j).getGeometry().getCoordinates()[0], stations.getFeatures().get(j).getGeometry().getCoordinates()[1]);
            if (distance < 501){
                location = new Location(stations.getFeatures().get(j).getProperties().getNom_estacio(),
                                        stations.getFeatures().get(j).getProperties().getCodi_grup_estacio(),
                                        type);
                solution.add(location);
                solution.get(solution.size()-1).setDistance(distance);
            }
        }
    }

    private static void sortByDistance(ArrayList<Location> solution) {
        Location key;
        for (int i = 1; i < solution.size(); ++i) {
            key = solution.get(i);
            int j = i - 1;

            while (j >= 0 && solution.get(j).getDistance() > key.getDistance()) {
                solution.set(j+1, solution.get(j));
                j = j - 1;
            }
            solution.set(j+1, key);
        }
    }

    //OPCIO 1-E: estacions innaugurades al mateix any de naixement
    public static void userSameYearStations(User user) throws IOException{
        Stop stationsYear;
        System.out.println(" Estacions innagurades el " + user.getYear());

        stationsYear = ServerRequest.createSameYearRequest(user.getYear());

        if (stationsYear != null){
            if (stationsYear.getTotalFeatures() != 0){
                ArrayList<Stop> filteredStops = new ArrayList<>();
                filterStops(stationsYear, user, filteredStops);
                Printing.showSameYearStations(filteredStops);
            }else{
                System.out.println(" Cap estació de metro es va inaugurar el teu any de naixement\n");
            }
        }
    }

    private static void filterStops(Stop stationsYear, User user, ArrayList<Stop> filteredStops) {
        for (int i = 0; i < stationsYear.getFeatures().size(); i++) {
            Feature current = stationsYear.getFeatures().get(i);
            String year = getYear(current);
            if (year.equals(String.valueOf(user.getYear()))){
                filteredStops.add(new Stop(current.getProperties().getNom_estacio(), current.getProperties().getPicto(), current.getProperties().getData_inauguracio()));
            }
        }
    }

    private static String getYear(Feature feature) {
        return feature.getProperties().getData_inauguracio().split("-")[0];
    }
    /** fi funcioanlitats classe **/
}