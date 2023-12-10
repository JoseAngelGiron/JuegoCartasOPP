package Model;



import java.util.Arrays;
import java.util.Objects;


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
                        '}';
                }

        /**
                 * Esta función se encarga de iniciar el juego.
                 * Recibe funciones XXXX
                 */
                public void startGame(){
                        deck.createDeck();
                        deck.dealInitialCards(players);



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
                 * Esta función se encarga de establecer los jugadores. Instancia la cantidad de jugadores
                 * @param numberOfPlayers recibe el número de jugadores.
                 *
                 */
                public void addPlayers ( int numberOfPlayers ){


                        Player[] players = new Player[numberOfPlayers+1];
                        setPlayers(players);
                        for (int i=0;i<players.length;i++){
                                if(i==0) {
                                    players[i] = new Player(0, "IA", false, true);
                                } else  {
                                    players[i] = new Player(0, "", false, true);
                                }

                        }


                }

                /**
                 * Esta función se encarga de comprobar nombres
                 *
                 * @return devuelve un arreglo de Strings con los jugadores
                 */
                public boolean checkNames (String name){
                        boolean validName = true;

                        for (int i = 0; i < players.length && validName; i++) {
                                if (((players[i].getName()).equalsIgnoreCase(name)) || name.trim().isEmpty()) {
                                        validName = false;
                                }
                        }
                        return validName;

                }


        /**
         * Esta función recopila el estado de la partida en general y devuelve los datos.
         * @return una cadena de texto, con los datos de todos los jugadores.
         */
        public String stateOfGame(){
                        String state="";
                        for (Player player:players){

                                state += player.getName()+"\n";
                                state += "Puntos: " + player.getPoints()+"\n";
                                Card[] mano = player.getHand();
                                for (int j=0;j< mano.length && mano[j]!=null ;j++){
                                        state += mano[j]+"\n";
                                }
                                state+="\n";
                        }
                        return state;

                }

        /**
         * Calcula los puntos de cada una de las manos del jugador y se los asigna.
         * Es una función diseñada para ir recalculando a lo largo de la partida los puntos de cada jugador.
         */
        public void calculatePoints(){
                        for (Player player : players) {
                            Card[] mano = player.getHand();
                            int puntos = 0;
                            for (int j = 0; j < mano.length && mano[j] != null; j++) {
                                puntos += mano[j].getValue();
                            }
                            player.setPoints(puntos);
                        }


                }

        /**
         * Asigna los nombres a los jugadores
         * @param name recibe una cadena de texto, en este caso un nombre para dar al jugador
         */
        public void addNamePlayer(String name) {
                        boolean noAsigned = true;
                        for (int i=0;i<players.length && noAsigned;i++) {
                                if(Objects.equals(players[i].getName(), "")){
                                        players[i].setName(name);
                                        noAsigned =false;

                                }


                        }

                }
}
