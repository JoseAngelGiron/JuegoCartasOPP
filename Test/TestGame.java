package Test;

import Model.Card;
import Model.Deck;
import Model.Player;
import Model.Game;




public class TestGame {

    public static void main(String[] args) {

        //Aqui empieza. Creamos el mazo principal
        Deck mainDeck = new Deck();
        mainDeck.createDeck();

        //Con esta parte repartiríamos 2 cartas a cada jugador. A la IA y a los jugadores
        Player deckP1 = new Player();
        Player deckIA = new Player();



        for(int i =0;i<49;i++){

            mainDeck.dealCards(deckP1.getCards());

        }
        mainDeck.dealCards(deckP1.getCards());


        System.out.println(mainDeck.howManyCardsInDeck());

        System.out.println(mainDeck);



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