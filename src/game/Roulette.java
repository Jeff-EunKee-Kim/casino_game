package game;

/**
 * @author Celine Murugi
 * started 4/6/20
 */


public class Roulette {
    public static final int WIN_BLACK_OR_RED = 20;
    public static final int WIN_SINGLE_NUMBER = 50;


    private int BET_BY_PLAYER;
    private int MACHINE_CHOSEN_VALUE;
    private int CURRENT_MONEY;

    /**
     * Constructor for roulette. Creates a new instance of the front end and the Casino
     * and uses these to get their input so as to compare input by user versus random value
     * from Casino
     */
    public Roulette(int betByPlayer, int machineChosenValue, int currentMoney) {
        // 0 and -1 = Black and Red Bets respectively; 1-36 = Single Number Bets

        BET_BY_PLAYER = betByPlayer;
        MACHINE_CHOSEN_VALUE = machineChosenValue;
        CURRENT_MONEY = currentMoney;
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


    /**
     * a getter method for the current money; to be passed
     * to the front end as the updated value
     * @return the value of the current amount of money
     */
    public int getCurrentMoney(){
        return CURRENT_MONEY;
    }



    /**
     * An equals method that determines if another object is
     * equal to a BlackJackWinning
     * @param o other object to be compared
     * @return a true or false boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roulette roulette = (Roulette) o;
        return BET_BY_PLAYER == roulette.BET_BY_PLAYER &&
                MACHINE_CHOSEN_VALUE == roulette.MACHINE_CHOSEN_VALUE &&
                CURRENT_MONEY == roulette.CURRENT_MONEY;
    }


    /**
     * Method that determines the String value of the BlackJackWinning
     * @return the String Value of the BlackJackWinning
     */
    @Override
    public String toString() {
        return "BlackJackWinning{" +
                "BET_BY_PLAYER=" + BET_BY_PLAYER +
                ", MACHINE_CHOSEN_VALUE=" + MACHINE_CHOSEN_VALUE +
                ", CURRENT_MONEY=" + CURRENT_MONEY +
                '}';
    }
}
