package deck;

/**
 * @author Vincent Sinfuego
 */
public class Card {

    private final Rank myRank;
    private final Suit mySuit;
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

    public Rank getRank(){
        return myRank;
    }

    public Suit getSuit(){
        return mySuit;
    }

    public int getNumber(){
        return myNumber;
    }
}
