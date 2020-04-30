package game;


/**
 * @author Celine Murugi, Vincent Sinfuego
 */


import result.BlackjackResult;
import blackjack.Card;
import blackjack.Deck;
import blackjack.blackJackHand;
import player.Bet;
import player.Player;
import result.RouletteResult;
import roulette.WheelSlice;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;


public class PlayBlackJack extends AbstractGame{

    public static final int LOSE = 0;
    public static final int WIN = 1;
    public static final int TIE = 2;
    public static final int UNDECIDED = 3;
    private Deck myDeck;
    private blackJackHand myHand;
    private blackJackHand dealerHand;
    private HashMap<Integer,blackJackHand> hands;
    private ResourceBundle gameResources;
    private int victory;
    private int dealerStop;

    /**
     * Constructor for black jack. Calling it from the front end starts
     * the black jack game
     */
    public PlayBlackJack(ResourceBundle resources){
        hands = startBlackjackRound();
        gameResources = resources;
        victory = Integer.parseInt(gameResources.getString("VictoryNum"));
        dealerStop = Integer.parseInt(gameResources.getString("DealerStopNum"));
    }

    public HashMap<Integer, blackJackHand> getHands() {
        return hands;
    }

    public HashMap<Integer,blackJackHand> startBlackjackRound() {
        myDeck = new Deck();
        myDeck.shuffle();

        myHand = new blackJackHand();
        myHand.addCard(myDeck.dealTopCard());
        myHand.addCard(myDeck.dealTopCard());
        dealerHand = new blackJackHand();
        dealerHand.addCard(myDeck.dealTopCard());
        dealerHand.addCard(myDeck.dealTopCard());
        HashMap<Integer,blackJackHand> ret = new HashMap<>();
        ret.put(0,dealerHand);
        ret.put(1,myHand);
        return ret;
    }

    public BlackjackResult playBlackJackRound(HashMap<Integer,blackJackHand> hands, Player p, int hitOrMiss, int amount) {
        int winStatus = UNDECIDED;
        int cashEarned = 0;
        boolean playerBust = false;
        boolean dealerBust = false;
        if (hitOrMiss == 0){
            myHand.addCard(myDeck.dealTopCard());
            if (myHand.getPoints() > victory){
                playerBust = true;
            }
            if (dealerHand.getPoints() < dealerStop){
                dealerHand.addCard(myDeck.dealTopCard());
                if (dealerHand.getPoints() > victory){
                    dealerBust = true;
                }
            }
            if (playerBust == true && dealerBust == true){
                winStatus = TIE;
            }
            else if (playerBust == true && dealerBust == false){
                winStatus = LOSE;
            }
            else if (playerBust == false && dealerBust == true){
                winStatus = WIN;
            }
            else{
                winStatus = UNDECIDED;
            }
        }
        else{
            if (dealerHand.getPoints() < dealerStop){
                dealerHand.addCard(myDeck.dealTopCard());
                if (dealerHand.getPoints() > victory){
                    winStatus = WIN;
                }
                else{
                    if (dealerHand.getPoints() < dealerStop){
                        winStatus = UNDECIDED;
                    }
                    else{
                        if (myHand.getPoints() < dealerHand.getPoints()){
                            winStatus = LOSE;
                        }
                        else if (myHand.getPoints() > dealerHand.getPoints()){
                            winStatus = WIN;
                        }
                        else if (myHand.getPoints() == dealerHand.getPoints()) {
                            winStatus = TIE;
                        }
                    }
                }
            }
            else{
                if (myHand.getPoints() < dealerHand.getPoints()){
                    winStatus = LOSE;
                }
                else if (myHand.getPoints() > dealerHand.getPoints()){
                    winStatus = WIN;
                }
                else if (myHand.getPoints() == dealerHand.getPoints()) {
                    winStatus = TIE;
                }
            }
        }
        if (winStatus == WIN){
            cashEarned = amount;
            p.addBalance(cashEarned);
        }
        else if (winStatus == LOSE){
            p.subtractBalance(amount);
        }
        return new BlackjackResult(true, winStatus, cashEarned, p.getBalance(), myHand, dealerHand);
    }
}
