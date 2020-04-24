package deck;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vincent Sinfuego
 */
public abstract class Hand {

    protected List<Card> myHand;

    public Hand(){
        myHand = new ArrayList<>();
    }

    public abstract int handSize();

    public abstract void addCard(Card card);

    public abstract Card getCard(int index);

    public abstract List<Card> getCards();
}
