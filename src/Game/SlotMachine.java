package Game;

import Casino.RandomValueSelector;
import View.FrontEnd;

public class SlotMachine {
    public static final int WIN_BY_WIN = 500;
    public static final int LOSE_BY_LOSS = 100;


    private int BET_BY_PLAYER;
    private int MACHINE_CHOSEN_VALUE;
    private int CURRENT_MONEY;

    public SlotMachine() { // three-digit number guessed by user
        FrontEnd frontEnd = new FrontEnd();
        BET_BY_PLAYER = frontEnd.betByPlayer(); // a number between -1 and 36
        CURRENT_MONEY= frontEnd.getCurrentMoney(); // gets the amount of money displayed on screen

        RandomValueSelector randomValueSelector = new RandomValueSelector();
        MACHINE_CHOSEN_VALUE = randomValueSelector.chosenValue(); // from the casino module
    }


    private void checkIfWon(){
        if (playerHasWon() == true) {
            CURRENT_MONEY += WIN_BY_WIN;

        }else{
            CURRENT_MONEY -= LOSE_BY_LOSS;
        }
    }



    private boolean playerHasWon(){
        return (BET_BY_PLAYER == MACHINE_CHOSEN_VALUE);
    }


    public int getCurrentMoney(){
        return CURRENT_MONEY;
    }
}
