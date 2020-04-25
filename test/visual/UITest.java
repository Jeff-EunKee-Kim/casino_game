package visual;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ooga.Main;
import org.junit.jupiter.api.Test;
import player.Player;
import viewer.StartMenu;

import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Vincent
 */
class UITest extends DukeApplicationTest {

    private static ResourceBundle myResources;
    private Stage myStage;
    private Scene myScene;
    private Main main;
    private Player player;
    private StartMenu startMenu;
    private Button rouletteButton;
    private Button blackjackButton;
    private Button slotsButton;
    private BorderPane layout;

    @Override
    public void start(Stage primaryStage){
        main = new Main();
        myResources = ResourceBundle.getBundle("properties.Main");
        myStage = primaryStage;
        myStage.setScene(myScene);
        myStage.setTitle(myResources.getString("TITLE"));
        player = new Player("Chiskai", 100);
        startMenu = new StartMenu(main, player, myResources);
        myScene = new Scene(startMenu.getLayout(), 950, 700);
        myStage.setScene(myScene);
        myStage.show();
        rouletteButton = lookup("#RouletteButton").query();
        blackjackButton = lookup("#BlackJackButton").query();
        slotsButton = lookup("#SlotsButton").query();
        layout = lookup("#BorderPane").query();
    }


    @Test
    public void testButtons(){
        assertEquals(rouletteButton.getText(), "Roulette");
        assertEquals(blackjackButton.getText(), "Black Jack");
        assertEquals(slotsButton.getText(), "Slots");
    }

    @Test
    void getLayout() {
        assertEquals(layout, startMenu.getLayout());
    }

}