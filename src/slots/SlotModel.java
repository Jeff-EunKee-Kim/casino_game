package slots;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * This class represents the screen of a 3x3 slot machine. The number of lines bet changes how each screen will be scored.
 * @author Vincent Sinfeugo, Jeff Kim
 */
public class SlotModel {

    private Column[] reels;
    private int[][] screen = new int[3][3];
    private Random r = new Random();
    private int[] winnings = {10, 10, 20, 20, 30, 50, 100};

    public SlotModel(){
        reels = new Column[]{new Column(), new Column(), new Column()};
        updateScreen();
    }

    public SlotModel(Column reel1, Column reel2, Column reel3){
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

    /**
     * Check if top line matches
     * @return Boolean
     */
    public boolean checkTopLine() {
        return screen[0][0] == screen[0][1] && screen[0][1] == screen[0][2];
    }

    /**
     * Check if middle line matches
     * @return Boolean
     */
    public boolean checkMiddleLine() {
        return screen[1][0] == screen[1][1] && screen[1][1] == screen[1][2];
    }

    /**
     * Check if bottom line matches
     * @return Boolean
     */
    public boolean checkBottomLine() {
        return screen[2][0] == screen[2][1] && screen[2][1] == screen[2][2];
    }

    /**
     * Check if top left - bottom right diagonal line matches
     * @return Boolean
     */
    public boolean checkTLBRLine() {
        return screen[0][0] == screen[1][1] && screen[1][1] == screen[2][2];
    }

    /**
     * Check if bottom left - top right diagonal line matches
     * @return Boolean
     */
    public boolean checkBLTRLine() {
        return screen[2][0] == screen[1][1] && screen[1][1] == screen[0][2];
    }

    public int calculateWinAmount(Map<Integer, Integer> lines) {
        int winAmount = 0;
        for (int line : lines.keySet()) {
            if (line == 0 && checkTopLine()) {
                winAmount += winnings[screen[0][0]];
            } else if (line == 1 && checkMiddleLine()) {
                winAmount += winnings[screen[1][0]];
            } else if (line == 2 && checkBottomLine()) {
                winAmount += winnings[screen[2][0]];
            } else if (line == 3 && checkTLBRLine()) {
                winAmount += winnings[screen[0][0]];
            } else if (line == 4 && checkBLTRLine()) {
                winAmount += winnings[screen[2][0]];
            }
        }
        return winAmount;
    }

    public int returnMiddleLine(){
        return screen[1][0] * 100 + screen[1][1] * 10 + screen[1][2];
    }

    public int getCell(int x, int y){
        return screen[x][y];
    }

    public int[][] getScreen() {
        return screen;
    }
}
