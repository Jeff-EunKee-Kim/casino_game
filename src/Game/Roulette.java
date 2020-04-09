package Game;

/**
 * @author Celine Murugi
 * started 4/6/20
 */

import Casino.RandomValueSelector;
import View.FrontEnd;

import java.util.Objects;

public class Roulette {
    public static final int WIN_BLACK_OR_RED = 20;
    public static final int WIN_SINGLE_NUMBER = 50;


    private int BET_BY_PLAYER;
    private int MACHINE_CHOSEN_VALUE;
    private int CURRENT_MONEY;

    /**
     * Constructor for roulette. Creates a new instance of the front end and the casino
     * and uses these to get their input so as to compare input by user versus random value
     * from casino
     */
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
            CURRENT_MONEY -= BET_BY_PLAYER;
        }
    }



    private boolean playerHasWon(){
        return (BET_BY_PLAYER == MACHINE_CHOSEN_VALUE);
    }



    private void addMoneyToPlayer(){
        if (BET_BY_PLAYER == 0 || BET_BY_PLAYER == -1){
            CURRENT_MONEY += (WIN_BLACK_OR_RED * BET_BY_PLAYER);

        }else{
            CURRENT_MONEY += (WIN_SINGLE_NUMBER * BET_BY_PLAYER);
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
