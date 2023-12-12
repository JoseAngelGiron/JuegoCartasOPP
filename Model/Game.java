package Model;


import java.util.Arrays;
import java.util.Objects;


public class Game {
    //Atributos
    private Player[] players;

    private Deck deck;
    // java, MVC,
    // Como pasa de una pantalla a otra
    // Todo lo que me interese comentar de mejoras
    private boolean isBlackJack;

    // Constructores
    public Game() {
        this(new Player[1], new Deck(), false);

    }


    public Game(Player[] players, Deck deck, boolean isBlackJack) {
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
     * Hace uso de las funciones crear el mazo y repartir cartas.
     */
    public void startGame(Game game) {
        resetValues();
        deck.createDeck();
        deck.dealInitialCards(players);


    }


    /**
     * Esta función comprueba, tras la 2 cartas iniciales, las manos de los jugadores. Y si obtiene única combinación posible
     * de BlackJack cambia el atributo del jugador de blackJack a True
     * A partir de cuando el jugador tiene más de 2 cartas, siempre acabaría poniendo el blackjack a true
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
                    setBlackJack(true);

                } else {
                    player.setBlackJack(false);
                    setBlackJack(false);
                }
            }
        }
    }


    /**
     * Comprueba si más de un jugador tiene blackjack. Su utilidad reside en poder valorar empates entre distintos jugadores que tengan un blackjack
     *
     * @return amountOfBlacks, la cantidad de blackjacks que se han dado
     */
    public int howManyBlackjacks() {
        int amountOfBlacks = 0;
        for (Player player : players) {
            if (player.isBlackJack()) {
                amountOfBlacks += 1;
            }
        }
        return amountOfBlacks;
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
                players[i] = new Player(0, "IA", false, true, 0);
            } else {
                players[i] = new Player(0, "", false, true, 0);
            }

        }


    }

    /**
     * Esta función se encarga de comprobar nombres
     *
     * @return devuelve un arreglo de Strings con los jugadores.
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
     * Es una función diseñada para ir recalculando los puntos en el turno de los jugadores, los puntos de cada jugador.
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
     * Recalcula los puntos del jugador para averiguar si hay blackjack o no.
     * Esta función la he diseñado para recalcular los puntos si hay un blackjack (AÑADIR QUE RECALCULE PUNTOS SI TIENE UN AS)
     */
    public void reCalculatePointsIfBlackjack() {
        for (Player player : players) {
            if (player.isBlackJack())
                player.setPoints(21);

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

    public void playPlayerTurn(int option, Game game, int player) {

        if (option == 2) {//Pasar   //Plantarse
            players[player].setPlaying(false);
            calculatePoints();
        } else if (option == 5) {
            //Pedir otra carta
            game.deck.dealACard(players[player]);
            calculatePoints();
        }

    }

    public void playDealerTurn(Game game) {
        game.deck.dealACard(players[0]);
        game.calculatePoints();

    }

    public int calculateWinner(int maxScore) {
        int howManyWinners = 0;

        for (Player player : players) {
            if (player.getPoints() == maxScore || player.isBlackJack())
                howManyWinners++;
        }

        return howManyWinners;
    }

    public void resetValues() {
        for (Player player : players) {
            player.setPoints(0);
            player.setBlackJack(false);
            player.setPlaying(true);
            Arrays.fill(player.getHand(), null);
        }

    }
}
