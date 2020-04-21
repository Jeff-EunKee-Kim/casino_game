package deck;

import enums.Rank;

/**
 * @author Vincent Sinfuego
 */
public class blackJackHand extends Hand{

    public static final int MAX_VALUE = 10;
    private int pointTotal;
    private int aceCount;

    public blackJackHand(){
        super();
        pointTotal = 0;
        aceCount = 0;
    }

    @Override
    public void addCard(Card card){
        super.addCard(card);
        if (card.getMyRank().equals(Rank.ACE)){
            aceCount++;
        }
        pointTotal = calculatePoints();
    }

    private int calculatePoints(){
        int points = 0;
        for (int k = 0; k < myHand.size(); k++){
            Rank rank = myHand.get(k).getMyRank();
            if (!rank.equals(Rank.ACE)){
                if (rank.getValue() > MAX_VALUE) {
                    points += MAX_VALUE;
                }
                else{
                    points += rank.getValue();
                }
            }
        }
        for (int k = 0; k < aceCount; k++){
            if (points <= 10){
                points += 11;
            }
            else{
                points += 1;
            }
        }
        return points;
    }

    public int getPoints(){
        return pointTotal;
    }
}
