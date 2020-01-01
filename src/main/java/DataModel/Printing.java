package DataModel;

import BusTimeResponse.BusTime;
import RouteResponse.*;

public class Printing {

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
                        responseJson.getPlan().getItineraries().get(index).getLegs().get(i).getTo().getName() + "(" +  responseJson.getPlan().getItineraries().get(index).getLegs().get(i).getTo().getStopCode() + ")"
                        + " " + temps + " min"
                );
            }
            System.out.println("\t |");
        }
        System.out.println("\t Destí \n\n");
    }

    public static void showBusLinesFromStop(BusTime busTime){

        for (int i = 0; i < busTime.getData().getIbus().size(); i++) {
            System.out.println(busTime.getData().getIbus().get(i).getLine() + " - " + busTime.getData().getIbus().get(i).getRouteId() + " - " + busTime.getData().getIbus().get(i).getTInMin());
        }
    }
}
