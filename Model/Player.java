package Model;


import java.util.Arrays;

public class Player {

    private Card[] cards = new Card[20];
    private int puntos;
    private String nombre;


    public Player(){
        this( 0,"Name1");

    }

    public Player(int puntos, String nombre) {
        this.puntos = puntos;
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

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
        return "Player{" +
                "cards=" + Arrays.toString(cards) +
                ", puntos=" + puntos +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
