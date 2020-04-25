package viewer;

import result.RouletteResult;
import game.PlayRoulette;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import player.Player;

import java.util.HashMap;
import java.util.ResourceBundle;

public class RouletteViewport extends GridPane {
    private RouletteResult result;
    private PlayRoulette game;
    private Player player;
    private HashMap<Integer,Integer> betStruct;
    private Text Ball;
    private ResourceBundle myResources;

    public RouletteViewport(PlayRoulette game, Player player, ResourceBundle resources){
        myResources = resources;
        Ball = new Text("");
        Ball.getStyleClass().add("balbad");
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
        Text numbere = new Text( myResources.getString("BAL") + player.getBalance());
        numbere.getStyleClass().add("balbad");
        this.add(numbere,18,0,2,1);
        this.add(Ball,18,1,2,2);
        for (int y = 0; y < 12 ; y++){
            for(int x = 0; x < 3 ;x++){
                Viewblock stack = new Viewblock(Integer.parseInt(myResources.getString("RSIZEH")),  Integer.toString(count));
                int val = count;
                stack.setId("Box" + val);
                stack.setOnMouseClicked(e -> {
                    stack.getStyleClass().clear();
                    if(betStruct.get(val)>0){
                        stack.getStyleClass().add("roul");
                        betStruct.put(val,0);
                    }
                    else{
                        betStruct.put(val,5);
                        stack.getStyleClass().add("betted");
                    }
                });
                count++;
                this.add(stack, y, x  ,  1, 1);
            }
        }
        String[] bets = {"Red","Black","Odd","Even"};
        for(int i =0;i<5;i++){
            int val;
            Viewblock stack;
            if(count==41) {
                val = 0;
                stack = new Viewblock(Integer.parseInt(myResources.getString("RSIZEH")), Integer.parseInt(myResources.getString("RSIZEW")),  Integer.toString(val));
            }
            else {
                val = count;
                stack = new Viewblock(40,90,  bets[i]);
            }

            stack.setOnMouseClicked(e -> {
                stack.getStyleClass().clear();
                if(betStruct.get(val)>0){
                    stack.getStyleClass().add("roul");
                    betStruct.put(val,0);
                }
                else{
                    betStruct.put(val,Integer.parseInt(myResources.getString("BETAMOUNT")));
                    stack.getStyleClass().add("betted");
                }
            });
            count++;
            this.add(stack,i * 2 , 4  ,  2, 1);
        }


        Button submit = new Button(myResources.getString("PLACEBET"));
        submit.getStyleClass().add("newbtn2");
        submit.setOnMouseClicked(e -> {
            result =  game.playRouletteRound(betStruct,player);
            if(result.getIsValidBet()) {
                String resulter  = result.getTickerPosition().getNumber() + " " + result.getTickerPosition().getColor();
                Ball.setText(resulter);
                next();
            }
            else
                Ball.setText( myResources.getString("ERROR1"));
        });
        this.add(submit, 0 , 7  ,  2, 1);
    }


}
