import DataModel.*;
import JsonModel.JsonModel;
import Menu.Menu;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        JsonModel jsonModel = new JsonModel();
        DataModel dataModel  = jsonModel.getDataModel();
        int opcio = 0;
        User user;
        ArrayList<Location> locations_searched = new ArrayList<>();
        ArrayList<Location> locations_created = new ArrayList<>();
        ArrayList<Location> locations_fav = new ArrayList<>();
        ArrayList<Route> routes_created = new ArrayList<>();



        //get new user info
        user = Menu.userInfo();

        while(opcio != 5){
            opcio = Menu.menu();

            switch (opcio){
                case 1:
                    Menu.userMenuU(locations_created, locations_fav, locations_searched, routes_created, user);
                    break;
                case 2:
                    Location.findAndInsertLocations(dataModel, locations_created, locations_fav, locations_searched);
                    break;
                case 3:
                    Location.routePlanifier(dataModel, routes_created);
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
