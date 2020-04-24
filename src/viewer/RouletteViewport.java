package viewer;

import result.RouletteResult;
import result.SlotResult;
import game.AbstractGame;
import game.PlayRoulette;
import game.PlaySlotMachine;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import ooga.Main;
import player.Player;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class RouletteViewport extends GridPane {
    RouletteResult result;
    PlayRoulette game;
    Player player;
    HashMap<Integer,Integer> betStruct;
    Text sts;
    public RouletteViewport(PlayRoulette game, Player player){
        sts  = new Text("[-]");
        this.game = game;
        this.player = player;
        this.getStylesheets().add("Styling/Main.css");
        betStruct = new HashMap<>();

        render();
    }

    private void next(){

        render();

    }
    private void render(){
        for(int i = 0; i< 41;i++)
            betStruct.put(i,0);
        this.getChildren().clear();
        int count = 1;
        int size = 4;
        Text numbere = new Text("Bal :" + player.getBalance());
        this.add(numbere,18,0,2,1);
        this.add(sts,18,1,2,1);
        for (int y = 0; y < 12 ; y++){
            for(int x = 0; x < 3 ;x++){
                Rectangle node = new Rectangle();
                node.getStyleClass().add("roul");
                node.setWidth(size * 10);
                node.setHeight(size * 10);
                Text number = new Text(Integer.toString(count));
                StackPane stack = new StackPane();
                stack.getStyleClass().add("roul");
                stack.getChildren().addAll(node, number);
                int val = count;
                stack.setOnMouseClicked(e -> {
                    node.getStyleClass().clear();
                    stack.getStyleClass().clear();
                    if(betStruct.get(val)>0){
                        node.getStyleClass().add("roul");
                        stack.getStyleClass().add("roul");
                        betStruct.put(val,0);
                    }
                    else{
                        betStruct.put(val,5);
                        node.getStyleClass().add("betted");
                        stack.getStyleClass().add("betted");
                    }

                    //game.start(2);
                });
                count++;
                this.add(stack, y, x  ,  1, 1);
            }
        }

        for(int i =0;i<5;i++){
            int val;
            if(count==41)
                val = 0;
            else
                val = count;
            Rectangle node = new Rectangle();
            node.getStyleClass().add("roul");
            node.setWidth(size * 24);
            node.setHeight(size * 10);
            Text number = new Text(Integer.toString(val));
            StackPane stack = new StackPane();
            stack.getStyleClass().add("roul");
            stack.getChildren().addAll(node, number);
            stack.setOnMouseClicked(e -> {
                node.getStyleClass().clear();
                stack.getStyleClass().clear();
                if(betStruct.get(val)>0){
                    node.getStyleClass().add("roul");
                    stack.getStyleClass().add("roul");
                    betStruct.put(val,0);
                }
                else{
                    betStruct.put(val,5);
                    node.getStyleClass().add("betted");
                    stack.getStyleClass().add("betted");
                }

                //game.start(2);
            });
            count++;
            this.add(stack,i * 2 , 4  ,  2, 1);

        }


        Button submit = new Button("submit");
        submit.setOnMouseClicked(e -> {
            System.out.println(betStruct);
            result =  game.playRouletteRound(betStruct,player);
            if(result.getIsValidBet()) {
                String resulter  = result.getTickerPosition().getNumber() + " " + result.getTickerPosition().getColor();
                sts.setText(resulter);

                next();
            }
            else
                sts.setText("INVALID");
        });
        this.add(submit, 0 , 5  ,  2, 1);

    }


}
