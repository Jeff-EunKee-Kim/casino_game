package winnings;

/**
 * @author Celine Murugi
 */

import frontendinput.RouletteInput;

public class RouletteWinning extends AbstractWinnings {

    public static final int INSIDE_BET_REWARD = 50;
    public static final int OUTSIDE_BET_EVEN_ODD_REWARD = 30;
    public static final int OUTSIDE_BET_HIGH_LOW_REWARD = 20;

    /*
    private final boolean insideBet =true;
    private final boolean evenOdd = true;


     */
    private final boolean insideBet = RouletteInput.getInsideBet();
    private final boolean evenOdd = RouletteInput.getEvenOdd();




    protected void determineRewardAmount(){
        if (insideBet == true){
            reward = betByPlayer * INSIDE_BET_REWARD; //where the bet was an inside bet
            return;
        }
        else if (evenOdd == true){
                reward = betByPlayer * OUTSIDE_BET_EVEN_ODD_REWARD; //where the bet was an outside bet of evenOdd type
                return;
        }
        else{
            reward = betByPlayer * OUTSIDE_BET_HIGH_LOW_REWARD; //where the bet was an outside bet of highLow type
        }
    }

}
