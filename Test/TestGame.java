package Test;


import Model.Deck;
import Model.Game;
import Model.Player;


import java.util.Arrays;
import java.util.Scanner;


public class TestGame {

    public static void main(String[] args) {
        // Game loop
        // Aquí empieza, pongo el nuevo juego

        Game game = new Game();
        //String name = "            peepe        ";
        //System.out.println(name.trim());
        // Pido el número de jugadores y creo los jugadores. ESTA FUNCIÓN ESTA EN PRUEBA PIDE POR TECLADO SIN PRINT, OJO
        //PASAR A LA VISTA.
        //Scanner teclado = new Scanner(System.in);
        //int numOfPlayers = teclado.nextInt();

        //Player[] players = game.addPlayer(numOfPlayers);
        //System.out.println(Arrays.toString(players));

        //Creo el nuevo mazo
        game.getDeck().createDeck();
        System.out.println(game.getDeck());


        //MENSAJE DE BIENVENIDA WELCOME TO BLACKJACK

        //Con esta parte repartiríamos 2 cartas a cada jugador.
        //A continuación, se calculan los puntos
        //game.getDeck().dealInitialCards(players);

        //System.out.println(Arrays.toString(players));
        //game.calculatePoints(players);


        //Muestro las cartas de cada jugador y de la IA.
        //game.showHands(players);
        //game.checkBust();

        //Comprobamos si algún jugador tiene blackJack. Llamamos a la función de updateBlackJack para comprobarlo.
        //game.updateBlackJack(players);

        //Repartimos cartas a los jugadores que lo pidan













        /**
         * mainDeck.dealCards(deckP1.getCards());
         *         mainDeck.dealCards(deckP1.getCards());
         *         mainDeck.dealCards(deckP1.getCards());
         *         mainDeck.dealCards(deckP1.getCards());
         *         mainDeck.dealCards(deckP1.getCards());
         *
         *         System.out.println(deckP1);
         *         System.out.println(deckP1.howManyCardsInDeck()); //6
         *
         *
         */


        /*

        System.out.println(deckIA);
        System.out.println(" ");
        System.out.println(mainDeck);
        System.out.println(mainDeck.howManyNulls());


         */



        /*
        Game game =new Game();
        game.addCard(, );
         */






    }

}

/*

int max puntos =0;

for(jugador j:jugador){
    if(j.calculaPuntos<=21 && j.calculaPuntos >maxPuntos){
        maxPuntos = j.calculaPuntos();
        }

}
while(yo.calculapuntos()<maxpuntos){
    yo.pideCartas()
    }

 */