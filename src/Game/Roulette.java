package Game;

import Casino.RandomValueSelector;
import View.FrontEnd;

import java.util.Objects;

public class Roulette {
    public static final int WIN_BLACK_OR_RED = 200;
    public static final int WIN_SINGLE_NUMBER = 500;
    public static final int LOSE_BY_LOSS = 100;


    private int BET_BY_PLAYER;
    private int MACHINE_CHOSEN_VALUE;
    private int CURRENT_MONEY;


    public Roulette() { // 0 and -1 = Black and Red Bets respectively; 1-36 = Single Number Bets
        FrontEnd frontEnd = new FrontEnd();
        BET_BY_PLAYER = frontEnd.betByPlayer(); // a number between -1 and 36
        CURRENT_MONEY= frontEnd.getCurrentMoney(); // gets the amount of money displayed on screen

        RandomValueSelector randomValueSelector = new RandomValueSelector();
        MACHINE_CHOSEN_VALUE = randomValueSelector.chosenValue(); // from the casino module
    }



    private void checkIfWon(){
        if (playerHasWon() == true) {
            addMoneyToPlayer();

        }else{
            CURRENT_MONEY -= LOSE_BY_LOSS;
        }
    }



    private boolean playerHasWon(){
        return (BET_BY_PLAYER == MACHINE_CHOSEN_VALUE);
    }



    private void addMoneyToPlayer(){
        if (BET_BY_PLAYER == 0 || BET_BY_PLAYER == -1){
            CURRENT_MONEY += WIN_BLACK_OR_RED;

        }else{
            CURRENT_MONEY += WIN_SINGLE_NUMBER;
        }
    }


    public int getCurrentMoney(){
        return CURRENT_MONEY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roulette roulette = (Roulette) o;
        return BET_BY_PLAYER == roulette.BET_BY_PLAYER &&
                MACHINE_CHOSEN_VALUE == roulette.MACHINE_CHOSEN_VALUE &&
                CURRENT_MONEY == roulette.CURRENT_MONEY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(BET_BY_PLAYER, MACHINE_CHOSEN_VALUE, CURRENT_MONEY);
    }

    @Override
    public String toString() {
        return "Roulette{" +
                "BET_BY_PLAYER=" + BET_BY_PLAYER +
                ", MACHINE_CHOSEN_VALUE=" + MACHINE_CHOSEN_VALUE +
                ", CURRENT_MONEY=" + CURRENT_MONEY +
                '}';
    }
}
