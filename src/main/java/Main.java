import Utilities.Menu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        JsonModel jsonModel = new JsonModel();
        String opcio = "";
        User user;

        //get new user info
        user = Menu.userInfoMenu();

        System.out.println("Benvingut a l'aplicacio de TMBJson " + user.getName());
        do{
            opcio = Menu.menu();

            switch (opcio){
                case "1":
                    Menu.userMenuU(user, jsonModel.getDataModel().getLocations());
                    break;
                case "2":
                    Location.findLocations(jsonModel.getDataModel().getLocations(), user.getLocations_created(), user.getLocations_searched(), user.getLocations_fav());
                    break;
                case "3":
                    Location.routePlanifier(jsonModel.getDataModel().getLocations(), user.getRoutes_created());
                    break;
                case "4":
                    Location.busTime();
                    break;
                default:
                    if(!opcio.equals("5")) {
                        System.out.println("Opcio incorrecta");
                    }
                    break;
            }
        }while (!opcio.equals("5"));

        JsonModel.insertIntoJsonUsers(user);
    }
}
