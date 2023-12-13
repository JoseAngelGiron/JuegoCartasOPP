package Model;

import java.util.Arrays;
import java.util.Random;


public class Deck {

    private Card[] cards;


    public Deck(){
        this(new Card[52]);
    }
    public Deck(Card[] cards){
        this.cards = cards;
    }


    public Card[] getCards() {
        return cards;
    }


    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Deck{" + "cards=" + Arrays.toString(cards) + '}';
    }


    /**
     * Esta función instancia el mazo con cada una de las figuras, palos y valores que tiene la baraja del blackjack
     * arreglo de cartas y la instancia con cada uno de los palos de 1 a 10 y las figuras
     *
     */
    public void createDeck(){
        String[] suits = {"♦","♠","♥","♣"};
        String[] figures ={"A","J","Q","K"};
        int index=0;
        for (String suit: suits) {

            for(int i =1;i<=10;i++){
                    if(i==1) {
                        cards[index++] = new Card(i, suit, figures[0]);
                    }else{
                        cards[index++] = new Card(i, suit, " ");
                    }
                if(i==10){
                    for (int j=1;j<=3;j++){
                    cards[index++] = new Card(i,suit,figures[j]);
                    }

            }

        }

    }
    }



    /**
     *
     * Esta función se encarga de repartir las 2 primeras cartas a cada jugador.
     * Elimina las cartas del mazo que va pasando con la función de remove card
     *
     *
     * @param players recibe el arreglo de jugadores
     *
     */
    public void dealInitialCards(Player[] players ) {
            for (Player player:players) {
                Card[] card = player.getHand();
                for(int i=0;i<=1;i++){
                    Card cardToPass = cards[searchCardPosition()];
                    removeCard(searchCardPosition());
                    card[i] = cardToPass;

                }
                player.setHand(card);
            }
    }

    /**
     * Esta función recibe un jugador y da una carta al jugador que se le pasa.
     * Hace uso de la función nullPosition para averiguar la primera posición que apunta a nulo en la mano del jugador
     * Hace uso de la función removeCard para eliminar la carta del mazo cuando se la damos al jugador.
     * @param player recibe un jugador de jugadores
     */
    public void dealACard(Player player){

            int nullPosition = firstNullPosition(player.getHand());
            int cardPosition =  searchCardPosition();
            Card cardToDeal = cards[cardPosition];
            player.getHand()[nullPosition] = cardToDeal;
            cards[cardPosition] = null;



    }

    /**
     * Esta función me devuelve la posición del primer elemento nulo de un arreglo.
     *
     * @param cards el arreglo de cartas sobre el que se hace la comprobación
     * @return position, que es la posición del 1º elemento nulo del arreglo.
     */
    public int firstNullPosition(Card[] cards){
        int position =0;
        for (int i =0 ; i< cards.length && position==0;i++) {
            if(cards[i]==null){
                position = i;
            }
        }
        return position;
    }


    public void removeCard(int i){
        cards[i] = null;
    }

    /**
     * Esta función devuelve una carta, la primera que encuentra, seleccionada aleatoriamente entre todas las del mazo.
     * Si la posición de la carta seleccionada es nula (o sea, no hay nada), selecciona otra posición y por tanto, otra carta.
     * @return Devuelve la posicion de la carta encontrada en la posición que le hemos dado.
     */
    public int searchCardPosition() {
        int cardPosition;
        Card cardToEvaluate;
        do {
            cardPosition = (int) (Math.random() * (52));
            cardToEvaluate = cards[cardPosition];

        } while (cardToEvaluate == null);
        return cardPosition;
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

}
