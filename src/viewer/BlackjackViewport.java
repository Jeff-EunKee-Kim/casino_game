package viewer;

import enums.Rank;
import game.PlayBlackJack;
import game.PlaySlotMachine;
import blackjack.*;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import player.Player;
import result.BlackjackResult;
import result.SlotResult;

import java.util.HashMap;

public class BlackjackViewport extends GridPane {

    BlackjackResult result;
    int[][] screen;
    PlayBlackJack game;
    Player player;
    HashMap<Integer,blackJackHand> betStruct;
    public BlackjackViewport(PlayBlackJack game, Player player) {
        this.getStylesheets().add("Styling/Main.css");
        betStruct = game.getHands();
        this.player = player;
        this.game = game;
        render();

    }
    private void next(){
       betStruct = result.getMap();
       render();
    }

    private void render(){
        this.getChildren().clear();
        int size = 10;
        Text numbere = new Text("Bal :" + player.getBalance());
        this.add(numbere,10,0,2,1);
        for (int x = 0; x < 2; x++) {
            for (int i = 0; i < betStruct.get(x).handSize(); i++) {
                Rectangle node = new Rectangle();
                node.getStyleClass().add("roul");
                node.setWidth(size * 10);
                node.setHeight(size * 10);
                Text number = new Text();
                Card val = betStruct.get(x).getCard(i);
                Rank num = val.getMyRank();
                if(x==0&&i==0)
                    number.setText("hIdden");
                else
                    number.setText(num.toString());
                System.out.println(num);
                StackPane stack = new StackPane();
                stack.getStyleClass().add("roul");
                stack.getChildren().addAll(node, number);
                stack.setOnMouseClicked(e -> {

                });
                this.add(stack, i, x, 1, 1);
            }
        }


        Button submit = new Button("hit");
        submit.setOnMouseClicked(e -> {

           result =  game.playBlackJackRound(betStruct,player,0);
            System.out.println(result);
            next();
        });
        this.add(submit, 0 , 7  ,  2, 1);
        Button submit2 = new Button("stay");
        submit2.setOnMouseClicked(e -> {

            result =   game.playBlackJackRound(betStruct,player,1);
            System.out.println(result);
            next();


        });
        this.add(submit2, 2 , 7  ,  2, 1);
    }

}
