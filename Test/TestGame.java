package Test;

import Model.Card;
import Model.Deck;




public class TestGame {

    public static void main(String[] args) {

        Card[] cards = Model.Deck.createDeck();

        for(int i=0;i<cards.length;i++){

            System.out.println(cards[i]);
        }
    }

}
