package game;

/**
 * @author Celine Murugi
 * started 4/6/20
 */


public class SlotMachine {
    public static final int WIN_BY_WIN = 500;
    public static final int LOSE_BY_LOSS = 100;


    private int BET_BY_PLAYER;
    private int MACHINE_CHOSEN_VALUE;
    private int CURRENT_MONEY;

    public SlotMachine(int betByPlayer, int machineChosenValue, int currentMoney) { // three-digit number guessed by user
        BET_BY_PLAYER = betByPlayer;
        MACHINE_CHOSEN_VALUE = machineChosenValue;
        CURRENT_MONEY = currentMoney;
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
     * equal to a SlotMachine
     * @param o other object to be compared
     * @return a true or false boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SlotMachine that = (SlotMachine) o;
        return BET_BY_PLAYER == that.BET_BY_PLAYER &&
                MACHINE_CHOSEN_VALUE == that.MACHINE_CHOSEN_VALUE &&
                CURRENT_MONEY == that.CURRENT_MONEY;
    }


    /**
     * Method that determines the String value of the SlotMachine
     * @return the String Value of the SlotMachine
     */
    @Override
    public String toString() {
        return "SlotMachine{" +
                "BET_BY_PLAYER=" + BET_BY_PLAYER +
                ", MACHINE_CHOSEN_VALUE=" + MACHINE_CHOSEN_VALUE +
                ", CURRENT_MONEY=" + CURRENT_MONEY +
                '}';
    }
}
