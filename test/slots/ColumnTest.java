package slots;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jeff Kim
 */
class ColumnTest {

    @Test
    void generateReelProbability() {
        Column c = new Column("properties.NormalSlot");

        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;

        List<Integer> reel = c.getReel();
        for (int i : reel) {
            switch (i) {
                case 0:
                    count0++;
                    break;
                case 1:
                    count1++;
                    break;
                case 2:
                    count2++;
                    break;
                case 3:
                    count3++;
                    break;
                case 4:
                    count4++;
                    break;
                case 5:
                    count5++;
                    break;
                case 6:
                    count6++;
                    break;
                default:
                    break;
            }

        }

        assertEquals(25, count0);
        assertEquals(25, count1);
        assertEquals(15, count2);
        assertEquals(15, count3);
        assertEquals(10, count4);
        assertEquals(7, count5);
        assertEquals(3, count6);
    }
}