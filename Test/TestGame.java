package Test;

import Model.Card;
import Model.Deck;
import Model.Player;




public class TestGame {

    public static void main(String[] args) {

        Deck deck = new Deck();
        deck.createDeck();
        System.out.println(deck);



    }

}
/*
int max puntos =0;ç

for(jugadir j:jugador){
    if(j.calculaPuntos<=21 && j.calculaPuntos >maxPuntos){
        maxPuntos = j.calculaPuntos();
        }

}
while(yo.calculapuntos()<maxpuntos){
    yo.pideCartas()
    }
 */