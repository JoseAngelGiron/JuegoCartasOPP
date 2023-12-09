package Model;

import java.util.Objects;

public class Card {
    //Atributos
    private int value;
    private String suit;


    // Constructores
    public Card(){
        this(0," ");

    }

    public Card(int value, String suit ){
        this.value = value;
        this.suit = suit;

    }

    @Override
    public String toString() {
        //Usar un ciclo for para imprimir una carta con el valor en las esquinas
        return "Card{" +
                "value=" + value +
                ", suit='" + suit + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return value == card.value && Objects.equals(suit, card.suit);
    }
    // Getter and Setters
    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // Funciones
    public static Card addCard(int value, String suit){

        Card card =new Card(value,suit);

        return card;
    }




}
