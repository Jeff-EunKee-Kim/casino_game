package winnings;

import player.Bet;

public abstract class AbstractWinnings {

    protected final int betByPlayer = Bet.getBet();
    protected static int reward;


    protected void determineRewardAmount(){ return;}
}
