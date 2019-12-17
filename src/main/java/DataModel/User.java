package DataModel;

import JsonModel.JsonModel;

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
        boolean stop = false, found = false;
        Scanner sc = new Scanner(System.in);
        String opcio, name, desc;
        float[] coordiantes = new float[2];

        name = "";
        opcio = "";

        while (!stop){
            System.out.println("Vols crear una nova localització?");
            opcio = sc.nextLine();
            if (opcio.toLowerCase().equals("si") || opcio.toLowerCase().equals("no")){
                stop = true;
            }else{
                System.out.println("Error! S'ha d'introduir si o no");
            }
        }

        if (opcio.equals("si")){
            stop = false;

            //bucle que no parara fins que no s'hagi crear una localitzacio
            while(!stop){
                System.out.println("Nom de la localització: ");
                name = sc.nextLine();
                for (int i = 0; i < dataModel.getLocations().size() && !found; i++) {
                    if (name.equals(dataModel.getLocations().get(i).getName())){
                        found = true;
                    }
                }

                if (found){
                    System.out.println("Error! Aquesta localització ja existeix");
                    found = false;
                }else{
                    stop = true;
                }
            }

            System.out.println("Latitud: ");
            coordiantes[0] = sc.nextFloat();
            System.out.println("Latitud: ");
            coordiantes[1] = sc.nextFloat();
            System.out.println("Descripció");
            desc = sc.nextLine();

            Location location = new Location(name, coordiantes, desc);

            JsonModel.insertIntoJsonLocations(location);
        }


    }
}