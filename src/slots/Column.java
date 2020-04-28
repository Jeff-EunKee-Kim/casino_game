package slots;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Stream;

/**
 * @author Vincent Sinfeugo, Jeff Kim
 */
public class Column {
    private final int NUMBER_OF_ICONS = 5;
    List<Integer> myReel;
    private final int[] frequency;
    private ResourceBundle slotRules;


    public Column(String properties){
        slotRules = ResourceBundle.getBundle(properties);
        frequency = Stream.of(slotRules.getString("FREQUENCIES").split(",")).mapToInt(Integer::parseInt).toArray();

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

    public List<Integer> getReel(){
        return myReel;
    }
}
