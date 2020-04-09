package Game;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * @author Celine Murugi
 * started 4/7/20
 */

public class Deck {

    private ArrayList<Card> cardDeck;

    public Deck(){
        this.cardDeck = new ArrayList<>();
    }


    private void makeDeck(){
        for (Suite suite: Suite.values()){
            for (Rank rank: Rank.values()){
                cardDeck.add(new Card(rank, suite));
            }
        }
    }

    private void shuffle(){
        Collections.shuffle(cardDeck);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deck deck = (Deck) o;
        return Objects.equals(cardDeck, deck.cardDeck);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardDeck);
    }



    @Override
    public String toString() {
        return "Deck{" +
                "cardDeck=" + cardDeck +
                '}';
    }





    public static void main(String[] args) {
        Deck myDeck = new Deck();
        myDeck.makeDeck();
        myDeck.shuffle();
        System.out.println(myDeck);
    }


}
