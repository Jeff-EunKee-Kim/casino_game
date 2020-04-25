package viewer;

import result.SlotResult;
import game.PlaySlotMachine;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import player.Player;

import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class SlotsViewport extends GridPane {
    private SlotResult result;
    private int[][] screen;
    private PlaySlotMachine game;
    private Player player;
    private HashMap<Integer,Integer> betStruct;
    private ResourceBundle myResources;
    public SlotsViewport(PlaySlotMachine game, Player player, ResourceBundle resources) {
        myResources = resources;
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
        Text numbere = new Text( myResources.getString("BAL") + player.getBalance());
        numbere.getStyleClass().add("balbad");
        Text sts  = new Text();
        this.add(numbere,10,0,2,1);
        this.add(sts,10,1,2,1);
        for (int x = 0; x < 3; x++) {
            for (int i = 0; i < 3; i++) {
               Viewblock stack = new Viewblock(50,100,   Integer.toString(screen[x][i]));
                this.add(stack, 1 + i, x, 1, 1);
            }
        }
        String[] bets = {"Top","Mid","Btm","L-R","R-L"};
        for(int i = 0; i < 5; i++){
            int val = i;
            Viewblock stack = new Viewblock(50,100, bets[i]);
            stack.setOnMouseClicked(e -> {
                stack.getStyleClass().clear();
                if(betStruct.get(val)>0){
                    stack.getStyleClass().add("roul");
                    betStruct.put(val,0);
                }
                else{
                    betStruct.put(val,1);
                    stack.getStyleClass().add("betted");
                }
            });
            this.add(stack, i, 6, 1, 1);
        }
        Button submit = new Button( myResources.getString("PLACEBET"));
        submit.getStyleClass().add("newbtn2");
        submit.setOnMouseClicked(e -> {
            result = game.playSlotsRound(betStruct,player);
            if(result.getIsValidBet())
                next();
            else
                sts.setText( myResources.getString("ERROR2"));
        });
        this.add(submit, 2 , 7  ,  1, 1);
    }

}
