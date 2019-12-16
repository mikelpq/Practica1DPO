package Menu;

import DataModel.User;
import JsonModel.JsonModel;

import java.util.Scanner;

public class Menu {
    public static void userInfo(){
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


        //INTRODUIR AL JSON
        JsonModel.insertIntoJsonUsers(user);

    }

    public static int menu(){
        Scanner sc = new Scanner(System.in);
        int opcio;

        System.out.println(" 1. Gestió usuari\n 2.Buscar localitzacions\n 3. Planejar ruta\n 4.Temps espera del bus\n 5. Sortir\n\n Selecciona una opció:");
        opcio = sc.nextInt();

        return opcio;
    }


}
