package winnings;

/**
 * @author Celine Murugi
 */


import slots.Screen;

public class SlotMachineWinning extends AbstractWinnings{


    public static final int HUNDRED_ELEVEN_REWARD = 70;
    public static final int THREE_HUNDRED_THREE_REWARD = 60;
    public static final int FIVE_HUNDRED_FIFTY_FIVE_REWARD = 50;
    public static final int SEVEN_HUNDRED_SEVENTY_SEVEN_REWARD = 40;
    public static final int HUNDRED_THIRTY_FIVE_REWARD = 30;
    public static final int TWO_HUNDRED_FORTY_SIX_REWARD = 20;
    private final int playerChosenCombination;



    public SlotMachineWinning(){
        Screen screen = new Screen();
        playerChosenCombination = screen.spinReels();
    }


    protected void determineRewardAmount(){
        switch (playerChosenCombination){
            case 111:
                reward = betByPlayer * HUNDRED_ELEVEN_REWARD;
                break;

            case 333:
                reward = betByPlayer * THREE_HUNDRED_THREE_REWARD;
                break;

            case 555:
                reward = betByPlayer * FIVE_HUNDRED_FIFTY_FIVE_REWARD;
                break;

            case 777:
                reward = betByPlayer * SEVEN_HUNDRED_SEVENTY_SEVEN_REWARD;
                break;

            case 135:
                reward = betByPlayer * HUNDRED_THIRTY_FIVE_REWARD;
                break;

            case 246:
                reward = betByPlayer * TWO_HUNDRED_FORTY_SIX_REWARD;
                break;
        }
    }



}