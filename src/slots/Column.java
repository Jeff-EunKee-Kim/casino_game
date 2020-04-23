package slots;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Vincent Sinfeugo
 */
public class Column {

    List<Integer> myReel;

    public Column(){
        myReel = new ArrayList<>();
        myReel.add(1);
        myReel.add(1);
        myReel.add(1);
        myReel.add(2);
        myReel.add(2);
        myReel.add(3);
        myReel.add(4);
        myReel.add(5);
        myReel.add(6);
        myReel.add(7);
        Collections.shuffle(myReel);
    }

    public Column(List<Integer> list){
        myReel = list;
    }

    public List<Integer> getReel(){
        return myReel;
    }
}
