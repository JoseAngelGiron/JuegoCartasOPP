package Model;

import java.util.Random;

public class Deck {

    private static  Card[] cards = new Card[52];


    /**
     * Esta función instancia un arreglo de cartas.
     * Recibe el arreglo de cartas y los instancia con cada uno de los palos de 1 a 13
     * @return
     */
    public static Card[] createDeck(){
        String[] suits = {"Diamantes","Picas","Corazones","Trebol"};
        int index=0;
        for (String suit: suits) {

            for(int i =1;i<=13;i++){
                cards[index++] = new Card(i,suit);

            }

        }
        shuffle();
        return cards;
    }

    public static void shuffle(){

        Random rand = new Random();

        // Mezclar el arreglo de forma aleatoria usando el algoritmo de Fisher-Yates
        for (int i = cards.length - 1; i > 0; i--) {
            int indiceAleatorio = rand.nextInt(i + 1);

            // Intercambiar los elementos en las posiciones i e indiceAleatorio
            Card temp = cards[i];
            cards[i] = cards[indiceAleatorio];
            cards[indiceAleatorio] = temp;

        }
    }

    public  void removeCard(){


    }
    public  void getCard(){


    }

    public static int deckSize(Card[] cards){


        return cards.length;
    }





}
