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


    /**
     * Constructor for the Deck. Makes the Deck
     */
    public Deck(){
        this.cardDeck = new ArrayList<>();
        for (Rank rank: Rank.values()){
            for (Suite suite: Suite.values()){
                cardDeck.add(new Card(rank, suite));
            }
        }
    }


    private void shuffle(){
        Collections.shuffle(cardDeck);
    }


    /**
     * A getter method for the deck
     * @return the made deck
     */
    public ArrayList<Card> getCardDeck() {
        return cardDeck;
    }

    /**
     * An equals method that determines if another object is
     * equal to a Deck
     * @param o other object to be compared
     * @return a true or false boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deck deck = (Deck) o;
        return Objects.equals(cardDeck, deck.cardDeck);
    }


    /**
     * Method defining the generation for the hashcode
     * for the Deck
     * @return a hashcode value of the Deck
     */
    @Override
    public int hashCode() {
        return Objects.hash(cardDeck);
    }


    /**
     * Method that determines the String value of the Deck
     * @return the String Value of the Deck
     */
    @Override
    public String toString() {
        return "Deck{" +
                "cardDeck=" + "\n" + cardDeck +
                '}';
    }





    public static void main(String[] args) {
        Deck myDeck = new Deck();
        myDeck.shuffle();
        System.out.println(myDeck);
    }


}
