package Controller;

import Model.Game;
import Model.Player;
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
                stateOfPlay(game);

                step2Players(game);
                int score = step3IA(game);
                showWinner(game, score);

                //game.playDealerTurn();


            case 2:
                System.out.println("Ha elegido salir del casino. ¡Que pase buen día!");
                break;


        }


    }



    public static void showWinner(Game game, int maxScore) {
        Player[] players = game.getPlayers();
        for (Player player:players) {
            if(player.isPlaying() && player.getPoints() == maxScore)
                System.out.println("El ganador es: "+player.getName()+ "!!");


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
        game.updateBlackJack();
        game.checkBust();
        System.out.println(game.stateOfGame());

    }

    public static void step2Players(Game game){
        int playerTurn = 1;
        boolean validTurn = true;
        do {
            do {
                if (!game.getPlayers()[playerTurn].isPlaying()) {
                    validTurn = false;
                    playerTurn++;
                }
            }while (!validTurn);
            System.out.println("Jugador "+ game.getPlayers()[playerTurn].getName() + ": ");
            int option = Menu.selectOption();
            game.playPlayerTurn(option, game, playerTurn); //¿HACER ESTO ES UNA BUENA PRÁCTICA O LA HE CAGADO MUCHO?

            switch (option){
                case 1:
                    System.out.println("Has pasado turno");
                    playerTurn++;
                    break;
                case 2:
                    System.out.println("Te has plantado. Se calcularan tus puntos y se te mostrara el resultado.");
                    System.out.println(game.getPlayers()[playerTurn++].getPoints());
                    //System.out.println(game.checkBust());
                    break;
                case 3: // ver tu mano
                    System.out.println("Este es el estado actual de tu mano:");
                    System.out.println(game.returnHand(game.getPlayers()[playerTurn]));
                    break;
                case 4: // ver el estado de la partida
                    stateOfPlay(game);
                    break;
                case 5:// Pedir otra carta (aquí le muestro su mano y sus puntos actuales)
                    System.out.println("Aqui tienes !! tus cartas actualmente son:");
                    System.out.println(game.returnHand(game.getPlayers()[playerTurn]));
                    game.checkBust();
                    if(!game.getPlayers()[playerTurn].isPlaying()) {
                        System.out.println("Te has pasado de 21, y has sido eliminado");
                        playerTurn++;
                    }
                    break;

            }




        }while (playerTurn <game.getPlayers().length);


    }

    public static int step3IA(Game game) {

        int maxScore =0;

        for (Player player:game.getPlayers()) {
            if(player.getPoints()>maxScore)
                maxScore=player.getPoints();
        }
        System.out.println("La IA va a pedir cartas.....");
        while (game.getPlayers()[0].getPoints()<maxScore){
            game.playDealerTurn(game);

        }
        System.out.println("La mano de la IA es: ");
        System.out.println(game.returnHand(game.getPlayers()[0]));



        return maxScore;
    }



}
