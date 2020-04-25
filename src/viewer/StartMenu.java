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
import java.util.ResourceBundle;

public class StartMenu {

    private VBox innerbtns;
    private BorderPane layout;
    private static ResourceBundle myResources;


    public StartMenu(Main main, Player player, ResourceBundle resources) {
        myResources = resources;
        Button roulette_btn = new Button(myResources.getString("ROULETTE"));
        roulette_btn.setId("RouletteButton");
        Button blackjack_btn = new Button(myResources.getString("BLACKJACK"));
        blackjack_btn.setId("BlackJackButton");
        Button slots_btn = new Button(myResources.getString("SLOTS"));
        slots_btn.setId("SlotsButton");
        roulette_btn.setOnAction(e -> {
            main.gameStart(0);
        });
        blackjack_btn.setOnAction(e -> {
            main.gameStart(1);
        });
        slots_btn.setOnAction(e -> {
            main.gameStart(2);
        });
        innerbtns = new VBox();
        layout = new BorderPane();
        layout.setId("BorderPane");
        innerbtns.setPadding(new Insets(10, 50, 50, 50));
        innerbtns.setSpacing(25);
        roulette_btn.getStyleClass().add("rect");
        blackjack_btn.getStyleClass().add("rect");
        slots_btn.getStyleClass().add("rect");
        Text balance = new Text( myResources.getString("YOUR-CURRENT-BALANCE") + player.getBalance());
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
        Text title = new Text(myResources.getString("TITLE"));
        title.getStyleClass().add("txt");
        header.getChildren().add(title);
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(30, 0, 30, 0));
        ret.getChildren().add(header);
        Text gametitle = new Text(gameType);
        gametitle.setId("TitleText");
        gametitle.getStyleClass().add("liltxt2");
        HBox nextline = new HBox();
        nextline.setAlignment(Pos.CENTER);
        nextline.getChildren().add(gametitle);
        ret.getChildren().add(nextline);

        return ret;
    }

}

