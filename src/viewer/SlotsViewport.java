package viewer;

import game.PlaySlotMachine;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import player.Player;

public class SlotsViewport extends GridPane {

    public SlotsViewport(PlaySlotMachine game, Player player){
        int size = 5;
        Rectangle node = new Rectangle();
        node.getStyleClass().add("roul");
        node.setWidth(size * 10);
        node.setHeight(size * 10);
        Text number = new Text(Integer.toString((Math.random(0,100)));
        StackPane stack = new StackPane();
        stack.getStyleClass().add("roul");
        stack.getChildren().addAll(node, number);


    }
}
