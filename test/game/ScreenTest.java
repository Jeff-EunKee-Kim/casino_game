package game;

import org.junit.jupiter.api.Test;
import slots.Cell;
import slots.Icon;
import slots.Reel;
import slots.Screen;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Vincent Sinfuego
 */
public class ScreenTest{

    @Test
    public void testScreenCreation(){
        Screen screen = new Screen();
        for (int k = 0; k < 3; k++){
            for (int j = 0; j < 3; j++){
                assertNotEquals(null, screen.getCell(j,k));
            }
        }
    }

    @Test
    public void testScoring(){
        List<Cell> list = new ArrayList<>();
        list.add(new Cell(0, Icon.CHERRY));
        list.add(new Cell(1, Icon.CHERRY));
        list.add(new Cell(2, Icon.CHERRY));
        Reel reel1 = new Reel(list);
        Reel reel2 = new Reel(list);
        Reel reel3 = new Reel(list);
        Screen screen = new Screen(reel1, reel2, reel3);
        assertEquals(1, screen.totalPoints());

    }

    @Test
    public void testScreenSpin(){
        Screen screen = new Screen();
        Screen screen2 = new Screen();
        screen.spinReels();
        assertNotEquals(screen2, screen);
    }

}