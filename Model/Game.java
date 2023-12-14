package Model;


import java.util.Arrays;
import java.util.Objects;


public class Game {

    private Player[] players;

    private Deck deck;


    public Game() {
        this(new Player[1], new Deck());

    }


    public Game(Player[] players, Deck deck) {
        this.players = players;
        this.deck = deck;
    }



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






    @Override
    public String toString() {
        return "Game{" +
                "players=" + Arrays.toString(players) +
                '}';
    }

    /**
     * Esta función se encarga de iniciar el juego.
     * Hace uso de las funciones crear el mazo y repartir cartas y de resetValues
     */
    public void startGame() {
        resetValues();
        deck.createDeck();
        deck.dealInitialCards(players);
    }


    /**
     * Esta función comprueba, tras la 2 cartas iniciales, las manos de los jugadores. Y si obtiene única combinación posible
     * de BlackJack cambia el atributo del jugador de blackJack a True
     * A partir de cuando el jugador tiene más de 2 cartas, nunca pondrá blackjack a true
     */
    public void updateBlackJack() {

        for (Player player : players) {
            int acu = 0;
            boolean as = false;
            Card[] cards = player.getHand();
            for (int j = 0; j < cards.length && cards[j] != null; j++) {

                if (cards[j].getValue() == 1)
                    as = true;

                acu += cards[j].getValue();
                if (acu == 11 && j == 1 && as) {
                    player.setBlackJack(true);


                } else {
                    player.setBlackJack(false);

                }
            }
        }
    }



    /**
     * Esta función se encarga de establecer los jugadores. Instancia la cantidad de jugadores que se le pasa
     *
     * @param numberOfPlayers recibe el número de jugadores.
     */
    public void addPlayers(int numberOfPlayers) {


        Player[] players = new Player[numberOfPlayers + 1];
        setPlayers(players);
        for (int i = 0; i < players.length; i++) {
            if (i == 0) {
                players[i] = new Player(0, "IA", false, 0);
            } else {
                players[i] = new Player(0, "", false, 0);
            }

        }


    }

    /**
     * Esta función se encarga de comprobar nombres
     *
     * @return devuelve verdadero, si el nombre esta disponible y falso si no cumple con las condiciones impuestas.
     */
    public boolean checkNames(String name) {
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
     *
     * @return una cadena de texto, con los datos de todos los jugadores.
     */
    public String stateOfGame() {
        String state = "";
        for (Player player : players) {

            Card[] mano = player.getHand();
            for (int j = 0; j < mano.length && mano[j] != null; j++) {
                state += mano[j] + "\n";
            }
            state += player.getName() + "\n";
            state += "Puntos: " + player.getPoints() + "\n";
            state += "\n";
        }
        return state;

    }

    /**
     * Esta función devuelve los datos de la mano actual de un jugador
     *
     * @param player recibe el jugador sobre el que se va a recopilar la información
     * @return hand, es decir, la información de los puntos y las cartas de la mano.
     */
    public String returnHand(Player player) {
        String hand = "";


        for (int j = 0; j < player.getHand().length && player.getHand()[j] != null; j++) {
            hand += player.getHand()[j] + "\n";
        }
        hand += "Puntos: " + player.getPoints() + "\n";

        return hand;
    }


    /**
     * Calcula los puntos de cada una de las manos del jugador y se los asigna.
     * Es una función diseñada para ir recalculando los puntos en el turno de los jugadores.
     */
    public void calculatePoints() {
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
     * Recalcula los puntos del jugador para averiguar si hay blackjack o no y establecer los puntos que corresponden, así como si el jugador tiene un AS y su puntuación es menor a 11
     * Esta función está diseñada para recalcular puntos en el momento que la IA entra en juego
     */
    public void reCalculatePoints() {
        boolean as;

        for (Player player : players) {
            if (player.isBlackJack())
                player.setPoints(21);

        }

        for (Player player:players) {
            as = false;

            for (int i=0;i<=player.getHand().length && player.getHand()[i] != null; i++){
                if(player.getHand()[i].getValue()==1)
                    as = true;
                }
            if(as && player.getPoints()<11) {
                player.setPoints(player.getPoints() + 10);
            }

        }



    }

    /**
     * Asigna los nombres a los jugadores
     *
     * @param name recibe una cadena de texto, en este caso un nombre para dar al jugador
     */
    public void addNamePlayer(String name) {
        boolean noAsigned = true;
        for (int i = 0; i < players.length && noAsigned; i++) {
            if (Objects.equals(players[i].getName(), "")) {
                players[i].setName(name);
                noAsigned = false;

            }


        }

    }

    /**
     *  Esta función se usa para determinar cambios que provienen del controlador.
     *
     * @param option la opción, en función de la cual ejecutara
     * @param player recibe el número del jugador, que usaremos para añadir cartas o verificar si ya no esta jugador
     */
    public void playerTurn(int option, int player) {

        if (option == 1) {
            calculatePoints();
        } else if (option == 4) {
            deck.dealACard(players[player]);
            calculatePoints();
        }

    }

    /**
     * Esta función hace que la IA reciba una carta y calcula sus puntos en función de la carta que ha recibido
     * Hace uso de las funciones dealACard y calculatePoints
     */
    public void dealerReceiveACard() {
        deck.dealACard(players[0]);
        calculatePoints();


    }

    /**
     * Esta función calcula los ganadores, su función es la de comprobar si hay un ganador o mas de uno
     * @param maxScore recibe un entero, que es la puntuación máxima
     * @return la cantidad de jugadores que coinciden con la puntuación máxima.
     */
    public int calculateWinners(int maxScore) {
        int howManyWinners = 0;

        for (Player player : players) {
            if (player.getPoints() == maxScore || player.isBlackJack())
                howManyWinners++;
        }

        return howManyWinners;
    }

    /**
     * Esta función resetea los valores a por defecto de todos los jugadores, se utiliza al inicio de cada ronda para no tener en cuenta los valores anteriores.
     * Pero sin tocar los valores de aquellos jugadores que han ganado partidas
     */
    public void resetValues() {
        for (Player player : players) {
            player.setPoints(0);
            player.setBlackJack(false);
            Arrays.fill(player.getHand(), null);
        }

    }

    /**
     * Función que averigua cual es la máxima puntuación dentro de la partida
     * @return la puntuación máxima de entre todos los jugadores
     */
    public int calculateMaxPoints(){
        int maxPoints=0;

        for (Player player: players) {
            if(player.getPoints() <=21  && player.getPoints()>maxPoints)
                maxPoints=player.getPoints();
        }

        return maxPoints;
    }

    /**
     * Función que hace que la IA pida cartas mientras este por debajo de los puntos del jugador con mas puntos
     * Hace uso de las funciones calculateMaxPoints y dealerWantsCards
     */
    public void dealerWantsCards(){
        while (getPlayers()[0].getPoints()<calculateMaxPoints()) {
            dealerReceiveACard();
            reCalculatePoints();
        }
    }
}
