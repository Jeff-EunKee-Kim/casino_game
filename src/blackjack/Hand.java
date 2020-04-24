package blackjack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vincent Sinfuego
 */
public class Hand {

    protected List<Card> myHand;

    public Hand(){
        myHand = new ArrayList<>();
    }

    public int handSize(){
        return myHand.size();
    }

    public void addCard(Card card){
        myHand.add(card);
    }
}
