package game;


/**
 * @author Celine Murugi
 */


import Result.BlackjackResult;
import Result.RouletteResult;
import Result.SlotResult;
import deck.Card;
import deck.Deck;
import deck.blackJackHand;
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


    public List<Integer> playBlackjackRound(Player p, int bet) {
        if (p.getBalance() < bet) {
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

    public void playBlackJackRound(HashMap<Integer,blackJackHand> hands, Player player, int hitOrMiss ) {

    }

}
