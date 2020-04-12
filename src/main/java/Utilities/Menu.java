package Utilities;

import Model.*;
import Model.Route;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    /** get user info anc create new user **/
    public static User userInfoMenu(){
        Scanner sc = new Scanner(System.in);
        String name, mail;
        int year;
        User user;

        System.out.println("Benvingut a l'aplicació TMBJson! Si us plau, introdueix les dades que se't demanen.");
        System.out.println("Nom d'usuari: ");
        name = sc.nextLine();
        System.out.println("Correu electrònic: ");
        mail = sc.nextLine();
        System.out.println("Any de naixement: ");
        year = sc.nextInt();

        user = new User(name, mail, year);

        return user;
    }

    /** MAIN MENU **/
    public static int menu(){
        Scanner sc = new Scanner(System.in);
        int opcio;

        System.out.println(" 1. Gestió usuari\n 2. Buscar localitzacions\n 3. Planejar ruta\n 4. Temps espera del bus\n 5. Sortir\n\n Selecciona una opció:");
        opcio = sc.nextInt();

        return opcio;
    }

    /** SUB MENU OPCIO 1: GESTIO USUARI **/
    public static void userMenuU(ArrayList<Location> location_created, ArrayList<LocationFav> location_fav, ArrayList<Location> location_searched, ArrayList<Route> routes, User user, ArrayList<Location> jsonLocations) throws IOException {
        Scanner sc = new Scanner(System.in);
        String opcio = "";

        while (!opcio.equals("f")){
            System.out.println(" a) Les meves localitzacions \n b) Historial de localitzacions \n c) Les meves rutes \n d) Parades i estacions preferides \n e) Estacions inaugurades el meu any de naixement \n f) Tornar al menú principal");
            opcio = sc.nextLine();
            switch (opcio){
                case "a":
                    User.userCreateLocations(location_created, jsonLocations);
                    break;
                case "b":
                    User.userSearchedLocations(location_searched);
                    break;
                case "c":
                    User.userCreatedRoutes(routes);
                    break;
                case "d":
                    User.userNearStations(location_fav);
                    break;
                case "e":
                    User.userSameYearStations(user);
                    break;
                case "f":
                    break;
                default:
                    System.out.println("Error, lletra incorrecte");
            }
        }
    }


}
