package slots;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Vincent Sinfeugo
 */
public class Reel {

    List<Cell> myReel;

    public Reel(){
        myReel = new ArrayList<>();
        myReel.add(new Cell(0, Icon.CHERRY));
        myReel.add(new Cell(1, Icon.CHERRY));
        myReel.add(new Cell(2, Icon.CHERRY));
        myReel.add(new Cell(3, Icon.LEMON));
        myReel.add(new Cell(4, Icon.LEMON));
        myReel.add(new Cell(5, Icon.GRAPE));
        myReel.add(new Cell(6, Icon.ORANGE));
        myReel.add(new Cell(7, Icon.BELL));
        myReel.add(new Cell(8, Icon.BAR));
        myReel.add(new Cell(9, Icon.SEVEN));
        Collections.shuffle(myReel);
    }

    public Reel(List<Cell> list){
        myReel = list;
    }

    public List<Cell> getReel(){
        return myReel;
    }
}
