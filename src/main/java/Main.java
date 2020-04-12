import Model.*;
import Model.Route;
import Utilities.Menu;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        JsonModel jsonModel = new JsonModel();
        int opcio = 0;
        User user;
        ArrayList<Location> jsonLocations = new ArrayList<>(jsonModel.getDataModel().getLocations());
        ArrayList<Location> locations_searched = new ArrayList<>();
        ArrayList<Location> locations_created = new ArrayList<>();
        ArrayList<LocationFav> locations_fav = new ArrayList<>();
        ArrayList<Route> routes_created = new ArrayList<>();

        //get new user info
        user = Menu.userInfoMenu();

        while(opcio != 5){
            opcio = Menu.menu();

            switch (opcio){
                case 1:
                    Menu.userMenuU(locations_created, locations_fav, locations_searched, routes_created, user, jsonLocations);
                    break;
                case 2:
                    Location.findAndInsertLocations(jsonLocations, locations_created, locations_searched, locations_fav);
                    break;
                case 3:
                    Location.routePlanifier(jsonLocations, routes_created);
                    break;
                case 4:
                    Location.busTime();
                    break;
                default:
                    if(opcio != 5) {
                        System.out.println("Opcio incorrecta");
                    }
                    break;
            }
        }

        JsonModel.insertIntoJsonUsers(locations_created, locations_fav, locations_searched, user);
    }
}
