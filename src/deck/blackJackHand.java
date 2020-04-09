package deck;

/**
 * @author Vincent Sinfuego
 */
public class blackJackHand extends Hand{

    private int pointTotal;

    public blackJackHand(){
        super();
    }

    @Override
    public void addCard(Card card){
        super.addCard(card);
        pointTotal += card.getNumber();
    }

    public int getPoints(){
        return pointTotal;
    }
}
