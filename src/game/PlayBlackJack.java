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
import winnings.BlackJackWinning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class PlayBlackJack extends AbstractGame{

    private Deck myDeck;
    private blackJackHand myHand;
    private blackJackHand dealerHand;
    int myBet;
    private HashMap<Integer,blackJackHand> hands;
    /**
     * Constructor for black jack. Calling it from the front end starts
     * the black jack game
     */
    public PlayBlackJack(){
    hands = startBlackjackRound();
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

    public BlackjackResult playBlackJackRound(HashMap<Integer,blackJackHand> hands, Player p, int hitOrMiss) {
        int winStatus = 3;
        boolean playerBust = false;
        boolean dealerBust = false;
        if (hitOrMiss == 0){
            myHand.addCard(myDeck.dealTopCard());
            if (myHand.getPoints() > 21){
                playerBust = true;
            }
            if (dealerHand.getPoints() < 17){
                dealerHand.addCard(myDeck.dealTopCard());
                if (dealerHand.getPoints() > 21){
                    dealerBust = true;
                }
            }
            if (playerBust == true && dealerBust == true){
                winStatus = 2;
            }
            else if (playerBust == true && dealerBust == false){
                winStatus = 0;
            }
            else if (playerBust == false && dealerBust == true){
                winStatus = 1;
            }
            else{
                winStatus = 3;
            }
        }
        else{
            if (dealerHand.getPoints() < 17){
                dealerHand.addCard(myDeck.dealTopCard());
                if (dealerHand.getPoints() > 21){
                    winStatus = 1;
                }
                else{
                    winStatus = 3;
                }
            }
            else{
                if (myHand.getPoints() < dealerHand.getPoints()){
                    winStatus = 0;
                }
                else if (myHand.getPoints() > dealerHand.getPoints()){
                    winStatus = 1;
                }
                else if (myHand.getPoints() == dealerHand.getPoints()) {
                    winStatus = 2;
                }
            }
        }
        return new BlackjackResult(true, winStatus, myBet, p.getBalance(), myHand, dealerHand);
    }

}
