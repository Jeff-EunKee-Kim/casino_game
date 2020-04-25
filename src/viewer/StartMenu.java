package viewer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.image.Image;
import ooga.Main;
import player.Player;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class StartMenu {

    private VBox innerbtns;
    private BorderPane layout;
    //private Game game;


    public StartMenu(Main main,Player player) {
        //game = new Game();
        Button roulette_btn = new Button("Roulette");
        Button blackjack_btn = new Button("Blackjack");
        Button slots_btn = new Button("Slots");
        blackjack_btn.setId("ldbtn");
        roulette_btn.setId("strbtn");
        slots_btn.setId("sltsbtn");




        roulette_btn.setOnAction(e -> {
            main.gameStart(0);
            //game.start(0);
        });
        blackjack_btn.setOnAction(e -> {
            main.gameStart(1);
            //game.start(1);
        });
        slots_btn.setOnAction(e -> {
            main.gameStart(2);

            //game.start(2);
        });
        innerbtns = new VBox();
        layout = new BorderPane();

        innerbtns.setPadding(new Insets(10, 50, 50, 50));
        innerbtns.setSpacing(25);
        roulette_btn.getStyleClass().add("rect");
        blackjack_btn.getStyleClass().add("rect");
        slots_btn.getStyleClass().add("rect");
        Text balance = new Text("Your current balance : $"+ player.getBalance());
        innerbtns.getChildren().addAll( roulette_btn,blackjack_btn,slots_btn, balance);
        innerbtns.setAlignment(Pos.CENTER);
        innerbtns.getStyleClass().add("bggg-2");
        layout.getStylesheets().add("Styling/Main.css");
        layout.getStyleClass().add("bggg");
        layout.setTop(generateTitle(""));
        layout.setCenter(innerbtns);
    }

    public BorderPane getLayout() {
        return layout;
    }

    public static VBox generateTitle(String gameType){
        HBox header = new HBox();
        VBox ret = new VBox();
        Text title = new Text("Amicorum Spectaculum");
        title.getStyleClass().add("txt");
        header.getChildren().add(title);
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(30, 0, 30, 0));
        ret.getChildren().add(header);
        Text gametitle = new Text(gameType);

        gametitle.getStyleClass().add("liltxt2");
        HBox nextline = new HBox();
        nextline.setAlignment(Pos.CENTER);
        nextline.getChildren().add(gametitle);
        ret.getChildren().add(nextline);

        return ret;
    }

}

