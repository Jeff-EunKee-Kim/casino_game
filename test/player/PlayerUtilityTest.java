package player;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jeff Kim
 * started 4/16/20
 */
class PlayerUtilityTest {

    @Test
    void readPlayerData() {
        Player p = new Player("testData", 50000);
        JSONObject playerData = PlayerUtility.readPlayerData(p);

        String name = playerData.get("name").toString();
        long balance = (long) playerData.get("balance");
        String chipString = playerData.get("chips").toString();

        int[] chips = Arrays.stream(chipString.substring(1, chipString.length() -1 ).split(",")).mapToInt(Integer::parseInt).toArray();

        assertEquals("testName", name);
        assertEquals(50000, balance);
        assertEquals(1, chips[0]);
        assertEquals(2, chips[1]);
        assertEquals(3, chips[2]);
    }

    @Test
    void savePlayerData() {
        Player p = new Player("Jeff", 500);
        p.buyRedChips(5);
        p.buyBlueChips(3);
        p.buyGreenChips(1);

        PlayerUtility.savePlayerData(p);
        File testFile = new File("./data/playerData/Jeff.json");
        assertTrue(testFile.exists());

        JSONObject playerData = PlayerUtility.readPlayerData(p);

        String name = playerData.get("name").toString();
        long balance = (long) playerData.get("balance");
        String chipString = playerData.get("chips").toString();

        int[] chips = Arrays.stream(chipString.substring(1, chipString.length() -1 ).split(",")).mapToInt(Integer::parseInt).toArray();

        assertEquals("Jeff", name);
        assertEquals(470, balance);
        assertEquals(5, chips[0]);
        assertEquals(3, chips[1]);
        assertEquals(1, chips[2]);
    }
}