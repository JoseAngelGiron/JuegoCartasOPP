package Model;


import java.util.Arrays;

public class Player {

    private Card[] hand = new Card[20];
    private int points;
    private String name;

    private boolean blackJack;

    private int winner;


    public Player(){
        this( 0,"", false, 0);

    }



    public Player(int points, String name, boolean blackJack, int winner) {

        this.points = points;
        this.name = name;
        this.blackJack = blackJack;
        this.winner = winner;

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

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner += winner;
    }

    /**
     * Función de testeo, para comprobar cuantas cartas están vacías en el mazo
     * @return acu, que es la cantidad de cartas en el mazo, es decir, las posiciones que no son nulas
     */
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
