package Model;


import java.util.Arrays;

public class Player {

    private Card[] hand = new Card[20];
    private int points;
    private String name;

    private boolean blackJack;


    public Player(){
        this( 0,"Name", false);

    }


    public Player(int points, String name, boolean blackJack) {
        this.points = points;
        this.name = name;
        this.blackJack = blackJack;

    }



    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Card[] getHand() {
        return hand;
    }

    public void setHand(Card[] hand) {
        this.hand = hand;
    }

    public boolean isBlackJack() {
        return blackJack;
    }

    public void setBlackJack(boolean blackJack) {
        this.blackJack = blackJack;
    }

    public  int howManyCardsInDeck(){
        int acu =0;

        for (int i=0; i<hand.length ; i++){
            if(this.hand[i]!=null){
                acu++;

            }
        }
        return acu;
    }


    @Override
    public String toString() {
        return "Player" + name + ", points=" + points + Arrays.toString(hand);

    }
}
