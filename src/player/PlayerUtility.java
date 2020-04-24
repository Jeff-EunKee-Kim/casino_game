package player;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class that is created to save and load user data
 * @author Jeff Kim
 * started 4/16/20
 */
public class PlayerUtility {
    private static final String playerDataDirectory = "./data/playerData/";

    /**
     * Saves the player data file
     * @param player player that we want to save the data
     */
    public static void savePlayerData(Player player) {
        if (player == null) { return; }

        JSONObject data = new JSONObject();
        JSONArray chipsArray = new JSONArray();
        int[] chips = player.getChips();
        for (int chip : chips) {
            chipsArray.add(chip);
        }

        data.put("name", player.getName());
        data.put("balance", player.getBalance());
        data.put("chips", chipsArray);

        try {
            FileWriter file = new FileWriter(playerDataDirectory + "player.json");
            file.write(data.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads the player data file
     * @return JSON object of the player data
     */
    public static JSONObject readPlayerData(Player player) {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = new JSONObject();

        try (FileReader reader = new FileReader(playerDataDirectory + player.getName() + ".json"))
        {
            //Read JSON file
            Object data = jsonParser.parse(reader);
            jsonObject = (JSONObject) data;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO Exception");
        } catch (ParseException e) {
            System.out.println("Parse Exception");
        }

        return jsonObject;
    }
}
