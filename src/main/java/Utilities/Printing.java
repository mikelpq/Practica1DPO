package Utilities;

import Model.BusTime.BusTime;
import Model.RouteResponse.ResponseJson;
import Model.Location;
import Model.Stop.Feature;
import Model.Stop.Stop;

import java.util.ArrayList;

public class Printing {
    /** PRINTING OPCIO 1-D **/
    public static void showNearStationsFromFavorite(ArrayList<Location> locations, Location current){
        System.out.println(" " + current.getName());
        for (int i = 0; i < locations.size(); i++) {
            System.out.println("\t" + locations.get(i).getName() + " (" + locations.get(i).getCodiLinia() + ") " + locations.get(i).getTipusTransport());
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
