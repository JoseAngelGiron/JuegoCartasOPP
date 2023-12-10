package Controller;

import Model.Game;
import View.Menu;

import java.util.Arrays;


public class MainController {

    static Game game;

    public static void startApp(){
        int option =-1;
        do{

                option = Menu.mainMenu();
                mainController(option);
                if(option>2 || option<1)
                    System.out.println("La opción seleccionada no esta contemplada, pruebe de nuevo por favor");


        }while(option!=2);

    }

    public static void mainController(int option) {


        switch (option) {
            case 1:
                game = new Game();
                game.addPlayers(Menu.selectNPlayers());
                System.out.println((Arrays.toString(game.getPlayers())));
                //game.getPlayers();
                //game.startGame();
                break;
            case 2:

                break;


        }


    }
}
