package Menu;

import DataModel.DataModel;
import DataModel.User;
import JsonModel.JsonModel;

import java.util.Scanner;

public class Menu {
    public static User userInfo(){
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

        return user;
    }

    public static int menu(){
        Scanner sc = new Scanner(System.in);
        int opcio;

        System.out.println(" 1. Gestió usuari\n 2.Buscar localitzacions\n 3. Planejar ruta\n 4.Temps espera del bus\n 5. Sortir\n\n Selecciona una opció:");
        opcio = sc.nextInt();

        return opcio;
    }
    public static void userMenuU(DataModel dataModel, User user){
        Scanner sc = new Scanner(System.in);
        String opcio = "";

        while (!opcio.equals('f')){
            System.out.println(" a) Les meves localitzacions \n b) Historial de localitzacions \n c) Les meves rutes \n d) Parades i estacions preferides \n e)Estacions inaugurades el meu any de naixement \n f) Tornar al menú principal");
            opcio = sc.nextLine();
            switch (opcio){
                case "a":
                        User.userHistoryLocations(dataModel, user);
                    break;
                case "b":

                    break;
                case "c":
                    break;
                case "d":
                    break;
                case "e":
                    break;
                case "f":
                    break;
                default:
                    System.out.println("Error, lletra incorrecte");
            }
        }
    }


}
