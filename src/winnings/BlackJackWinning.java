package winnings;


/**
 * @author Celine Murugi
 */


import deck.Card;
import deck.Deck;
import deck.blackJackHand;
import viewer.StartMenu;



public class BlackJackWinning extends AbstractWinnings{

    public static final int BET_REWARD_FACTOR = 20;

    private static boolean PLAYER_WINS;
    private static boolean ITS_A_TIE;

    private Deck deck = new Deck();
    private blackJackHand playerHand = new blackJackHand();
    private blackJackHand casinoHand = new blackJackHand();



    private void firstRoundGameStarter(){
        deck.shuffle();
        playerHand.addCard(deck.dealTopCard());
        casinoHand.addCard(deck.dealTopCard());
        playerHand.addCard(deck.dealTopCard());
        casinoHand.addCard(deck.dealTopCard());

        if(casinoHand.getPoints() == 21 && playerHand.getPoints()!= 21){
            return;
        }
        else if (playerHand.getPoints() == 21 && casinoHand.getPoints()!= 21){
            PLAYER_WINS = true;
            return;
        }
        else if (playerHand.getPoints() == 21 && casinoHand.getPoints() == 21){
            ITS_A_TIE = true;
            return;
        }
        else{
            addCardsToPlayer();
            if (playerHand.getPoints() > 21){
                return;
            }
            addCardsToCasino();
            if (casinoHand.getPoints() > 21){
                PLAYER_WINS = true;
                return;
            }
            comparePlayerAndCasino();
        }


    }

    private void addCardsToPlayer(){
        while (playerHand.getPoints() < 21){
            if (StartMenu.playerHitOrStand() == 'S' || StartMenu.playerHitOrStand() == 's'){
                break;
            }
            else{
                Card newCard = deck.dealTopCard();
                playerHand.addCard(newCard);
                }
            }
        return;
        }


    private void addCardsToCasino(){
        while (casinoHand.getPoints() <= 16){
            Card newCard = deck.dealTopCard();
            casinoHand.addCard(newCard);
        }
    }


    private void comparePlayerAndCasino(){
        if (playerHand.getPoints() > casinoHand.getPoints()){
            PLAYER_WINS = true;
            return;
        }
    }

    public static boolean PlayerWins() {
        return PLAYER_WINS;
    }

    public static boolean ItsATie() {
        return ITS_A_TIE;
    }



    protected void determineRewardAmount(){
        reward = betByPlayer * BET_REWARD_FACTOR;
    }
}
