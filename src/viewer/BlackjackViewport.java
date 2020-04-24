package viewer;

import game.PlayBlackJack;
import game.PlaySlotMachine;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import player.Player;

import java.util.HashMap;

public class BlackjackViewport extends GridPane {
    public BlackjackViewport(PlayBlackJack game, Player player) {
        this.getStylesheets().add("Styling/Main.css");
        HashMap<Integer,Integer[]> betStruct = new HashMap<>();
        for(int i = 0; i< 5;i++) {
            betStruct.put(i, new Integer[]{0});
        System.out.println(betStruct.get(i)[0]);
        }
        int size = 5;
        Text numbere = new Text("Bal :" + player.getBalance());
        this.add(numbere,10,0,2,1);
        for (int x = 0; x < 2; x++) {
            for (int i = 0; i < 2; i++) {

                Rectangle node = new Rectangle();
                node.getStyleClass().add("roul");
                node.setWidth(size * 10);
                node.setHeight(size * 10);
                Text number = new Text();
                int rand = (int) (Math.random() * 7);
                if(x==0&&i==0)
                    number.setText("hIdden");
                else
                    number.setText(Integer.toString(rand));
                StackPane stack = new StackPane();
                stack.getStyleClass().add("roul");
                stack.getChildren().addAll(node, number);
                stack.setOnMouseClicked(e -> {

                });
                this.add(stack, i, x, 1, 1);
            }
        }

        for(int i = 0; i < 5; i++){
            Rectangle node = new Rectangle();
            node.getStyleClass().add("roul");
            node.setWidth(size * 10);
            node.setHeight(size * 10);
            int val = i;
            Text number = new Text(Integer.toString(i));
            StackPane stack = new StackPane();
            stack.getStyleClass().add("roul");
            stack.getChildren().addAll(node, number);
            stack.setOnMouseClicked(e -> {
                node.getStyleClass().clear();
                stack.getStyleClass().clear();
                if(betStruct.get(val)[0]>0){
                    node.getStyleClass().add("roul");
                    stack.getStyleClass().add("roul");
                    betStruct.get(val)[0] = 0;
                }
                else{
                    betStruct.get(val)[0] = 1;
                    node.getStyleClass().add("betted");
                    stack.getStyleClass().add("betted");
                }
            });
            this.add(stack, i, 6, 1, 1);
        }
        Button submit = new Button("hit");
        submit.setOnMouseClicked(e -> {
            System.out.println(betStruct);
            game.playBlackJackRound(betStruct,player);

        });
        this.add(submit, 0 , 7  ,  2, 1);
        Button submit2 = new Button("stay");
        submit2.setOnMouseClicked(e -> {
            System.out.println(betStruct);
            game.playBlackJackRound(betStruct,player);

        });
        this.add(submit2, 2 , 7  ,  2, 1);
    }

}
