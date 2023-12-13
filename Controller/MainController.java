package Controller;

import Model.Game;
import Model.Player;
import View.Menu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;


public class MainController {

    static Game game;

    public static void startApp(){
        int option =-1;
        do{

                option = Menu.mainMenu();
                mainController(option);

                if(option>3 || option<1)
                    System.out.println("La opción seleccionada no esta contemplada, pruebe de nuevo por favor");


        }while(option!=3);

    }

    public static void mainController(int option) {


        switch (option) {
            case 1:
                //Instanciamos el nuevo juego
                game = new Game();
                step1(game);

                String repetir;
                do {

                    game.startGame(game);
                    stateOfPlay(game);

                    step2PlayersTurn(game);
                    int maxScore = step3IAsTurn(game);
                    showEndOfGame(game, maxScore);
                    repetir = Menu.selectAnotherRound();

                } while (!Objects.equals(repetir, "n"));
                String print = Menu.printResults();
                if(Objects.equals(print, "s"))
                    printResults(game);

                break;
            case 2:
                Menu.rules();
                break;
            case 3:
                System.out.println("Ha elegido salir del casino. ¡Que pase buen día!  ");
                break;

        }


    }




    public static void stateOfPlay(Game game){
        game.calculatePoints();
        game.updateBlackJack();

        try{
            Thread.sleep(320);
            System.out.println("Se estan repartiendo las cartas.....");
            Thread.sleep(320);
            System.out.println(game.stateOfGame());
        } catch (InterruptedException e) {

        }

    }

    public static void step1(Game game){


        int numberOfPlayers = Menu.selectNPlayers();
        game.addPlayers(numberOfPlayers);

        int count=0;
        do{

            String name =Menu.selectNamePlayer(count);
            boolean validName =game.checkNames(name);
            if(validName){
                game.addNamePlayer(name);
                count++;
            }else{
                System.out.println("El nombre del jugador no puede contener espacios en blanco ni tampoco ser el de otro jugador");
            }
        }while (count<numberOfPlayers);

    }

    public static void step2PlayersTurn(Game game){
        int playerTurn = 1;

        do {

            try{
                Thread.sleep(320);
                System.out.println(game.getPlayers()[playerTurn].getName() +" es tu turno: \n");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int option = Menu.selectOption();
            game.playPlayerTurn(option, game, playerTurn);

            switch (option){
                case 1:
                    try{
                        Thread.sleep(320);
                        System.out.println("Has pasado turno, veremos los resultados cuando acabe la ronda");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    playerTurn++;
                    break;

                case 2:
                    try {
                        Thread.sleep(530);
                        System.out.println("Este es el estado actual de tu mano:");
                        Thread.sleep(300);
                        System.out.println(game.returnHand(game.getPlayers()[playerTurn]));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    stateOfPlay(game);
                    break;
                case 4:
                    try {
                        Thread.sleep(530);
                        System.out.println("Aqui tienes !! tus cartas actualmente son:");
                        Thread.sleep(320);
                        System.out.println(game.returnHand(game.getPlayers()[playerTurn]));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    game.updateBlackJack();

                    if(game.getPlayers()[playerTurn].getPoints()>21) {
                        try {
                            Thread.sleep(520);
                            System.out.println("Te has pasado de 21, y has sido eliminado");
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                        playerTurn++;
                    }
                    break;

            }




        }while (playerTurn <game.getPlayers().length);


    }

    public static int step3IAsTurn(Game game) {

        int maxScore =0;
        game.reCalculatePointsIfBlackjack();

        for (Player player:game.getPlayers()) {
            if(player.getPoints() <=21  && player.getPoints()>maxScore)
                maxScore=player.getPoints();
        }
        System.out.println("La IA va a pedir cartas..... o no...");

        /* Con esta instrucción valoro si la IA ya tiene un blackjack o si ya hay un blackjack por parte de alguno de los jugadores,
            en cuyo caso, no pide cartas, bien porque ya ha ganado o ya ha perdido, respectivamente.
         */


            while (game.getPlayers()[0].getPoints()<maxScore) {
                game.playDealerTurn(game);
            }

        System.out.println("La mano de la IA es: ");
        System.out.println(game.returnHand(game.getPlayers()[0]));

        if(game.getPlayers()[0].getPoints()>21) {
            System.out.println("La IA se ha pasado de 21, y ha sido eliminada");

        }
        return maxScore;
    }

    public static void showEndOfGame(Game game, int maxScore) {
        int howManyWinners = game.calculateWinner(maxScore);
        int amountOfBlackjacks = game.howManyBlackjacks();

        if(amountOfBlackjacks==1){
            for (Player player: game.getPlayers()) {
                if(player.isBlackJack())
                    System.out.println("El ganador, que ademas tiene blackjack, es : "+ player.getName() +" !!");
                player.setWinner(1);
            }
        } else if (amountOfBlackjacks>=2) {
            System.out.println("Hay mas de un jugador con un blackjack, y por tanto hay un empate entre:");
            for (Player player: game.getPlayers()) {
                System.out.println(player.getName());
            }
        }else if(howManyWinners==0){
            System.out.println("No ha habido ganadores, todos los jugadores se pasaron de 21.");
        }else if (howManyWinners==1) {
            for (Player player: game.getPlayers()) {
                if(player.getPoints()==maxScore ) {
                    System.out.println("El ganador es: " + player.getName() + "!!");
                    player.setWinner(1);
                }
            }
        }else{
            System.out.println("Ha habido un empate entre los jugadores: ");
            for (Player player: game.getPlayers()) {
                if (player.getPoints()==maxScore)
                    System.out.println(player.getName());
            }

        }
    }

    public static <IOException> void printResults(Game game){

        // Especifica la ruta del archivo en el que deseas escribir
        String rutaArchivo = ".//RankingBlackjack.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            String jugadores =      "    RRRR    AAAAA  NNN   N   K   K  III  NNN   N   GGGG  \n" +
                                    "    R   R   A   A  N N   N   K  K     I   N N   N  G      \n" +
                                    "    RRRR    AAAAA  N  N  N   K K      I   N  N  N  G  GGG \n" +
                                    "    R R     A   A  N   N N   K  K     I   N   N N  G    G \n" +
                                    "    R  RR   A   A  N    NN   K   K  III    N    NN  GGGG  \n\n\n";
            for (Player player: game.getPlayers()) {
                jugadores += player.getName() + " Ha ganado: " + player.getWinner()+ " partidas \n";
            }

            bw.write(jugadores);


            System.out.println("Se ha escrito en el archivo correctamente.");
        }catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }
}
