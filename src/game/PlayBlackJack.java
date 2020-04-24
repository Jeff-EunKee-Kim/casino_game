package game;


/**
 * @author Celine Murugi, Vincent Sinfuego
 */


import result.BlackjackResult;
import result.BlackjackResult;
import result.RouletteResult;
import result.SlotResult;
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

    Deck myDeck;
    blackJackHand myHand;
    blackJackHand dealerHand;

    int myBet;

    /**
     * Constructor for black jack. Calling it from the front end starts
     * the black jack game
     */
    public PlayBlackJack(){

        if (BlackJackWinning.PlayerWins() == true && BlackJackWinning.ItsATie() == false){
            CURRENT_MONEY += BlackJackWinning.getReward();
        }
        else if (BlackJackWinning.ItsATie() == true){
            CURRENT_MONEY += 0;
        }
        else {
            CURRENT_MONEY += Bet.getBet() * -1;
        }
    }


    public List<Integer> startBlackjackRound(Player p, int bet) {
        myBet = bet;
        if (p.getBalance() < myBet) {
            return null;
        }

        myDeck = new Deck();

        myHand = new blackJackHand();
        myHand.addCard(myDeck.dealTopCard());
        myHand.addCard(myDeck.dealTopCard());

        dealerHand = new blackJackHand();
        dealerHand.addCard(myDeck.dealTopCard());
        dealerHand.addCard(myDeck.dealTopCard());
        dealerHand.getCard(0).flip();

        List<Integer> cardList = new ArrayList<>();
        for (Card card : myHand.getCards()){
            cardList.add(card.getNumber());
        }
        for (Card card : dealerHand.getCards()){
            cardList.add(card.getNumber());
        }

        return cardList;
    }

    public BlackjackResult playBlackJackRound(HashMap<Integer,blackJackHand> hands, Player p, int hitOrMiss) {
        int winStatus;
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
            return new BlackjackResult(true, winStatus, myBet, p.getBalance(), myHand, dealerHand);
        }
        else{
            if (myHand.getPoints() < dealerHand.getPoints()){
                winStatus = 0;
            }
            else if (myHand.getPoints() > dealerHand.getPoints()){
                winStatus = 1;
            }
            else if (myHand.getPoints() == dealerHand.getPoints()){
                winStatus = 2;
            }
            return new BlackjackResult(true, winStatus, myBet, p.getBalance(), myHand, dealerHand);
        }
    }

}
