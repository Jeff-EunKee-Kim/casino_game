package ooga;


import game.AbstractGame;
import game.PlayRoulette;
import javafx.animation.KeyFrame;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import player.Player;
import viewer.*;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

/**
 * Feel free to completely change this code or delete it entirely.
 */
public class Main extends Application {

    private double TIMESTEP;
    private static Stage myStage;
    private Timeline myAnimation;
    private StartMenu startMenu;
    private static AbstractGame currentGame;
    private static Player player;

    public static void main(String[] args) {
        player = new Player("Chiskai",100);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        myStage = primaryStage;
        myStage.setTitle("Casino Amicorum Spectaculum");
        TIMESTEP = 1;
        startMenu = new StartMenu();
        Scene firstscene = new Scene(startMenu.getLayout(),950,700);
        myStage.setScene(firstscene);
        myStage.show();
    }

    public static void gameStart(int gametype){
        GridPane main;
       switch (gametype) {
           case 0 :
               currentGame = new PlayRoulette();

               main = new RouletteViewport((PlayRoulette) currentGame, player);
               break;

           default:
               System.out.println("uWu something went woopsy");
               main = new GridPane();
               break;
       }

        Scene mains = new Scene(main,950 ,700);
        myStage.setScene(mains);

//      = new GridPane();
//       switch (gametype) {
//           case 0:
//               currentGame = new PlayRoulette();
//               GridPane main = new RouletteViewport();
//               break;
//
//           default:
//               System.out.println("uWu something went woopsy");
//               break;
//       }
//
//        Scene mains = new Scene(main,950 ,700);
//        myStage.setScene(mains);

    }

}
