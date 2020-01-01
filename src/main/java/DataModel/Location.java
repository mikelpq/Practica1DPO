package DataModel;

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
    //OPCIO 2
    public static void findAndInsertLocations(DataModel dataModel, ArrayList<Location> locations){
        int index = Integer.MIN_VALUE, i = 0;
        String name, desc, input;
        float[] coordinates = new float[2];
        boolean stop = true, data = false;
        Scanner sc = new Scanner(System.in);

        while (stop && i < locations.size()) {
            System.out.println("Introdueix el nom d'uan localitzacio");
            input = sc.nextLine();
            for (i = 0; i < dataModel.getLocations().size() && stop; i++) {
                if (dataModel.getLocations().get(i).getName().toLowerCase().equals(input)) {
                    stop = false;
                    data = true;
                    index = i;
                }
            }

            for (i = 0; i < locations.size() && stop; i++) {
                if (locations.get(i).getName().toLowerCase().equals(input)) {
                    stop = false;
                    index = i;
                }
            }
        }

        //mostrem la restant info de la localitzacio en cas que existeixi o un missatge d'error
        if (stop){
            System.out.println("Ho sentim, no hi ha cap localitzacio amb aquest nom");
        }else{
            if (data){
                System.out.println("Posicio: " + Arrays.toString(dataModel.getLocations().get(index).getCoordinates()));
                System.out.println("Descripcio: ");
                System.out.println(dataModel.getLocations().get(index).getDescription());
            }else {
                System.out.println("Posicio: " + Arrays.toString(locations.get(index).getCoordinates()));
                System.out.println("Descripcio: ");
                System.out.println(locations.get(index).getDescription());
            }
        }
    }


    //OPCIO 3
    public static void routePlanifier(DataModel dataModel){
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

        //printem ruta
        Route.showRoute(origen, desti, dateString, timeString, distancia, responseJson);

    }

    public static void busTime(){
        Scanner sc = new Scanner(System.in);
        String parada;
        System.out.println("Introdueix el codi de parada: ");
        parada = sc.nextLine();

        //crida a la request
    }


    /** fi funcionalitats classe **/
}
