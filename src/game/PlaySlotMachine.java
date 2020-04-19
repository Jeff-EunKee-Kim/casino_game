package game;

/**
 * @author Celine Murugi
 */


import player.Bet;
import winnings.SlotMachineWinning;



public class PlaySlotMachine extends AbstractGame{


    /**
     * Constructor for slot machine. Calling it from the front end starts
     * the slot machine game
     */
    public PlaySlotMachine() {



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
