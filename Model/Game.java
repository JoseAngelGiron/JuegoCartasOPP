package Model;



import java.util.Arrays;
import java.util.Scanner;

public class Game {
        //Atributos
        private Player[] players;

        private Deck deck;

        private boolean isBlackJack;

        // Constructores
                public Game(){
                        this(new Player[1], new Deck(),false);

                }

                public Game(Player[] players, Deck deck, boolean isBlackJack){
                        this.players = players;
                        this.deck = deck;
                        this.isBlackJack = isBlackJack;
                }
                //Constructor creado específicamente para la función addPlayer
                public Game(int numberOfPlayers) {
                        this.players = new Player[numberOfPlayers];
                }


        // Getter and Setters
                public Player[] getPlayers() {
                        return players;
                }
                public void setPlayers(Player[] players) {
                        this.players = players;
                }

                public Deck getDeck() {
                return deck;
                }

                public void setDeck(Deck deck) {
                this.deck = deck;
                }

                public boolean isBlackJack() {
                        return isBlackJack;
                }

                public void setBlackJack(boolean blackJack) {
                        isBlackJack = blackJack;
                }




                @Override
                public String toString() {
                        return "Game{" +
                                "players=" + Arrays.toString(players) +
                                ", deck=" + deck +
                                ", isBlackJack=" + isBlackJack +
                                '}';
                }

                /**
                 * Esta función se encarga de iniciar el juego.
                 * Recibe funciones XXXX
                 */
                public void startGame(){



                }
                public void playDealerTurn(Player players){



                }

                /**
                 * Esta función comprueba, tras la 2 cartas iniciales, las manos de los jugadores. Y si obtiene única combinación posible
                 * de BlackJack cambia el atributo del jugador de blackJack a True
                 * @param players Recibe un arreglo de jugadores, es decir, los jugadores que van a jugar el juego.
                 */
                public void updateBlackJack(Player[] players){
                        int acu =0;
                        for(int i =0;i< players.length;i++) {
                                Card[] cards = players[i].getHand();
                                for (int j=0;j<cards.length && cards[j] !=null;j++) {

                                        acu += cards[j].getValue();
                                        if(acu==11){
                                                players[i].setBlackJack(true);
                                                setBlackJack(true);

                                                }

                                        }
                                }
                        }



                /**
                 * Comprueba si más de un jugador tiene blackjack.
                 * @param players recibe un arreglo con todos los jugadores
                 * @return amountOfBlacks, la cantidad de blackjacks que se han dado
                 */
                private int checkBlackJack(Player[] players) {
                        int amountOfBlacks=0;
                        for (Player player:players) {
                                if(player.isBlackJack()){
                                        amountOfBlacks+=1;
                                }
                        }
                        return amountOfBlacks;
                }

                /**
                 * Comprueba si un jugador se ha pasado de 21 puntos, incluida la IA
                 * @param players Recibe el arreglo de jugadores.
                 */
                public void checkBust(Player[] players){
                        for(Player player:players)
                                player.setPlaying(player.getPoints()>21);
                        eliminatePlayer();
                }

                private void eliminatePlayer() {
                }

                /**
                 * Esta función se encarga de establecer los jugadores. Hace uso de la función askNames. Tanto esta función como askNames están sujetas a cambios
                 * @param numberOfPlayers recibe el número de jugadores
                 * @return devuelve un arreglo de jugadores, con la cantidad de jugadores que le hemos pasado.
                 */
                public void addPlayers ( int numberOfPlayers ){


                        Player[] players = new Player[numberOfPlayers];
                        setPlayers(players);
                        for (int i=0;i<players.length;i++){
                                players[i]  = new Player(0, false, true);
                        }


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

                public void showHands(Player[] players){
                        for (Player player:players){

                                System.out.println(player.getName());
                                System.out.println("Puntos: " + player.getPoints()+"\n");
                                Card[] mano = player.getHand();
                                for (int j=0;j< mano.length && mano[j]!=null ;j++){
                                        System.out.println(mano[j]);
                                }
                                System.out.println();
                        }


                }

                public void calculatePoints(Player[] players){
                        for (Player player : players) {
                            Card[] mano = player.getHand();
                            int puntos = 0;
                            for (int j = 0; j < mano.length && mano[j] != null; j++) {
                                puntos += mano[j].getValue();
                            }
                            player.setPoints(puntos);
                        }


                }



        }
