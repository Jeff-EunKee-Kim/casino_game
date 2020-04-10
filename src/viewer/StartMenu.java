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
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class StartMenu {

    private Text title;
    private VBox innerbtns;
    private BorderPane layout;
    //private Game game;

    public StartMenu() {
        //game = new Game();
        Button roulette_btn = new Button("Roulette");
        Button blackjack_btn = new Button("Blackjack");
        Button slots_btn = new Button("Slots");
        blackjack_btn.setId("ldbtn");
        roulette_btn.setId("strbtn");
        slots_btn.setId("sltsbtn");
        title = new Text();
        title.setId("ttl");
        title.setText("Amicorum Spectaculum");
        title.getStyleClass().add("txt");
        roulette_btn.setOnAction(e -> {
            innerbtns.getChildren().removeAll(roulette_btn,blackjack_btn,slots_btn);
            //game.start(0);
        });
        blackjack_btn.setOnAction(e -> {
            innerbtns.getChildren().removeAll(roulette_btn,blackjack_btn,slots_btn);
            //game.start(1);
        });
        slots_btn.setOnAction(e -> {
            innerbtns.getChildren().removeAll(roulette_btn,blackjack_btn,slots_btn);
            //game.start(2);
        });
        innerbtns = new VBox();
        layout = new BorderPane();
        HBox header = new HBox();
        innerbtns.setPadding(new Insets(10, 50, 50, 50));
        innerbtns.setSpacing(25);
        roulette_btn.getStyleClass().add("rect");
        blackjack_btn.getStyleClass().add("rect");
        slots_btn.getStyleClass().add("rect");
        innerbtns.getChildren().addAll( roulette_btn,blackjack_btn,slots_btn);
        innerbtns.setAlignment(Pos.CENTER);
        innerbtns.getStyleClass().add("bggg-2");
        header.getChildren().add(title);
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(30, 0, 30, 0));
        layout.getStylesheets().add("Styling/Main.css");
        layout.getStyleClass().add("bggg");
        layout.setTop(header);
        layout.setCenter(innerbtns);
    }

    public BorderPane getLayout() {
        return layout;
    }
}
