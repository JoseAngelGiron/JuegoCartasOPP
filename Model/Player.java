package Model;


import java.util.Arrays;

public class Player {

    private Card[] cards = new Card[20];
    private int puntos=0;



    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Player{" +
                "cards=" + Arrays.toString(cards) +
                '}';
    }
}
