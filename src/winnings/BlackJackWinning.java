package winnings;

/**
 * @author Celine Murugi
 */


public class BlackJackWinning extends AbstractWinnings{

    public static final int BET_REWARD_FACTOR = 20;
    public static boolean PLAYER_WINS = false;

    protected void determineRewardAmount(){
        reward = betByPlayer * BET_REWARD_FACTOR;
    }
}
