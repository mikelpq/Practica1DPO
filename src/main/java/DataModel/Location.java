package DataModel;

import BusTimeResponse.BusTime;
import RouteResponse.ResponseJson;
import ServerRequests.ServerRequest;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.*;

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
    //atribut per a l'opcio 2
    private String tipus;

    //constructor per insertar info al json
    public Location(String name, float[] coordinates, String description) {
        this.name = name;
        this.coordinates = coordinates;
        this.description = description;
    }

    public Location(String name, float[] coordinates, String description, String tipus){
        this.name = name;
        this.coordinates = coordinates;
        this.description = description;
        this.tipus = tipus;
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
    //OPCIO 2
    public static void findAndInsertLocations(DataModel dataModel, ArrayList<Location> locations_created, ArrayList<Location> locations_searched, ArrayList<Location> locations_fav){
        int index = 0, i = 0;
        String place = "", desc = "", input, type = "";
        float[] coord = new float[2];
        boolean stop = true, data = false, positive = false;
        Scanner sc = new Scanner(System.in);

        while (stop && i < locations_created.size()) {
            System.out.println("Introdueix el nom d'uan localitzacio");
            input = sc.nextLine();
            for (i = 0; i < dataModel.getLocations().size() && stop; i++) {
                if (dataModel.getLocations().get(i).getName().toLowerCase().equals(input)) {
                    stop = false;
                    data = true;
                    index = i;
                    place = input;
                }
            }

            for (i = 0; i < locations_created.size() && stop; i++) {
                if (locations_created.get(i).getName().toLowerCase().equals(input)) {
                    stop = false;
                    index = i;
                    place = input;
                }
            }
            if (stop) System.out.println("Error, no hi ha cap localització amb aquest nom");
        }

        //mostrem la restant info de la localitzacio en cas que existeixi o un missatge d'error
        if (data){
            System.out.println("Posicio: " + Arrays.toString(dataModel.getLocations().get(index).getCoordinates()));
            coord = dataModel.getLocations().get(index).getCoordinates();
            System.out.println("Descripcio: ");
            desc = dataModel.getLocations().get(index).getDescription();
            System.out.println(dataModel.getLocations().get(index).getDescription());
        }else {
            System.out.println("Posicio: " + Arrays.toString(locations_created.get(index).getCoordinates()));
            coord = locations_created.get(index).getCoordinates();
            System.out.println("Descripcio: ");
            desc = locations_created.get(index).getDescription();
            System.out.println(locations_created.get(index).getDescription());
        }

        stop = false;

        while (!stop){
            System.out.println("Vols guardar la localització trobada com a preferida? (sí/no)");
            input = sc.nextLine();
            if (input.equals("s") || input.equals("a")){
                stop = true;
                if(input.equals("s")){
                    positive = true;
                }
            }else {
                System.out.println("Error! S'ha d'introduir si o no");
            }
        }

        if (positive){
            stop = false;
            while (!stop){
                System.out.println("Tipus(casa/feina/estudis/oci/cultura):");
                input = sc.nextLine();
                input.toLowerCase();
                if (input.equals("casa") || input.equals("feina") || input.equals("estudis") || input.equals("oci") || input.equals("cultura")){
                    stop = true;
                    type = input;
                }else {
                    System.out.println("Error! S'ha d'introduir \"casa\", \"feina\", \"estudis\", \"oci\" o \"cultura\".");
                }
            }
        }
        Location location = new Location(place, coord, desc, type);
        //en cas que es desitji s'afegira la nova localització
        if (stop){
            locations_fav.add(location);
        }
        locations_searched.add(location);

    }


    //OPCIO 3
    public static void routePlanifier(DataModel dataModel, ArrayList<Route> route){
        boolean found = false;
        int i;
        Scanner sc = new Scanner(System.in);
        String name_src = "", name_dst = "", kk = "", arrive = "true", distancia = "0", coor_src = "", coor_dst = "";
        float[] coordinates_src = new float[2], coordinates_dst = new float[2];
        String origen = "", desti = "";

        //comprovem si existeix el origen
        while(!found){
            System.out.println("Origen? (lat,lon/ nom localització)");
            //comprovem si s'introdueix el nom de la localitzacio o les coordenades
            name_src = sc.nextLine();

            String[] res = name_src.split(",");

            if (res.length > 1){
                if (res.length > 2){
                    System.out.println("ERROR! Format incorrecte");
                }else{
                    try{
                        coordinates_src[1] = Float.parseFloat(res[1]);
                        coordinates_src[0] = Float.parseFloat(res[0]);
                    }catch (NumberFormatException e){
                        e.printStackTrace();
                    }
                }
            }

            i = 0;

            while(!found && i < dataModel.getLocations().size()){

                if (name_src.equals(dataModel.getLocations().get(i).getName())){
                    coor_src = dataModel.getLocations().get(i).getCoordinates()[1] + ", " + dataModel.getLocations().get(i).getCoordinates()[0];
                    found = true;
                    i = 0;
                    origen = dataModel.getLocations().get(i).getName();
                }

                if (coordinates_src[1] == dataModel.getLocations().get(i).getCoordinates()[0] && coordinates_src[0] == dataModel.getLocations().get(i).getCoordinates()[1]){
                    coor_src = coordinates_src[1] + ", " + coordinates_src[0];
                    found = true;
                    i = 0;
                    origen = dataModel.getLocations().get(i).getName();
                }

                i++;
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
                        coordinates_dst[1] = Float.parseFloat(res[1]);
                        coordinates_dst[0] = Float.parseFloat(res[0]);
                    }catch (NumberFormatException e){
                        e.printStackTrace();
                    }
                }
            }

            i = 0;

            while(!found && i < dataModel.getLocations().size()){
                if (name_dst.equals(dataModel.getLocations().get(i).getName())){
                    coor_dst = dataModel.getLocations().get(i).getCoordinates()[1] + ", " + dataModel.getLocations().get(i).getCoordinates()[0];
                    found = true;
                    i = 0;
                    desti = dataModel.getLocations().get(i).getName();
                }

                if (coordinates_dst[1] == dataModel.getLocations().get(i).getCoordinates()[0] && coordinates_dst[0] == dataModel.getLocations().get(i).getCoordinates()[1]){
                    coor_dst = coordinates_dst[1] + ", " + coordinates_dst[0];
                    found = true;
                    i = 0;
                    desti = dataModel.getLocations().get(i).getName();
                }

                i++;;
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
        ResponseJson responseJson = ServerRequest.createLocationRequest(coor_src, coor_dst, arrive, dateString, timeString, distancia);

        //guardem ruta
        Route new_route = new Route(name_src, name_dst, dateString, timeString, distancia, responseJson);
        route.add(new_route);

        //printem ruta
        Printing.showRoute(responseJson);

    }

    //OPCIO 4
    public static void busTime(){
        Scanner sc = new Scanner(System.in);
        String parada;
        BusTime busTime;
        System.out.println("Introdueix el codi de parada: ");
        parada = sc.nextLine();

        //crida a la request
        busTime = ServerRequest.createBusTimeRequest(parada);

        //printem
        Printing.showBusLinesFromStop(busTime);
    }


    /** fi funcionalitats classe **/
}
