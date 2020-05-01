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
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Feel free to completely change this code or delete it entirely.
 */
public class Main extends Application {

    private static Stage myStage;
    private StartMenu startMenu;
    private static VBox title;
    private static AbstractGame currentGame;
    private static Player player;
    private static ResourceBundle myResources;
    private static ResourceBundle gameResources = ResourceBundle.getBundle("properties.Blackjack");
    private VBox layout;
    public static void main(String[] args) {
        try{
            File testFile = new File("./data/playerData/player.json");
             player = new Player(testFile);
        }
        catch (Exception e){
            player = new Player("Chiskai",100);
            System.out.println(e);
        }
        myResources = ResourceBundle.getBundle("properties.Main");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        myStage = primaryStage;
        myStage.setTitle(myResources.getString("TITLE"));
        startMenu = new StartMenu(this,player,myResources);
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
               title = StartMenu.generateTitle(myResources.getString("ROULETTE"));
               viewport.getStyleClass().add("bg-roulette");
               main = new RouletteViewport((PlayRoulette) currentGame, player, myResources);
               break;
           case 1:
               currentGame =  new PlayBlackJack(gameResources);
               title = StartMenu.generateTitle(myResources.getString("BLACKJACK"));
               viewport.getStyleClass().add("bg-blackjack");
               main = new BlackjackViewport((PlayBlackJack) currentGame, player, myResources);
               break;
           case 2:
               currentGame = new PlaySlotMachine();
               title = StartMenu.generateTitle(myResources.getString("SLOTS"));
               viewport.getStyleClass().add("bg-slots");
               main = new SlotsViewport((PlaySlotMachine) currentGame, player, myResources);
               break;
           default:
               System.out.println("uWu something went woopsy");
               main = new GridPane();
               break;
       }
        main.setAlignment(Pos.CENTER);
        selectionMenu("src/properties");
        viewport.setCenter(layout);
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

    private void selectionMenu(String path){
        layout = new VBox();
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        ArrayList<HBox> files = new ArrayList<>();
        int size = listOfFiles.length;
        files.add(new HBox());
        if (size>4) {
            size=size/4;
            for (int i = 0; i <size;i++){
                files.add(new HBox());
            }
        }
        ArrayList<Button> options = new ArrayList<>();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                String filename = file.getName();
                Button toAdd = new Button(filename.split("\\.")[0]);
                toAdd.getStyleClass().add("rect");
                toAdd.setOnAction(e -> {
                   layout.getChildren().clear();
                //    Main.initSimulation(path+"/"+filename);
                });
                options.add(toAdd);
            }
        }
        int iter = 0;
        int total = options.size();
        int flag = 0;
        if (total%4!=0) flag = 1;
        int cont = 4;
        for(HBox row : files){
            if (flag == 1&&total<4) cont = total;
            for(int i = iter ;i < iter +cont;i++)
                row.getChildren().add(options.get(i));
            iter+=4; total-=4;
            row.setAlignment(Pos.CENTER); row.setSpacing(20);
            layout.getChildren().add(row);
        }
    }
}
