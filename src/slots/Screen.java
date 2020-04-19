package slots;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class represents the screen of a 3x3 slot machine. The number of lines bet changes how each screen will be scored.
 * @author Vincent Sinfeugo
 */
public class Screen {

    private Reel[] reels;
    private Cell[][] screen = new Cell[3][3];
    private Random r = new Random();

    private int linesBet = 1;

    public Screen(){
        reels = new Reel[]{new Reel(), new Reel(), new Reel()};
        updateScreen();
    }

    public Screen(Reel reel1, Reel reel2, Reel reel3){
        reels = new Reel[]{reel1, reel2, reel3};
        updateScreen();
    }

    /**
     * This method spins the reels, then returns the total point scoring of the icons on screen.
     * @return the total value of the screen, counting up all of the icons.
     */
    public int spinReels(){
        for (int k = 0; k < reels.length; k++){
            List<Cell> myReel = reels[k].getReel();
            int stop = r.nextInt(myReel.size());
            for (int j = 0; j < stop; j++){
                myReel.add(myReel.remove(0));
            }
        }
        updateScreen();
        return totalPoints();
    }

    public int totalPoints(){
        List<Integer> scores = new ArrayList<>();
        scores.add(score(screen[1][0], screen[1][1], screen[1][2]));
        if (linesBet >= 2){
            scores.add(score(screen[0][0], screen[0][1], screen[0][2]));
        }
        if (linesBet >= 3){
            scores.add(score(screen[2][0], screen[2][1], screen[2][2]));
        }
        if (linesBet >= 4){
            scores.add(score(screen[0][0], screen[1][1], screen[2][2]));
        }
        if (linesBet >= 5){
            scores.add(score(screen[2][0], screen[1][1], screen[0][2]));
        }
        int highest = 0;
        for (int k = 0; k < scores.size(); k++){
            if (scores.get(k) > highest){
                highest = scores.get(k);
            }
        }
        return highest;
    }

    private int score(Cell one, Cell two, Cell three){
        if (one.equals(two) && two.equals(three)){
            return one.getIcon().getWeight();
        }
        else if ((one.equals(two) || two.equals(three)) && two.getIcon().equals(Icon.CHERRY)){
            return Icon.CHERRY.getWeight();
        }
        else if (one.getIcon().equals(Icon.CHERRY) || two.getIcon().equals(Icon.CHERRY) || three.getIcon().equals(Icon.CHERRY)){
            return Icon.CHERRY.getWeight();
        }
        return 0;
    }

    private void updateScreen(){
        for (int k = 0; k < 3; k++){
            for (int j = 0; j < 3; j++){
                screen[j][k] = reels[k].getReel().get(j);
            }
        }
    }

    public void setLines(int lines){
        linesBet = lines;
    }

    public Cell getCell(int x, int y){
        return screen[x][y];
    }
}
