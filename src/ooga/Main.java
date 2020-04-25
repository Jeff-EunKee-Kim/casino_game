package ooga;


import game.AbstractGame;
import game.PlayBlackJack;
import game.PlayRoulette;
import game.PlaySlotMachine;
import javafx.animation.KeyFrame;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;
import player.Player;
import player.PlayerUtility;
import viewer.*;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.awt.*;
import java.io.File;

/**
 * Feel free to completely change this code or delete it entirely.
 */
public class Main extends Application {


    private static Stage myStage;

    private StartMenu startMenu;
    private static VBox title;
    private static AbstractGame currentGame;
    private static Player player;


    public static void main(String[] args) {
        try{
            File testFile = new File("./data/playerData/player.json");
             player = new Player(testFile);
        }
        catch (Exception e){
            player = new Player("Chiskai",100);
            System.out.println(e);
        }
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        myStage = primaryStage;
        myStage.setTitle("Casino Amicorum Spectaculum");
        startMenu = new StartMenu(this,player);
        Scene firstscene = new Scene(startMenu.getLayout(),950,700);
        myStage.setScene(firstscene);
        myStage.show();
    }

    public void gameStart(int gametype){
        BorderPane  viewport = new BorderPane();
        viewport.getStylesheets().add("Styling/Main.css");

        GridPane main;

        switch (gametype) {
           case 0 :
               currentGame = new PlayRoulette();
               title = StartMenu.generateTitle("");
               main = new RouletteViewport((PlayRoulette) currentGame, player);
               break;
           case 1:
               currentGame =  new PlayBlackJack();
               title = StartMenu.generateTitle("Black Jack");
               viewport.getStyleClass().add("bg-blackjack");
               main = new BlackjackViewport((PlayBlackJack) currentGame, player);
               break;
           case 2:
               currentGame = new PlaySlotMachine();
               main = new SlotsViewport((PlaySlotMachine) currentGame, player);
               break;
           default:
               System.out.println("uWu something went woopsy");
               main = new GridPane();
               break;
       }

        main.setAlignment(Pos.CENTER);
        viewport.setCenter(main);
        viewport.setTop(title);
        viewport.setBottom(generateControls());
        Scene mains = new Scene(viewport,950 ,700);
        myStage.setScene(mains);

    }
    private  HBox generateControls(){
        HBox controls = new HBox();
        Button save = new Button("Save Game");
        save.getStyleClass().add("newbtn");
        save.setOnAction(e -> {
            PlayerUtility.savePlayerData(player);
        });
        Button home = new Button("Go To Menu");
        home.getStyleClass().add("newbtn");
        home.setOnAction(e -> {
            start(myStage);
        });
        controls.getChildren().addAll(save,home);
        controls.setAlignment(Pos.CENTER);
        controls.setPadding(new Insets(10, 10, 10, 10));
        controls.setSpacing(15);
        return controls;
    }

}
