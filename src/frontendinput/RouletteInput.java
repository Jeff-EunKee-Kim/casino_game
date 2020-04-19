package frontendinput;

/**
 * @author Celine Murugi
 */

import viewer.StartMenu;

public class RouletteInput {

    public static final int INSIDE_BET_INTEGER = 1;
    public static final int OUTSIDE_BET_INTEGER = 2;
    public static final int OUTSIDE_BET_EVEN_ODD_INTEGER = 3;
    private static boolean insideBet;
    private static boolean evenOdd;
    private int betByPlayer = StartMenu.inputBetFromPlayer();


    private void determineBetType(){
        if (betByPlayer == INSIDE_BET_INTEGER){
            insideBet = true;
            evenOdd = false;
        }
        else if (betByPlayer == OUTSIDE_BET_INTEGER){
            determineOutsideBetType();
        }
    }

    private void determineOutsideBetType(){
        if (betByPlayer == OUTSIDE_BET_EVEN_ODD_INTEGER){
            insideBet = false;
            evenOdd = true;
        }
        else{
            insideBet = false;
            evenOdd = false;
        }
    }



    public static boolean getInsideBet() {
        return insideBet;
    }

    public static boolean getEvenOdd() {
        return evenOdd;
    }

}
