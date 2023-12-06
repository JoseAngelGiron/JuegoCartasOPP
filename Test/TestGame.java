package Test;

import Model.Card;
import Model.Deck;
import Model.Player;
import Model.Game;




public class TestGame {

    public static void main(String[] args) {

        Deck deck = new Deck();
        Deck deckP1 = new Deck();
        deck.createDeck();
        deck.addCard(deckP1.getCards());
        System.out.println(deckP1);
        System.out.println(" ");
        System.out.println(deck);
        System.out.println(deck.howManyNulls());

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