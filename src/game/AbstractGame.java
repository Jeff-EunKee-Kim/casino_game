package game;

/**
 * @author Celine Murugi, Jeff Kim
 */

import player.Player;
import slots.Screen;
import viewer.StartMenu;

import java.util.HashMap;

public abstract class AbstractGame {

    protected int CURRENT_MONEY;
    protected int playerChosenValue;
    protected int casinoChosenValue;


    protected void assignValues(){
        Screen screen = new Screen();
       
        casinoChosenValue = screen.spinReels();
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
