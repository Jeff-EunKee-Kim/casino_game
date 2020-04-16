package game;

/**
 * @author Celine Murugi
 */

import casino.Casino;
import player.Bet;
import viewer.StartMenu;
import winnings.RouletteWinning;
import winnings.SlotMachineWinning;



public class PlaySlotMachine {


    private int CURRENT_MONEY;
    private int playerChosenValue;
    private int casinoChosenValue;

    /**
     * Constructor for slot machine. Calling it from the front end starts
     * the slot machine game
     */
    public PlaySlotMachine() {

        playerChosenValue = StartMenu.getPlayerChosenValue();
        casinoChosenValue = Casino.casinoChosenCombination();

        if (playerChosenValue == casinoChosenValue){
            CURRENT_MONEY = SlotMachineWinning.getReward();
        }
        else {
            CURRENT_MONEY = Bet.getBet() * -1;
        }
    }


    /**
     * a getter method for the current money; to be passed
     * to the front end as the updated value
     * @return the value of the current amount of money
     */
    public int getCurrentMoney(){
        return CURRENT_MONEY;
    }


}
