package game;

/**
 * @author Celine Murugi, Jeff Kim
 */

import Result.SlotResult;
import player.Bet;
import player.Player;
import slots.SlotModel;
import winnings.SlotMachineWinning;

import java.util.Map;


public class PlaySlotMachine extends AbstractGame{
    private final int pullLeverCost = 5;
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
     * API from the front end to run the game
     * @param lines : key is line, value is betting
     * @return SlotResult class that contains win status, amountwon, player balance, and screen after game
     */
    public SlotResult playSlotMachine(Map<Integer, Integer> lines, Player p) {
        SlotModel slotDisplay = new SlotModel();
        slotDisplay.spinReels();

        int amountWon = slotDisplay.calculateScore(lines);
        boolean winStatus = amountWon == 0;
        p.subtractBalance(pullLeverCost);
        if (winStatus) {
            p.addBalance(amountWon);
        }

        SlotResult res = new SlotResult(winStatus, amountWon, p.getBalance(), slotDisplay.getScreen());

        return res;
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
