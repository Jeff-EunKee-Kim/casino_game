package deck;


/**
 * @author Celine Murugi
 * started 4/7/20
 */


import enums.Rank;
import enums.Suit;
import java.util.Objects;


public class Card {
    private Rank myRank;
    private Suit mySuit;
    private int myNumber;


    public Card(){
        myRank = Rank.ACE;
        mySuit = Suit.CLUBS;
        myNumber = 1;
    }

    public Card(Rank rank, Suit suit){
        myRank = rank;
        mySuit = suit;
        myNumber = myRank.getValue();
    }

    public Card(Rank rank, Suit suit, int number){
        myRank = rank;
        mySuit = suit;
        myNumber = number;
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
    public Suit getMySuit(){
        return mySuit;
    }

    public int getNumber() { return myNumber; }

    /**
     * An equals method that determines if another object is
     * equal to a Card
     * @param o other object to be compared
     * @return a true or false boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return myRank == card.myRank &&
                mySuit == card.mySuit;
    }



    /**
     * Method defining the generation for the hashcode
     * for the Card
     * @return a hashcode value of the Card
     */
    @Override
    public int hashCode() {
        return Objects.hash(myRank, mySuit);
    }



    /**
     * Method that determines the String value of the Card
     * @return the String Value of the Card
     */
    @Override
    public String toString() {
        return "Card{" + myRank +
                " of " + mySuit +
                '}' + "\n";
    }


}
