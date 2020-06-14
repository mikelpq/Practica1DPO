import Stop.Feature;
import Stop.Stop;
import Utilities.Haversine;
import Utilities.Printing;
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
    @SerializedName("locations_created")
    @Expose
    private ArrayList<Location> locations_created;
    @SerializedName("locations_fav")
    @Expose
    private ArrayList<LocationFav> locations_fav;

    private ArrayList<Location> locations_searched = new ArrayList<>();
    private ArrayList<Route> routes_created = new ArrayList<>();

    public User(String name, String mail, int year){
        this.name = name;
        this.mail = mail;
        this.year = year;
        this.locations_created = new ArrayList<>();
        this.locations_fav = new ArrayList<>();
        this.locations_searched = new ArrayList<>();
        this.routes_created = new ArrayList<>();
    }

    public User(String name, String mail, int year, ArrayList<Location> locations_created, ArrayList<LocationFav> locations_fav) {
        this.name = name;
        this.mail = mail;
        this.year = year;
        this.locations_created = locations_created;
        this.locations_fav = locations_fav;
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

    public ArrayList<Location> getLocations_created() {
        return locations_created;
    }

    public ArrayList<LocationFav> getLocations_fav() {
        return locations_fav;
    }

    public ArrayList<Location> getLocations_searched() {
        return locations_searched;
    }

    public ArrayList<Route> getRoutes_created() {
        return routes_created;
    }

    public void setLocations_created(ArrayList<Location> locations_created) {
        this.locations_created = locations_created;
    }

    public void setLocations_fav(ArrayList<LocationFav> locations_fav) {
        this.locations_fav = locations_fav;
    }

    public void setLocations_searched(ArrayList<Location> locations_searched) {
        this.locations_searched = locations_searched;
    }

    public void setRoutes_created(ArrayList<Route> routes_created) {
        this.routes_created = routes_created;
    }

    /** fi metodes classe **/



    /** funcionalitats classe **/

    //opcio 1-A: crear localitzacions i veure les creades
    public static void userCreateLocations(ArrayList<Location> locations, ArrayList<Location> jsonLocations){
        boolean stop = false, found = false;
        Scanner sc = new Scanner(System.in);
        String opcio, name, desc = "";
        double[] coordinates = new double[2];

        name = "";
        opcio = "";

        while (!stop){
            System.out.println("Vols crear una nova localització?(si/no)");
            opcio = sc.nextLine();
            if (opcio.toLowerCase().equals("si") || opcio.toLowerCase().equals("no") || opcio.toLowerCase().equals("sí")){
                stop = true;
            }else{
                System.out.println("Error! S'ha d'introduir si o no");
            }
        }

        if (opcio.toLowerCase().equals("si") || opcio.toLowerCase().equals("sí")){
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

            stop = false;
            while(!stop) {
                System.out.println("Longitud: ");
                double input = Double.parseDouble(sc.next());
                coordinates[1] = input;
                System.out.println("Latitud: ");
                input = Double.parseDouble(sc.next());
                coordinates[0] = input;

                String text = Double.toString(Math.abs(coordinates[0]));
                int integerPlaces = text.indexOf('.');
                int decimalPlacesLat = text.length() - integerPlaces - 1;

                text = Double.toString(Math.abs(coordinates[1]));
                integerPlaces = text.indexOf('.');
                int decimalPlacesLng = text.length() - integerPlaces - 1;

                if (decimalPlacesLat == 6 && decimalPlacesLng == 6){
                    stop = true;
                }else {
                    System.out.println("Error, format coordenades incorrecte");
                }
            }

            stop = false;
            while (!stop) {
                System.out.println("Descripció");
                desc = sc.next();
                if (desc.equals("")){
                    System.out.println("Error, descripció incorrecte");
                }else{
                    stop = true;
                }
            }
            //creem nova localitzacio
            Location location = new Location(name, coordinates, desc);
            locations.add(location);

            System.out.println(location.toString());
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
                searchInRadius(locations.get(i), stationsBus, solution, "BUS", true);
                searchInRadius(locations.get(i), stationsMetro, solution, "METRO",false);
                sortByDistance(solution);
                Printing.showNearStationsFromFavorite(solution, locations.get(i));
                solution = new ArrayList<>();
            }
        }
    }

    private static void searchInRadius(Location current, Stop stations, ArrayList<Location> solution, String type, boolean bus) {
        Location location;
        for (int j = 0; j < stations.getFeatures().size(); j++) {
            //TMB retorna les coordenades invertides
            int distance = Haversine.calculateDistanceByHaversineFormula(current.getCoordinates()[0], current.getCoordinates()[1], stations.getFeatures().get(j).getGeometry().getCoordinates()[1], stations.getFeatures().get(j).getGeometry().getCoordinates()[0]);
            if (distance < 500){
                if (bus){
                    location = new Location(stations.getFeatures().get(j).getProperties().getNom_parada(),
                            stations.getFeatures().get(j).getProperties().getCodi_parada(),
                            type);
                }else {
                    location = new Location(stations.getFeatures().get(j).getProperties().getNom_estacio(),
                            stations.getFeatures().get(j).getProperties().getId_estacio(),
                            type);
                }

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