package Game;

import Casino.RandomValueSelector;
import View.FrontEnd;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SlotMachine that = (SlotMachine) o;
        return BET_BY_PLAYER == that.BET_BY_PLAYER &&
                MACHINE_CHOSEN_VALUE == that.MACHINE_CHOSEN_VALUE &&
                CURRENT_MONEY == that.CURRENT_MONEY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(BET_BY_PLAYER, MACHINE_CHOSEN_VALUE, CURRENT_MONEY);
    }

    @Override
    public String toString() {
        return "SlotMachine{" +
                "BET_BY_PLAYER=" + BET_BY_PLAYER +
                ", MACHINE_CHOSEN_VALUE=" + MACHINE_CHOSEN_VALUE +
                ", CURRENT_MONEY=" + CURRENT_MONEY +
                '}';
    }
}
