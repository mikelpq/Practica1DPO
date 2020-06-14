import BusTime.BusTime;
import BusTime.Ibu;
import Stop.Stop;
import Utilities.Printing;
import RouteResponse.ResponseJson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.util.*;

public class Location {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("coordinates")
    @Expose
    private double[] coordinates;
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
    //atributs per opcio 1-d
    private int codiLinia;
    private String tipusTransport;
    private int distance;


    public Location(String name, double[] coordinates, String description) {
        this.name = name;
        this.coordinates = coordinates;
        this.description = description;
    }

    public Location(String name, int codiLinia, String tipusTransport){
        this.name = name;
        this.codiLinia = codiLinia;
        this.tipusTransport = tipusTransport;
    }


    /** inici metodes classe **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public String getDescription() {
        return description;
    }

    public String getArchitect() {
        return architect;
    }

    public int getInnaguration() {
        return innaguration;
    }

    public String[] getCharacteristics() {
        return characteristics;
    }

    public int getStars() {
        return stars;
    }

    public int getCodiLinia() {
        return codiLinia;
    }

    public String getTipusTransport() {
        return tipusTransport;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    /** fi metodes classe **/




    /** inici funcionalitats classe **/
    //OPCIO 2
    public static void findLocations(ArrayList<Location> jsonLocations, ArrayList<Location> locations_created, ArrayList<Location> locations_searched, ArrayList<LocationFav> locations_fav){
        int index = 0;
        String place = "", desc = "", user_input, type = "";
        double[] coord = new double[2];
        boolean stop = false, positive = false;
        Scanner sc = new Scanner(System.in);

        while (!stop) {
            System.out.println("Introdueix el nom d'una localitzacio:");
            user_input = sc.nextLine();

            //busquem dins el fitxer de localitzacions
            for (int i = 0; i < jsonLocations.size(); i++) {
                if (jsonLocations.get(i).getName().equals(user_input)) {
                    stop = true;
                    index = i;
                    place = user_input;
                    //mostrem la restant info de la localitzacio en cas que existeixi o un missatge d'error
                    System.out.println("Posicio: " + Arrays.toString(jsonLocations.get(index).getCoordinates()));
                    coord = jsonLocations.get(index).getCoordinates();
                    System.out.println("Descripcio: ");
                    desc = jsonLocations.get(index).getDescription();
                    System.out.println(jsonLocations.get(index).getDescription());
                }
            }
            //busquem dins les localitzacions creades a l'opcio 1
            for (int i = 0; i < locations_created.size(); i++) {
                if (locations_created.get(i).getName().equals(user_input)) {
                    stop = true;
                    index = i;
                    place = user_input;
                    //mostrem la restant info de la localitzacio en cas que existeixi o un missatge d'error
                    System.out.println("   Posicio: " + Arrays.toString(locations_created.get(index).getCoordinates()));
                    coord = locations_created.get(index).getCoordinates();
                    System.out.println("   Descripcio: ");
                    desc = locations_created.get(index).getDescription();
                    System.out.println("   " + locations_created.get(index).getDescription());
                }
            }
            if (!stop) System.out.println(" Error, no hi ha cap localització amb aquest nom");
        }


        stop = false;
        boolean found = false;

        while (!stop){
            for (int i = 0; i < locations_fav.size(); i++) {
                if (locations_fav.get(i).getName().equals(place)){
                    System.out.println(" Aquesta localització està guardada com a preferida");
                    found = true;
                    stop = true;
                }
            }
            if (!found) {
                System.out.println(" Vols guardar la localització trobada com a preferida? (sí/no)");
                user_input = sc.nextLine();
                if (user_input.toLowerCase().equals("si") || user_input.toLowerCase().equals("no") || user_input.toLowerCase().equals("sí")) {
                    stop = true;
                    if (user_input.toLowerCase().equals("si") || user_input.toLowerCase().equals("sí")) {
                        stop = false;
                        while (!stop) {
                            System.out.println("Tipus(casa/feina/estudis/oci/cultura):");
                            user_input = sc.nextLine();
                            user_input = user_input.toLowerCase();
                            if (user_input.equals("casa") || user_input.equals("feina") || user_input.equals("estudis") || user_input.equals("oci") || user_input.equals("cultura")) {
                                type = user_input;
                                //en cas que es desitji s'afegira la nova localització
                                locations_fav.add(new LocationFav(place, coord, desc, type));
                                System.out.println(place + " s'ha assignat com a una nova localització preferida.");
                                stop = true;
                            } else {
                                System.out.println("Error! S'ha d'introduir \"casa\", \"feina\", \"estudis\", \"oci\" o \"cultura\".");
                            }
                        }
                    }
                } else {
                    System.out.println("Error! S'ha d'introduir si o no");
                }
            }
        }

        locations_searched.add(new Location(place, coord, desc));
    }



    //OPCIO 3
    public static void routePlanifier(ArrayList<Location> jsonLocations, ArrayList<Route> route){
        boolean found = false;
        int i;
        Scanner sc = new Scanner(System.in);
        String name_src = "", name_dst = "", kk = "", arrive = "true", distancia = "0", coor_src = "", coor_dst = "";
        double[] coordinates_src = new double[2], coordinates_dst = new double[2];
        String origen = "", desti = "";

        //comprovem si existeix el origen
        while(!found){
            System.out.println("Origen? (lat,lon/ nom localització)");
            //comprovem si s'introdueix el nom de la localitzacio o les coordenades
            name_src = sc.nextLine();
            
            //separem la string per la coma
            String[] res = name_src.split(",");

            if (res.length > 1){
                if (res.length > 2){
                    System.out.println("ERROR! Format incorrecte");
                }else{
                    try{
                        coordinates_src[1] = Double.parseDouble(res[1]);
                        coordinates_src[0] = Double.parseDouble(res[0]);
                    }catch (NumberFormatException e){
                        e.printStackTrace();
                    }
                }
            }

            i = 0;

            while(!found && i < jsonLocations.size()){
                if (name_src.equals(jsonLocations.get(i).getName())){
                    coor_src = jsonLocations.get(i).getCoordinates()[1] + ", " + jsonLocations.get(i).getCoordinates()[0];
                    found = true;
                    i = 0;
                    origen = jsonLocations.get(i).getName();
                }

                if (coordinates_src[1] == jsonLocations.get(i).getCoordinates()[0] && coordinates_src[0] == jsonLocations.get(i).getCoordinates()[1]){
                    coor_src = coordinates_src[0] + ", " + coordinates_src[1];
                    found = true;
                    i = 0;
                    origen = jsonLocations.get(i).getName();
                }

                i++;
            }

            if (!found) {
                String text = Double.toString(Math.abs(coordinates_src[0]));
                int integerPlaces = text.indexOf('.');
                int decimalPlacesLat = text.length() - integerPlaces - 1;

                text = Double.toString(Math.abs(coordinates_src[1]));
                integerPlaces = text.indexOf('.');
                int decimalPlacesLng = text.length() - integerPlaces - 1;

                if (decimalPlacesLat == 6 && decimalPlacesLng == 6) {
                    found = true;
                }
            }

            if (!found){
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
                        coordinates_dst[1] = Double.parseDouble(res[1]);
                        coordinates_dst[0] = Double.parseDouble(res[0]);
                    }catch (NumberFormatException e){
                        e.printStackTrace();
                    }
                }
            }
            i = 0;
            while(!found && i < jsonLocations.size()){
                if (name_dst.equals(jsonLocations.get(i).getName())){
                    coor_dst = jsonLocations.get(i).getCoordinates()[1] + ", " + jsonLocations.get(i).getCoordinates()[0];
                    found = true;
                    i = 0;
                    desti = jsonLocations.get(i).getName();
                }

                if (coordinates_dst[1] == jsonLocations.get(i).getCoordinates()[0] && coordinates_dst[0] == jsonLocations.get(i).getCoordinates()[1]){
                    coor_dst = coordinates_dst[0] + ", " + coordinates_dst[1];
                    found = true;
                    i = 0;
                    desti = jsonLocations.get(i).getName();
                }

                i++;
            }

            if (!found) {
                String text = Double.toString(Math.abs(coordinates_dst[0]));
                int integerPlaces = text.indexOf('.');
                int decimalPlacesLat = text.length() - integerPlaces - 1;

                text = Double.toString(Math.abs(coordinates_dst[1]));
                integerPlaces = text.indexOf('.');
                int decimalPlacesLng = text.length() - integerPlaces - 1;

                if (decimalPlacesLat == 6 && decimalPlacesLng == 6) {
                    found = true;
                }
            }

            if (!found){
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
        String timeString = sc.next();
        sc.nextLine();

        System.out.println("Maxima distancia caminant en metres?");
        distancia = sc.nextLine();

        //inici peticio HTTP
        ResponseJson responseJson = ServerRequest.createRouteRequest(coor_src, coor_dst, arrive, dateString, timeString, distancia);
        if (responseJson != null) {
            if (responseJson.getPlan().getItineraries().isEmpty()) {
                System.out.println("TMB està fent tot el possible perquè el bus i el metro facin aquesta ruta en un futur.\n");
            } else {
                //guardem ruta
                Route new_route = new Route(origen, desti, dateString, timeString, distancia, responseJson);
                route.add(new_route);
                //printem ruta
                Printing.showRoute(responseJson);
            }
        }
    }

    //OPCIO 4
    public static void busTime() throws IOException {
        Scanner sc = new Scanner(System.in);
        int parada = 0;
        BusTime busTime = null;
        Stop stationsBus = null;
        boolean ok = false, ko = false;

        while(!ok) {
            System.out.println("Introdueix el codi de parada: ");

            if (!sc.hasNextInt()){
                System.out.println("Error, format incorrecte");
                sc.next();
            }else{
                parada = sc.nextInt();
                //crida a la request
                busTime = ServerRequest.createBusTimeRequest(String.valueOf(parada));
                stationsBus = ServerRequest.createStationsRequest( true);
                //sorting by waiting time
                sortByTime(busTime);

                if (!busTime.getData().getIbus().isEmpty()){
                    ok = true;
                }
            }
        }
        //printem
        Printing.showBusLinesFromStop(busTime ,stationsBus, parada);
    }

    private static void sortByTime(BusTime solution) {
        Ibu key;
        for (int i = 1; i < solution.getData().getIbus().size(); ++i) {
            key = solution.getData().getIbus().get(i);
            int j = i - 1;

            while (j >= 0 && solution.getData().getIbus().get(j).getTInS() > key.getTInS()) {
                solution.getData().getIbus().set(j+1, solution.getData().getIbus().get(j));
                j = j - 1;
            }
            solution.getData().getIbus().set(j+1, key);
        }
    }
    /** fi funcionalitats classe **/

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", coordinates=" + Arrays.toString(coordinates) +
                ", description='" + description + '\'' +
                '}';
    }
}
