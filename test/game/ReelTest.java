package game;

import org.junit.jupiter.api.Test;
import slots.Reel;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Vincent Sinfuego
 */
public class ReelTest{

    @Test
    public void testReelCreation(){
        Reel reel = new Reel();
        assertEquals(10, reel.getReel().size());
    }
}