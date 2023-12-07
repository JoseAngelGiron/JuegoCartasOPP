package Model;


import javax.naming.Name;
import java.util.Scanner;

public class Game {









        public void startGame(){

        }
        public void playDealerTurn(){

        }
        public void checkBlackjack(Player[] player){


        }
        public void checkBust(Player[] player){


        }

        /**
         * Esta función se encarga de establecer los jugadores. Hace uso de la función askNames. Tanto esta función como askNames están sujetas a cambios
         * @param numberOfPlayers recibe el número de jugadores
         * @return devuelve un arreglo de jugadores, con la cantidad de jugadores que le hemos pasado.
         */
        public Player[] addPlayer ( int numberOfPlayers ){
                String[] names = askNames(numberOfPlayers);
                Player[] players = new Player[numberOfPlayers];

                for (int i=0;i<numberOfPlayers;i++){
                        players[i]  = new Player(0,names[i]);
                }

                return players;
        }

        /**
         * Esta función se encarga de pedir nombres, y devolver un arreglo con todos los nombres.
         * @param numberOfPlayers Recibe la cantidad de jugadores
         * @return devuelve un arreglo de Strings con los jugadores
         */
        public String[] askNames (int numberOfPlayers){
                Scanner teclado = new Scanner(System.in);
                String name;
                String[] names = new String[numberOfPlayers];

                for (int i =0;i< names.length; i++) {
                        name = teclado.nextLine();
                        names[i] = name;
                }


                return names;
        }

        public void calculatePoints(){


        }


}
