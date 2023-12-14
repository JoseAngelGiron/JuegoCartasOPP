package Controller;

import Model.Game;
import Model.Player;
import View.Menu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Objects;


public class MainController {

    public static Game game;

    /**
     * Esta función inicia la aplicación. Se encarga de llamar a la vista inicial para mostrar el menu principal
     * y pasarle la opción que ha introducido el usuario a la función del controlador principal
     */
    public static void startApp(){
        int option =-1;
        do{

                option = Menu.mainMenu();
                mainController(option);

                if(option>3 || option<1)
                    System.out.println("La opción seleccionada no esta contemplada, pruebe de nuevo por favor");


        }while(option!=3);

    }

    /**
     * La función de controlador principal, el cual se encarga de poner en marcha el juego, mostrar reglas y mostrar el mensaje de despedida
     * @param option recibe un entero, en este caso opción, para hacer cada una de las opciones
     */
    public static void mainController(int option) {


        switch (option) {
            case 1:
                game = new Game();
                step1(game);

                String repeat;
                do {

                    game.startGame();
                    stateOfPlay(game);

                    step2PlayersTurn(game);
                    step3IAsTurn(game);
                    showEndOfGame(game);
                    repeat = Menu.selectAnotherRound();

                } while (!Objects.equals(repeat, "n"));
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


    /**
     * Esta función calcula los puntos iniciales y actualiza la opción de blackjack si algún jugador tiene dicha combinación en su mano.
     * Muestra también el estado inicial de la partida. Hace uso de las funciones calculatePointes, updateBlackjack y stateOfGame
     * @param game que es el objeto de la clase game instanciamos al inicio del juego y que contiene los datos sobre la partida y jugadores.
     */
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

    /**
     * Ejecuta el 1º paso del juego, en este pedir número de jugadores y validar los nombres de los jugadores. Llama tanto a la vista para introducir nombres
     * como a la función checkNames para validar nombre.
     * @param game que es un objeto de la clase game sobre el que se modifican datos
     */
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

    /**
     * Esta función ejecuta el turno de los jugadores, pasando por todos y cada uno de ellos y les permite ejecutar acciones
     * Hace uso de función de la vista, para introducir la opción que quiera el usuario y otras funciones de game para recuperar información
     * que mostrar al usuario
     * @param game recibe un objeto de la game, sobre el que hará calculos
     */
    public static void step2PlayersTurn(Game game){
        int playerTurn = 1;

        do {

            try{
                Thread.sleep(320);
                System.out.println(game.getPlayers()[playerTurn].getName() +" es tu turno: \n");

            } catch (InterruptedException e) {

            }
            int option = Menu.selectOption();
            game.playerTurn(option, playerTurn);

            switch (option){
                case 1:
                    try{
                        Thread.sleep(320);
                        System.out.println("Has terminado tu turno, cuando acabe la ronda veremos los resultados.");
                    } catch (InterruptedException e) {

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

                    }

                    game.updateBlackJack();

                    if(game.getPlayers()[playerTurn].getPoints()>21) {
                        try {
                            Thread.sleep(520);
                            System.out.println("Te has pasado de 21, y has sido eliminado");
                        } catch (InterruptedException e) {

                        }

                        playerTurn++;
                    }
                    break;

            }




        }while (playerTurn <game.getPlayers().length);


    }

    /**
     * Esta función ejecuta el turno de la IA. Hace uso de las funciones de recalcular puntos calculateMaxPoints.
     * @param game que es un objeto de la clase game, sobre el que se harán calculos
     */
    public static void step3IAsTurn(Game game) {
        game.reCalculatePoints();




        System.out.println("La IA va a pedir cartas..... o no...");

        game.dealerWantsCards();
        try{
            Thread.sleep(320);
            System.out.println("La mano de la IA es: ");
            Thread.sleep(520);
            System.out.println(game.returnHand(game.getPlayers()[0]));

        }catch (InterruptedException e) {

        }


        if(game.getPlayers()[0].getPoints()>21) {
            System.out.println("La IA se ha pasado de 21, y ha sido eliminada");

        }

    }

    /**
     * Esta función muestra el resultado del final del juego
     * @param game que es un objeto de la clase game, sobre el que se harán calculos
     */
    public static void showEndOfGame(Game game) {

        game.reCalculatePoints();
        int howManyWinners = game.calculateWinners(game.calculateMaxPoints());



        if(howManyWinners==0){
            System.out.println("No ha habido ganadores, todos los jugadores se pasaron de 21.");
        }else if (howManyWinners==1) {
            for (Player player: game.getPlayers()) {
                if(player.getPoints()==game.calculateMaxPoints() ) {
                    System.out.println("El ganador es: " + player.getName() + " con " +player.getPoints()+"  puntos!");
                    player.setWinner(1);
                    if (player.isBlackJack())
                        System.out.println("Ademas, lo ha hecho con un blackjack :)");
                }
            }
        }else{
            System.out.println("Ha habido un empate entre los jugadores: ");
            for (Player player: game.getPlayers()) {
                if (player.getPoints()== game.calculateMaxPoints())
                    System.out.println(player.getName());
            }

        }
    }

    /**
     * Esta función imprime los resultados de cuantas victorias ha tenido cada jugador
     * @param game sobre el que se harán los calculos
     */
    public static void printResults(Game game){


        String rutaArchivo = ".//RankingBlackjack.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            String jugadores =      "    RRRR    AAAAA  NNN   N   K   K  III  NNN   N   GGGG  \n" +
                                    "    R   R   A   A  N N   N   K  K    I   N N   N  G      \n" +
                                    "    RRRR    AAAAA  N  N  N   K K     I   N  N  N  G  GGG \n" +
                                    "    R R     A   A  N   N N   K  K    I   N   N N  G    G \n" +
                                    "    R  RR   A   A  N    NN   K   K  III  N    NN   GGGG  \n\n\n";
            for (Player player: game.getPlayers()) {
                jugadores += player.getName() + " Ha ganado: " + player.getWinner()+ " partidas \n\n";
            }

            bw.write(jugadores);


            System.out.println("Se ha escrito en el archivo correctamente. \n\n");
        }catch (java.io.IOException e) {

        }
    }
}
