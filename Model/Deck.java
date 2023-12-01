package Model;

public class Deck {

    private static  Card[] cards = new Card[52];




    public static Card[] createDeck(){
        String[] palos = {"Diamantes","Picas","Corazones","Trebol"};
        int index=0;
        for (String palo: palos) {

            for(int i =1;i<=13;i++){
                cards[index++] = new Card(i,palo);

            }
        }
        return cards;
    }

    public  void shuflle(){


    }

    public  void removeCard(){


    }
    public  void getCard(){


    }

    public  int deckSize(){


        return 0;
    }





}
