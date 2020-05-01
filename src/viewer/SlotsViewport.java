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
    private  ResourceBundle slotRules;
    private int size;
    public SlotsViewport(PlaySlotMachine game, Player player, ResourceBundle resources) {
        slotRules = ResourceBundle.getBundle("properties.NormalSlot");
        size = Integer.parseInt(slotRules.getString("SLOT_SIZE"));
        myResources = resources;
        betStruct = new HashMap<>();
        this.game = game;
        this.player = player;
        this.getStylesheets().add("Styling/Main.css");
        screen = new int[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                int rand =  (int) (Math.random() * 5);
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
        for(int i = -2; i< size;i++)
            betStruct.put(i,0);
        Text numbere = new Text( myResources.getString("BAL") + player.getBalance());
        numbere.getStyleClass().add("balbad");
        Text sts  = new Text();
        this.add(numbere,10,0,2,1);
        this.add(sts,10,1,2,1);
        for (int x = 0; x < size; x++) {
            for (int i = 0; i < size; i++) {
               Viewblock stack = new Viewblock(50,100,   Integer.toString(screen[x][i]));
                this.add(stack, 1 + i, x, 1, 1);
            }
        }
        String[] bets = {"L-R","R-L"};
        for(int i = -2; i < size ; i++){
            int val = i;
            String title = "Row " + i;
            if(i<0)
                title = bets[i+2];
            Viewblock stack = new Viewblock(50,100, title);
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
            this.add(stack, i+2, 6, 1, 1);
        }
        Button submit = new Button( myResources.getString("PLACEBET"));
        submit.getStyleClass().add("newbtn2");
        submit.setOnMouseClicked(e -> {
            result = game.playSlotsRound(betStruct,player,"properties.NormalSlot");
            if(result.getIsValidBet())
                next();
            else
                sts.setText( myResources.getString("ERROR2"));
        });
        this.add(submit, 2 , 7  ,  1, 1);
    }

}
