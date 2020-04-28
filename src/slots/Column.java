package slots;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Vincent Sinfeugo, Jeff Kim
 */
public class Column {
    private final int NUMBER_OF_ICONS = 5;
    List<Integer> myReel;
    private final int[] frequency = {40, 40, 20, 20, 3};


    public Column(){
        myReel = new ArrayList<>();
        generateReelProbability();
        Collections.shuffle(myReel);
    }

    /**
     * Generating the probability for each number to appear
     */
    public void generateReelProbability() {
        for (int i = 0; i < NUMBER_OF_ICONS; i++) {
            for (int j = 0; j< frequency[i]; j++) {
                myReel.add(i);
            }
        }
    }

    public Column(List<Integer> list){
        myReel = list;
    }

    public List<Integer> getReel(){
        return myReel;
    }
}
