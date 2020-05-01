package slots;

import java.util.*;
import java.util.stream.Stream;

/**
 * This class represents the screen of a 3x3 slot machine. The number of lines bet changes how each screen will be scored.
 * @author Vincent Sinfeugo, Jeff Kim
 */
public class SlotModel {

    private Column[] reels;
    private int[][] screen;
    private Random r = new Random();
    private int[] winnings;
    private ResourceBundle slotRules;
    private int size;



    public SlotModel(String properties){
        slotRules = ResourceBundle.getBundle(properties);
        this.size = Integer.parseInt(slotRules.getString("SLOT_SIZE"));
        reels = new Column[size];
        winnings = Stream.of(slotRules.getString("WINNINGS").split(",")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i< size; i++) {
            reels[i] = new Column(properties);
        }
        screen = new int[size][size];
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
        for (int k = 0; k < size; k++){
            for (int j = 0; j < size; j++){
                screen[j][k] = reels[k].getReel().get(j);
            }
        }
    }

    /**
     * Check if line matches
     * @return Boolean
     */
    public boolean checkHorizontalLine(int row) {
        for (int i = 0; i < size-1; i++) {
            System.out.println("Row: " + row);
            System.out.println("i: " + i);
            if (screen[row][i] != screen[row][i+1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if diagonal lines match
     * @return Boolean
     */
    public boolean checkDiagonalLine(int row) {
        if (row == 0) {
            for (int i = 0; i < size-1; i++) {
                if (screen[row][i] != screen[row+1][i+1]) {
                    return false;
                }
                row++;
            }
            return true;
        } else if (row == size-1) {
            for (int i = 0; i < size-1; i++) {
                if (screen[row][i] != screen[row-1][i+1]) {
                    return false;
                }
                row--;
            }
            return true;
        }
        return false;
    }

    public int calculateWinAmount(Map<Integer, Integer> lines) {
        int winAmount = 0;

        for (int line : lines.keySet()) {
            System.out.println(lines.get(line));
            if (line == -1 && lines.get(line) != 0) {
                if (checkDiagonalLine(0)) {
                    winAmount += winnings[screen[0][0]];
                }
            } else if (line == -2 && lines.get(line) != 0) {
                if (checkDiagonalLine(size - 1)) {
                    winAmount += winnings[screen[size - 1][0]];
                }
            } else if (lines.get(line) != 0) {
                if (checkHorizontalLine(line)) {
                    winAmount += winnings[screen[line][0]];
                }
            }
        }
        return winAmount;
    }

    public int[][] getScreen() {
        return screen;
    }
}
