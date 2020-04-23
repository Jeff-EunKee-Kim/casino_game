package slots;

import java.util.List;
import java.util.Random;

/**
 * This class represents the screen of a 3x3 slot machine. The number of lines bet changes how each screen will be scored.
 * @author Vincent Sinfeugo
 */
public class Display {

    private Column[] reels;
    private int[][] screen = new int[3][3];
    private Random r = new Random();

    public Display(){
        reels = new Column[]{new Column(), new Column(), new Column()};
        updateScreen();
    }

    public Display(Column reel1, Column reel2, Column reel3){
        reels = new Column[]{reel1, reel2, reel3};
        updateScreen();
    }

    /**
     * This method spins the reels.
     */
    public void spinReels(){
        for (int k = 0; k < reels.length; k++){
            List<Integer> myReel = reels[k].getReel();
            int stop = r.nextInt(myReel.size());
            for (int j = 0; j < stop; j++){
                myReel.add(myReel.remove(0));
            }
        }
        updateScreen();
    }

    private void updateScreen(){
        for (int k = 0; k < 3; k++){
            for (int j = 0; j < 3; j++){
                screen[j][k] = reels[k].getReel().get(j);
            }
        }
    }

    public int returnMiddleLine(){
        return screen[1][0] * 100 + screen[1][1] * 10 + screen[1][2];
    }

    public int getCell(int x, int y){
        return screen[x][y];
    }
}
