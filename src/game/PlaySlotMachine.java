package game;

/**
 * @author Celine Murugi, Jeff Kim
 */

import result.SlotResult;
import player.Player;
import slots.SlotModel;

import java.util.Map;


public class PlaySlotMachine extends AbstractGame{
    private final int lineCost = 1;
    /**
     * Constructor for slot machine.
     */
    public PlaySlotMachine() {
    }

    /**
     * API from the front end to run the game
     * @param lines : key is line, value is betting
     * @return SlotResult class that contains win status, amountwon, player balance, and screen after game
     */
    public SlotResult playSlotsRound(Map<Integer, Integer> lines, Player p, String properties) {
        int totalBetCost = 0;
        for (int line : lines.keySet()) {
            totalBetCost += lines.get(line) * lineCost;
        }

        if (p.getBalance() < totalBetCost) {
            return new SlotResult(false, 0, 0, 0, new int[3][3]);
        }

        SlotModel slotModel = new SlotModel(properties);
        slotModel.spinReels();

        int amountWon = slotModel.calculateWinAmount(lines);
        boolean winStatus = amountWon != 0;


        p.subtractBalance(totalBetCost);
        if (winStatus) {
            p.addBalance(amountWon);
            return new SlotResult(true, 1, amountWon, p.getBalance(), slotModel.getScreen());
        }
        else{
            return new SlotResult(true, 0, amountWon, p.getBalance(), slotModel.getScreen());
        }
    }

}
