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
     * Recibe el arreglo de cartas y la instancia con cada uno de los palos de 1 a 13
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

            // Intercambiar los elementos en las posiciones e indiceAleatorio
            Card temp = cards[i];
            cards[i] = cards[indiceAleatorio];
            cards[indiceAleatorio] = temp;

        }
    }

    /**
     * Esta función se encarga de repartir cartas a las manos de cada usuario.
     * Hace uso de la función nullPosition para averiguar la primera posición nula del arreglo
     * y poder devolv
     * @param cards
     */
    public void dealCards(Card[] cards ) {
        int cardsToDeal = 2;
        int index = 0;
        if(cards[0]!=null) {
            index = nullPosition(cards);
            cardsToDeal=1;
        }

        for (int i = 1; i <= cardsToDeal; i++) {
            int cardPosition = (int) (Math.random() * (51));
            cards[index++] = getCard(cardPosition);
            removeCard(cardPosition);
        }

    }

    /**
     * Esta función me devuelve la posición del primer elemento nulo de un arreglo.
     *
     * @param cards el arreglo de cartas sobre el que se hace la comprobación
     * @return position, que es la posición del 1º elemento nulo del arreglo.
     */
    public int nullPosition(Card[] cards){
        int position =0;
        for (int i =0 ; i< cards.length && position==0;i++) {
            if(cards[i]==null){
                position = i;
            }
        }
        return position;
    }


    public void removeCard(int i){
        this.cards[i] = null;
    }
    public Card getCard(int i){
        return cards[i];
    }

    /**
     * Función que he hecho para comprobar la longitud de en un mazo.
     * No tiene ninguna utilidad más alla del testeo
     *
     */
    public int deckSize(){
        return cards.length;
    }

    /**
     * Función que he hecho para comprobar que cuantas cartas tiene un mazo
     * No tiene ninguna utilidad más alla del testeo
     *
     */
    public  int howManyCardsInDeck(){
        int acu =0;

        for (int i=0; i<cards.length ; i++){
            if(this.cards[i]!=null){
                acu++;

            }
        }
        return acu;
    }

    @Override
    public String toString() {
        return "Deck{" + "cards=" + Arrays.toString(cards) + '}';
    }
}
