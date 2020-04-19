package winnings;

/**
 * @author Celine Murugi
 */

import player.Bet;

public abstract class AbstractWinnings {

    protected final int betByPlayer = Bet.getBet();
    protected static int reward;


    protected void determineRewardAmount(){}


    /**
     * This getter method returns the required award depending on
     * the player's bet, whether an outside bet or an inside bet
     * @return the reward value of the player
     */
    public static int getReward() {
        return reward;
    }

}
