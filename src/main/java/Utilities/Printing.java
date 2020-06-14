package Utilities;

import BusTime.BusTime;
import Route;
import RouteResponse.ResponseJson;
import Location;
import Stop.Stop;

import java.util.ArrayList;

public class Printing {

    //OPCIO 1-B: veure les localitzacions buscades a la opcio 2
    public static void userSearchedLocations(ArrayList<Location> location){
        if (location.isEmpty()){
            System.out.println(" Encara no has buscat cap localització!\n Per buscar-ne una, accedeix a l'opció 2 del menú principal.\n");
        }else{
            System.out.println(" Localitzacions buscades: ");
            for (int i = 0; i < location.size(); i++) {
                System.out.println("  - " + location.get(i).getName());
            }
        }
        System.out.println("\n");
    }

    //OPCIO 1-C: veure les rutes creades a la opcio 3
    public static void userCreatedRoutes(ArrayList<Route> routes){
        if (routes.isEmpty()){
            System.out.println(" Encara no has realitzat cap ruta :( \n Per buscar-ne una, accedeix a l'opció 3 del menú principal\n");
        }else{
            for (int i = 0; i < routes.size(); i++) {
                System.out.println(" -> Ruta " + (i+1) );
                System.out.println("\t - Origen: " + routes.get(i).getOrigin());
                System.out.println("\t - Destiny: " + routes.get(i).getDestiny());
                System.out.println("\t - Dia de sortida " + routes.get(i).getDate() + " a les " + routes.get(i).getTime());
                System.out.println("\t - Màxima distància caminant:" + routes.get(i).getDistance());
                Printing.showRoute(routes.get(i).getRoute());
            }
        }
    }

    /** PRINTING OPCIO 1-D **/
    public static void showNearStationsFromFavorite(ArrayList<Location> locations, Location current){
        System.out.println(" " + current.getName());
        for (int i = 0; i < locations.size(); i++) {
            System.out.println("\t" + i + ") " + locations.get(i).getName() + " (" + locations.get(i).getCodiLinia() + ") " + locations.get(i).getTipusTransport());
        }
        System.out.println("\n");
    }
    /** PRINTING OPCIO 1-E **/
    public static void showSameYearStations(ArrayList <Stop> stops){
        for (int i = 0; i < stops.size(); i++) {
            Stop current = stops.get(i);
            System.out.println("\t" + current.getNom_estacio() + " " + current.getPicto());
        }
        System.out.println("\n");
    }

    /** PRINTING OPCIO 3 **/
    public static void showRoute(ResponseJson responseJson){
        int durada = responseJson.getPlan().getItineraries().get(0).getDuration();
        int index = 0;
        int temps;

        System.out.println(" - Combinació més ràpida: ");
        //busquem el trajecte més curt
        for (int i = 1; i < responseJson.getPlan().getItineraries().size(); i++) {
            if (durada > responseJson.getPlan().getItineraries().get(i).getDuration()){
                durada = responseJson.getPlan().getItineraries().get(i).getDuration();
                index = i;
            }
        }

        durada = durada / 60;

        System.out.println("\tTemps del trajecte: "  + durada + " min");

        //recorrem totes les parades del trajecte
        System.out.println("\t " + responseJson.getPlan().getItineraries().get(index).getLegs().get(0).getFrom().getName());
        System.out.println("\t |");
        for (int i = 0; i < responseJson.getPlan().getItineraries().get(index).getLegs().size(); i++) {

            temps = responseJson.getPlan().getItineraries().get(index).getLegs().get(i).getDuration() / 60;

            if (responseJson.getPlan().getItineraries().get(index).getLegs().get(i).getMode().equals("WALK")){
                System.out.println("\t caminar " + temps  + " min");
            }else{
                System.out.println("\t " + responseJson.getPlan().getItineraries().get(index).getLegs().get(i).getRoute() + " " +
                        responseJson.getPlan().getItineraries().get(index).getLegs().get(i).getFrom().getName() + "(" +  responseJson.getPlan().getItineraries().get(index).getLegs().get(i).getFrom().getStopCode()
                        + ")-> " +
                        responseJson.getPlan().getItineraries().get(index).getLegs().get(i).getPlace().getName() + "(" +  responseJson.getPlan().getItineraries().get(index).getLegs().get(i).getPlace().getStopCode() + ")"
                        + " " + temps + " min"
                );
            }
            System.out.println("\t |");
        }
        System.out.println("\t Destí \n\n");
    }

    /** PRINTING OPCIO 4 **/
    public static void showBusLinesFromStop(BusTime busTime, Stop stop, int codiParada){
        String current = "";
        for (int i = 0; i < busTime.getData().getIbus().size(); i++) {
            for (int j = 0; j < stop.getFeatures().size(); j++) {
                if (stop.getFeatures().get(j).getProperties().getCodi_parada() == codiParada) {
                    current = stop.getFeatures().get(j).getProperties().getNom_parada();
                }
            }
            System.out.println(busTime.getData().getIbus().get(i).getLine() + " - " + current + " - " + busTime.getData().getIbus().get(i).getTextCa());
        }
        System.out.println("\n");
    }
}
