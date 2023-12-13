package Model;

import java.util.Objects;

public class Card {

    private int value;
    private String suit;

    private String figure;



    public Card(){
        this(0," ", " ");

    }

    public Card(int value, String suit ){
        this.value = value;
        this.suit = suit;

    }

    public Card(int value, String suit, String figure ){
        this.value = value;
        this.suit = suit;
        this.figure = figure;
    }


    @Override
    public String toString() {
        return "┌────────────┐\n" +
                "│ "+suit+"      "+figure+"   │\n" +
                "│            │\n" +
                "│    " + value + "       │\n" +
                "│            │\n" +
                "│ " +figure+ "      "+ suit +"   │\n" +
                "└────────────┘";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return value == card.value && Objects.equals(suit, card.suit);
    }

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







}
