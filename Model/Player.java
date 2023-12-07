package Model;


import java.util.Arrays;

public class Player {

    private Card[] mano = new Card[20];
    private int puntos;
    private String nombre;

    private boolean blackJack;


    public Player(){
        this( 0,"Name", false);

    }


    public Player(int puntos, String nombre, boolean blackJack) {
        this.puntos = puntos;
        this.nombre = nombre;
        this.blackJack = blackJack;

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

    public Card[] getMano() {
        return mano;
    }

    public void setMano(Card[] cards) {
        this.mano = cards;
    }

    public boolean isBlackJack() {
        return blackJack;
    }

    public void setBlackJack(boolean blackJack) {
        this.blackJack = blackJack;
    }

    public  int howManyCardsInDeck(){
        int acu =0;

        for (int i=0; i<mano.length ; i++){
            if(this.mano[i]!=null){
                acu++;

            }
        }
        return acu;
    }

    @Override
    public String toString() {
        return "Player{" +
                "cards=" + Arrays.toString(mano) +
                ", puntos=" + puntos +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
