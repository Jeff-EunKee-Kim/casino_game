package visual;

import game.AbstractGame;
import game.PlayRoulette;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ooga.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.Start;
import player.Player;
import viewer.StartMenu;
import viewer.Viewblock;

import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Vincent
 */
class UITest extends DukeApplicationTest {

    private static ResourceBundle myResources = ResourceBundle.getBundle("properties.Main");
    private Stage myStage;
    private Scene myScene;
    private Main main;
    private VBox title;
    private Player player;
    private AbstractGame currentGame;
    private StartMenu startMenu;
    private Button saveButton;
    private Button homeButton;
    private Button rouletteButton;
    private Button blackjackButton;
    private Button slotsButton;
    private BorderPane layout;
    private Text gameTitle;
    private Viewblock box1;
    private Viewblock box5;
    private Viewblock slots0;


    @Override
    public void start(Stage primaryStage) throws Exception {
        main = new Main();
        myStage = primaryStage;
        myStage.setScene(myScene);
        myStage.setTitle(myResources.getString("WindowTitle"));
        startMenu = new StartMenu(main, player, myResources);
        myScene = new Scene(startMenu.getLayout(), 950, 700);
        myStage.setScene(myScene);
        myStage.show();
        saveButton = lookup("#SaveButton").query();
        homeButton = lookup("#HomeButton").query();
        rouletteButton = lookup("#RouletteButton").query();
        blackjackButton = lookup("#RouletteButton").query();
        slotsButton = lookup("#RouletteButton").query();
        layout = lookup("#BorderPane").query();
        title = lookup("#VBox").query();
        gameTitle = lookup("#TitleText").query();
        box1 = lookup("#Box1").query();
        box5 = lookup("#Box5").query();
        slots0 = lookup("#Slots0").query();
    }


    @Test
    public void testStartRoulette(){
        clickOn(rouletteButton);
        assertEquals(gameTitle.getText(), "Roulette");
        clickOn(box1);
        clickOn(box5);
        assertEquals(box1.getStyleClass().get(0), "betted");
        assertEquals(box5.getStyleClass().get(0), "betted");
        clickOn(box5);
        assertEquals(box5.getStyleClass().get(0), "roul");
    }

    @Test
    public void testStartBlackJack(){
        clickOn(blackjackButton);
        assertEquals(gameTitle.getText(), "Black Jack");
    }


    @Test
    public void testStartSlotMachine(){
        clickOn(slotsButton);
        assertEquals(gameTitle.getText(), "Slots");
        assertEquals(slots0.getStyleClass().get(0), "roul");
        clickOn(slots0);
        assertEquals(slots0.getStyleClass().get(0), "betted");
        clickOn(slots0);
        assertEquals(slots0.getStyleClass().get(0), "roul");
    }

    @Test
    public void testHomeButton(){
        clickOn(rouletteButton);
        clickOn(homeButton);
        clickOn(blackjackButton);
        assertEquals(gameTitle.getText(), "Black Jack");
    }

    @Test
    void getLayout() {
        assertEquals(layout, startMenu.getLayout());
    }

}