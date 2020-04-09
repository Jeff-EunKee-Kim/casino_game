package game;

import org.junit.jupiter.api.Test;
import roulette.Wheel;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Vincent Sinfuego
 */
public class WheelTest{

    @Test
    public void testWheelCreation(){
        Wheel wheel = new Wheel();
        assertEquals(0, wheel.getTickerNumber());

    }

    @Test
    public void testWheelSpin(){
        Wheel wheel = new Wheel();
        wheel.spin();

    }

}