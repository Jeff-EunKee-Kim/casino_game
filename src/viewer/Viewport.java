package viewer;

import blackjack.Card;
import enums.Rank;
import game.AbstractGame;
import game.PlayBlackJack;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import player.Player;
import result.GameResult;

abstract class Viewport extends GridPane {
    GameResult result;
    AbstractGame game;
    Player player;
    public Viewport(PlayBlackJack game, Player player){
        this.getStylesheets().add("Styling/Main.css");
        this.player = player;
        this.game = game;
    }

    private void next(){

    }

    protected StackPane generateBlock(int size){
        Rectangle node = new Rectangle();
        node.getStyleClass().add("roul");
        node.setWidth(size);
        node.setHeight(size);
        Text number = new Text();
        number.getStyleClass().add("ds");
        StackPane stack = new StackPane();
        stack.getStyleClass().add("roul");
        stack.getChildren().addAll(node, number);
        return stack;
    }


}
