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
                //Instanciamos el nuevo juego
                game = new Game();
                step1(game);
                game.startGame();
                System.out.println(Arrays.toString(game.getPlayers()));
                stateOfPlay(game);
                game.playPlayerTurn();
                game.playDealerTurn();


            case 2:

                break;


        }


    }

    public static void step1(Game game){

        //Pedimos la cantidad de jugadores y se la damos a game
        int numberOfPlayers = Menu.selectNPlayers();
        game.addPlayers(numberOfPlayers);
        //Pedimos nombres y los validamos, si son válidos, los añadimos, si no, volvemos a pedir dicho nombre
        int count=0;
        do{

            String name =Menu.selectNamePlayer();
            boolean validName =game.checkNames(name);
            if(validName){
                game.addNamePlayer(name);
                count++;
            }else{
                System.out.println("El nombre del jugador no puede contener espacios en blanco ni tampoco ser el de otro jugador");
            }
        }while (count<numberOfPlayers);

    }

    public static void stateOfPlay(Game game){
        game.calculatePoints();
        System.out.println(game.stateOfGame());

    }

    public static void step2(Game game){


    }
}
