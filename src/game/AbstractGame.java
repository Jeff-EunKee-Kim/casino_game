package game;

/**
 * @author Celine Murugi
 */

import casino.Casino;
import viewer.StartMenu;

public abstract class AbstractGame {

    protected int CURRENT_MONEY;
    protected int playerChosenValue;
    protected int casinoChosenValue;


    protected void assignValues(){
        playerChosenValue = StartMenu.getPlayerChosenValue();
        casinoChosenValue = Casino.casinoChosenCombination();
    }

    /**
     * a getter method for the current money; to be passed
     * to the front end as the updated value
     * @return the value of the current amount of money
     */
    public int getCurrentMoney(){
        return CURRENT_MONEY;
    }


}
