package Game;

import java.util.Objects;

/**
 * @author Celine Murugi
 * started 4/7/20
 */



public class Card {
    private Rank myRank;
    private Suite mySuite;


    /**
     * The Card constructor
     * @param rank a number between 2 and 10, and inclusive of
     *               Jack, Queen, King, and Ace
     * @param suite the suite of the card, that is, Heart, Diamond,
     *              Club, and Spade
     */
    public Card (Rank rank,  Suite suite){
        this.myRank = rank;
        this.mySuite = suite;
    }


    /**
     * A getter method for the card's number
     * @return the number value of the card
     */
    public Rank getMyRank(){
        return myRank;
    }


    /**
     * A getter method for the card's suite
     * @return the suite value of the card
     */
    public Suite getMySuite(){
        return mySuite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return myRank == card.myRank &&
                mySuite == card.mySuite;
    }

    @Override
    public int hashCode() {
        return Objects.hash(myRank, mySuite);
    }


    @Override
    public String toString() {
        return "Card{" +
                "myRank=" + myRank +
                ", mySuite=" + mySuite +
                '}';
    }


}
