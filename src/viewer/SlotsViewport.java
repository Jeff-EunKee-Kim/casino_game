package viewer;

import Result.SlotResult;
import game.PlaySlotMachine;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import player.Player;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class SlotsViewport extends GridPane {
    SlotResult result;
    int[][] screen;
    PlaySlotMachine game;
    Player player;
    HashMap<Integer,Integer> betStruct;
    public SlotsViewport(PlaySlotMachine game, Player player) {
        betStruct = new HashMap<>();
        this.game = game;
        this.player = player;
        this.getStylesheets().add("Styling/Main.css");
        screen = new int[3][3];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                int rand =  (int) (Math.random() * 7);
                screen[x][y] = rand;
            }
        }
        render();
    }
    private void next(){
        screen= result.getScreen();
        render();
    }
    private void render(){
        this.getChildren().clear();
        for(int i = 0; i< 5;i++)
            betStruct.put(i,0);
        int size = 5;
        Text numbere = new Text("Bal :" + player.getBalance());
        Text sts  = new Text();
        this.add(numbere,10,0,2,1);
        this.add(sts,10,1,2,1);
        for (int x = 0; x < 3; x++) {
            for (int i = 0; i < 3; i++) {
                Rectangle node = new Rectangle();
                node.getStyleClass().add("roul");
                node.setWidth(size * 10);
                node.setHeight(size * 10);
                Text number = new Text(Integer.toString(screen[x][i]));
                StackPane stack = new StackPane();
                stack.getStyleClass().add("roul");
                stack.getChildren().addAll(node, number);
                stack.setOnMouseClicked(e -> {
                    number.setText(Integer.toString(((int) (Math.random() * 7))));
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
                if(betStruct.get(val)>0){
                    node.getStyleClass().add("roul");
                    stack.getStyleClass().add("roul");
                    betStruct.put(val,0);
                }
                else{
                    betStruct.put(val,1);
                    node.getStyleClass().add("betted");
                    stack.getStyleClass().add("betted");
                }
            });
            this.add(stack, i, 6, 1, 1);
        }
        Button submit = new Button("submit");
        submit.setOnMouseClicked(e -> {
            System.out.println(betStruct);
            result = game.playSlotsRound(betStruct,player);
            try {
                TimeUnit.SECONDS.sleep(1);
            }
            catch (Exception ex){
                System.out.println("something went wrong woops : " + ex.getLocalizedMessage());
            }
            if(result.getIsValidBet())
                next();
            else
                sts.setText("INVALID");
        });
        this.add(submit, 0 , 7  ,  2, 1);
    }

}
