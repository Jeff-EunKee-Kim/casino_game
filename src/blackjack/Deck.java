package blackjack;



/**
 * @author Celine Murugi
 * started 4/7/20
 */



import enums.Rank;
import enums.Suit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;


public class Deck {

    private ArrayList<Card> cardDeck;


    /**
     * Constructor for the Deck. Makes the Deck
     */
    public Deck(){
        this.cardDeck = new ArrayList<>();
        for (Rank rank: Rank.values()){
            for (Suit suit: Suit.values()){
                cardDeck.add(new Card(rank, suit));
            }
        }
    }


    public void shuffle(){
        Collections.shuffle(cardDeck);
    }

    public Card dealTopCard(){
        return cardDeck.remove(0);
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
     * Method that determines the String value of the Deck
     * @return the String Value of the Deck
     */
    @Override
    public String toString() {
        return "Deck{" +
                "cardDeck=" + "\n" + cardDeck +
                '}';
    }



}
