package deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Vincent Sinfuego
 */
public class Deck {

    private List<Card> myDeck;

    public Deck(){
        myDeck = new ArrayList<>();
        for (Rank rank: Rank.values()){
            for (Suit suit: Suit.values()){
                myDeck.add(new Card(rank, suit));
            }
        }
    }

    public void shuffleDeck(){
        Collections.shuffle(myDeck);
    }

    public Card dealTopCard(){
        return myDeck.remove(0);
    }

    public int cardsRemaining(){
        return myDeck.size();
    }
}
