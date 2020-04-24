package viewer;

import enums.Rank;
import game.PlayBlackJack;
import game.PlaySlotMachine;
import blackjack.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    int flag ;
    Text numberref;
    int amount;
    HashMap<Integer,blackJackHand> betStruct;
    public BlackjackViewport(PlayBlackJack game, Player player) {
        this.getStylesheets().add("Styling/Main.css");
        betStruct = game.getHands();
        this.player = player;
        this.game = game;
        flag = 1;
        setup();


    }
    private void setup(){
        this.getChildren().clear();
        Label title = new Label("amount bet :");
        Label err = new Label("");
        title.getStyleClass().add("liltxt");
        err.getStyleClass().add("liltxt");
        this.add(title, 0, 0);
        this.add(err, 0, 1);
        TextField titleTextField = new TextField();
        this.add(titleTextField, 1, 0,2,1);
        Button submit = new Button("Submit");
        submit.getStyleClass().add("rect");
        this.add(submit,0,2,2,1);
        submit.setOnAction(e -> {
            String exptitle = titleTextField.getText();
            int bet = Integer.parseInt(exptitle);
            if(player.validate(bet)){
                amount = bet;
                render();
            }
            else {
                err.setText("INVALD");
            }
        });
    }


    private void next(){
       betStruct = result.getMap();
       System.out.println(result.getWinStatus());
        render();
       if(result.getWinStatus()==1)
        System.out.println("win");
        else if(result.getWinStatus()==0)
            System.out.println("loose");
        else if(result.getWinStatus()==2)
            System.out.println("tie");
        if(result.getWinStatus()!=3){

           Button newround = new Button("newround");
            newround.setOnMouseClicked(e -> {
                flag =1;
                betStruct = game.startBlackjackRound();
                render();
            });
            this.add(newround, 2 , 7  ,  2, 1);
        }


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
                if(flag==1){
                    numberref = number;
                    number.setText("hIdden");
                    flag++;
                }
                else{
                    number.setText(num.toString());
                }
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

           result =  game.playBlackJackRound(betStruct,player,0,amount);
            System.out.println(result);
            next();
        });
        this.add(submit, 0 , 7  ,  2, 1);
        Button submit2 = new Button("stay");
        submit2.setOnMouseClicked(e -> {

            result =   game.playBlackJackRound(betStruct,player,1,amount);
            System.out.println(result);
            next();


        });
        this.add(submit2, 4 , 7  ,  2, 1);
    }

}
