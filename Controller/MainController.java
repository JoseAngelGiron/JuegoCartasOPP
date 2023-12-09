package Controller;

import View.Menu;

public class MainController {
    public static void startApp(){
        int option =-1;
        do{
            option = Menu.mainMenu();
            mainController(option);
        }while(option!=5);

    }

    public static void mainController(int option){



    }





}
