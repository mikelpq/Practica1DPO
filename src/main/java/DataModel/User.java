package DataModel;

import java.util.Scanner;

public class User {
    private String name;
    private String mail;
    private int year;

    public User(String name, String mail, int year){
        this.name = name;
        this.mail = mail;
        this.year = year;
    }

    public void userHistoryLocations(DataModel dataModel){
        boolean stop = false;
        Scanner sc = new Scanner(System.in);
        String opcio;

        while (!stop){
            System.out.println("Vols crear una nova localització?");
            if ((opcio = sc.nextLine()).toLowerCase().equals("si") || (opcio = sc.nextLine()).toLowerCase().equals("no")){
                stop = true;
            }else{
                System.out.println("Error! S'ha d'introduir si o no");
            }
        }

        stop = false;

        while(!stop){
            for (int i = 0; i < dataModel; i++) {

            }
        }



    }
}