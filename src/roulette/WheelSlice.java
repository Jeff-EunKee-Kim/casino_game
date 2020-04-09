package roulette;

/**
 * @author Vincent Sinfuego
 */
public class WheelSlice {

    private int myNumber;
    private Color myColor;

    public WheelSlice(){
        myNumber = 0;
        myColor = Color.BLACK;
    }

    public WheelSlice(int number, Color color){
        myNumber = number;
        myColor = color;
    }

    public int getNumber(){
        return myNumber;
    }

    public Color getColor(){
        return myColor;
    }
}
