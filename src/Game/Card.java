package Game;

import java.util.Objects;

public class Card {
    private int myNumber;
    private Suite mySuite;


    /**
     * The Card constructor
     * @param number a number between 2 and 10, and inclusive of
     *               Jack, Queen, King, and Ace
     * @param suite the suite of the card, that is, Heart, Diamond,
     *              Club, and Spade
     */
    public Card (int number,  Suite suite){
        this.myNumber = number;
        this.mySuite = suite;
    }


    /**
     * A getter method for the card's number
     * @return the number value of the card
     */
    public int getMyNumber(){
        return myNumber;
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
        return myNumber == card.myNumber &&
                mySuite == card.mySuite;
    }

    @Override
    public int hashCode() {
        return Objects.hash(myNumber, mySuite);
    }


    @Override
    public String toString() {
        return "Card{" +
                "myNumber=" + myNumber +
                ", mySuite=" + mySuite +
                '}';
    }
}
