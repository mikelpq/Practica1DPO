package DataModel;

import RouteResponse.*;

public class Route {

    public static void showRoute(String origen, String desti, String date, String time, String distancia, ResponseJson responseJson){

        int durada = responseJson.getPlan().getItineraries().get(0).getDuration();
        int index = 0;
        int temps;
        /*
        System.out.println(" - Origen: " + origen);
        System.out.println(" - Desti " +  desti);
        System.out.println(" - Dia de sortida " + date + " a les " + time);
        System.out.println(" - Màxima distància caminant: " + distancia);
         */
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
}
