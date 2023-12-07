package Model;


import javax.naming.Name;
import java.util.Scanner;

public class Game {






        public void startGame(){

        }
        public void playDealerTurn(){

        }

        /**
         * Esta función comprueba, tras la 2 cartas iniciales, las manos de los jugadores. Y si obtiene única combinación posible
         * de BlackJack cambia el atributo del jugador de blackJack a True
         * @param players Recibe un arreglo de jugadores, es decir, los jugadores que van a jugar el juego.
         */
        public void checkBlackJack(Player[] players){
                int acu =0;
                for(int i =0;i< players.length;i++) {
                        Card[] cards = players[i].getMano();
                        for (int j=0;j<cards.length && cards[j] !=null;j++) {
                                if (cards[j] != null) {
                                        acu += cards[j].getValue();
                                        if(acu==11){
                                                players[i].setBlackJack(true);
                                        }

                                }
                        }
                }

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
                Player[] players = new Player[numberOfPlayers+1];

                for (int i=0;i<players.length;i++){
                        players[i]  = new Player(0,names[i], false);
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
                String[] names = new String[numberOfPlayers+1];
                names[0] = "IA";
                for (int i =1;i< names.length; i++) {
                        name = teclado.nextLine();
                        names[i] = name;
                }


                return names;
        }

        public void calculatePoints(){


        }


}
