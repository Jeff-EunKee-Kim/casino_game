package ooga;


import viewer.*;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Feel free to completely change this code or delete it entirely. 
 */
public class Main extends Application {

    private double TIMESTEP;
    private Stage myStage;
    private Timeline myAnimation;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        myStage = primaryStage;
        myStage.setTitle("Casino Amicorum Spectaculum");
        TIMESTEP = 1;
        StartMenu startMenu = new StartMenu();
        Scene firstscene = new Scene(startMenu.getLayout(),850,600);
        myStage.setScene(firstscene);
        myStage.show();
    }

}
