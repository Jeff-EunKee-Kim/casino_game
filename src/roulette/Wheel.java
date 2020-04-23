package roulette;

import java.util.Random;

/**
 * @author Vincent Sinfuego
 */
public class Wheel {

    public static final int NUMBEROFSLICES = 37;
    private WheelSlice[] slices;
    private WheelSlice tickerOn;
    private Random spinner;

    public Wheel(){
        slices = new WheelSlice[]{
                new WheelSlice(0, Color.GREEN),
                new WheelSlice(1, Color.RED),
                new WheelSlice(2, Color.BLACK),
                new WheelSlice(3, Color.RED),
                new WheelSlice(4, Color.BLACK),
                new WheelSlice(5, Color.RED),
                new WheelSlice(6, Color.BLACK),
                new WheelSlice(7, Color.RED),
                new WheelSlice(8, Color.BLACK),
                new WheelSlice(9, Color.RED),
                new WheelSlice(10, Color.BLACK),
                new WheelSlice(11, Color.BLACK),
                new WheelSlice(12, Color.RED),
                new WheelSlice(13, Color.BLACK),
                new WheelSlice(14, Color.RED),
                new WheelSlice(15, Color.BLACK),
                new WheelSlice(16, Color.RED),
                new WheelSlice(17, Color.BLACK),
                new WheelSlice(18, Color.RED),
                new WheelSlice(19, Color.BLACK),
                new WheelSlice(20, Color.RED),
                new WheelSlice(21, Color.RED),
                new WheelSlice(22, Color.BLACK),
                new WheelSlice(23, Color.RED),
                new WheelSlice(24, Color.BLACK),
                new WheelSlice(25, Color.RED),
                new WheelSlice(26, Color.BLACK),
                new WheelSlice(27, Color.RED),
                new WheelSlice(28, Color.BLACK),
                new WheelSlice(29, Color.RED),
                new WheelSlice(30, Color.BLACK),
                new WheelSlice(31, Color.BLACK),
                new WheelSlice(32, Color.RED),
                new WheelSlice(33, Color.BLACK),
                new WheelSlice(34, Color.RED),
                new WheelSlice(35, Color.BLACK),
                new WheelSlice(36, Color.RED),
        };
        spinner = new Random();
        tickerOn = new WheelSlice(0, Color.GREEN);
    }

    public void spin(){
        tickerOn = slices[spinner.nextInt(NUMBEROFSLICES)];
    }

    public int getTickerNumber(){
        return tickerOn.getNumber();
    }

    public Color getTickerColor(){
        return tickerOn.getColor();
    }
}
