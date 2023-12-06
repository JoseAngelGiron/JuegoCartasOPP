package Model;

import java.util.Arrays;
import java.util.Random;

public class Deck {

    private Card[] cards = new Card[52];


    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    /**
     * Esta función instancia un arreglo de cartas.
     * Recibe el arreglo de cartas y los instancia con cada uno de los palos de 1 a 13
     * @return
     */
    public void createDeck(){
        String[] suits = {"Diamantes","Picas","Corazones","Trebol"};
        int index=0;
        for (String suit: suits) {

            for(int i =1;i<=13;i++){
                cards[index++] = new Card(i,suit);

            }

        }
        shuffle();
    }

    /**
     * Esta función baraja el arreglo. No devuelva nada porque recibe el arreglo y simplemente lo cambia de posición
     */
    public void shuffle(){

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


    public void addCard(Card[] cards) {
        Card cardToBeAdded;

        for (int i = 0; i <= 1; i++) {
            int cardPosition = (int) (Math.random() * (52));

            cardToBeAdded = this.cards[cardPosition];
            this.cards[cardPosition] = null;
            cards[i] = cardToBeAdded;

        }


    }
    public  void removeCard(){


    }
    public  void getCard(){


    }
    /**
     * Función que he hecho para comprobar la longitud de en un mazo.
     * No tiene ninguna utilidad más alla del testeo
     *
     */
    public int deckSize(Card[] cards){


        return cards.length;
    }

    /**
     * Función que he hecho para comprobar que cuantas posiciones están vacías en un mazo.
     * No tiene ninguna utilidad más alla del testeo
     *
     */
    public  int howManyNulls(){
        int acu =0;

        for (int i=0;i<cards.length; i++){
            if(this.cards[i]==null){
                acu++;

            }

        }

        return acu;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + Arrays.toString(cards) +
                '}';
    }
}
