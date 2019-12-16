import DataModel.DataModel;
import JsonModel.JsonModel;
import Menu.Menu;

public class Main {
    public static void main(String[] args) {
        JsonModel jsonModel = new JsonModel();
        DataModel dataModel  = jsonModel.getDataModel();
        int opcio = 0;

        //get new user info
        Menu.userInfo();

        while(opcio != 5){
            opcio = Menu.menu();

            switch (opcio){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    if(opcio != 5) {
                        System.out.println("Opcio incorrecta");
                    }
                    break;
            }
        }


    }
}
