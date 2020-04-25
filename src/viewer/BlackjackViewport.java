package viewer;

import enums.Rank;
import enums.Suit;
import game.PlayBlackJack;
import blackjack.*;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import player.Player;
import result.BlackjackResult;
import java.util.HashMap;

public class BlackjackViewport extends GridPane {

    private BlackjackResult result;
    private PlayBlackJack game;
    private Player player;
    private int flag ;
    private int amount;
    private Button hit;
    private Button stay;
    private HashMap<Integer,blackJackHand> hands;

    public BlackjackViewport(PlayBlackJack game, Player player) {
        this.getStylesheets().add("Styling/Main.css");
        this.player = player;
        this.game = game;
        this.hands = game.getHands();
        flag = 1;
        setup();
    }
    private void setup(){
        this.getChildren().clear();
        this.setHgap(10);
        this.setVgap(10);

        Label title = new Label("Amount to bet : $");
        title.getStyleClass().add("liltxt");
        this.add(title, 0, 0,1,1);

        Label error = new Label("");
        error.getStyleClass().add("liltxt");
        this.add(error, 0, 1,2,1);

        TextField input = new TextField();
        this.add(input, 1, 0,1,1);

        Button submit = new Button("Submit");
        submit.getStyleClass().add("newbtn");
       submit.setAlignment(Pos.CENTER);
        this.add(submit,0,2,2,1);
        submit.setOnAction(e -> {
            String exptitle = input.getText();
            try {
                int bet = Integer.parseInt(exptitle);
                if(player.validate(bet)){
                    amount = bet;
                    render();
                }
                else
                    error.setText("Insufficient funds");
            }
            catch (Exception er){
                error.setText("Not a valid number");
            }
        });
    }


    private void next(){
       hands = result.getMap();
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
            newround.getStyleClass().add("newbtn2");
            newround.setOnMouseClicked(e -> {
                flag =1;
                hands = game.startBlackjackRound();
                setup();
            });
            this.add(newround, 2 , 7  ,  2, 1);
            this.getChildren().removeAll(hit,stay);
        }
    }

    private void render(){
        this.getChildren().clear();
        Text numbere = new Text("Bal :" + player.getBalance());
        numbere.getStyleClass().add("balbad");
        this.add(numbere,10,0,2,1);
        for (int x = 0; x < 2; x++) {
            for (int y = 0; y < hands.get(x).handSize(); y++) {
                Viewblock order = new Viewblock(100);
                Card val = hands.get(x).getCard(y);
                Rank num = val.getMyRank();
                Suit suit = val.getMySuit();
                if(flag==1)
                    order.setValue("Hidden");
                else
                    order.setValue(num.toString() +"\n"+ suit.toString());
                flag=0;
                this.add(order, y, x, 1, 1);
            }
        }


        hit = new Button("hit");
        hit.getStyleClass().add("newbtn2");
        hit.setOnMouseClicked(e -> {
           result = game.playBlackJackRound(hands,player,0,amount);
           next();
        });
        this.add(hit, 0 , 7  ,  1, 1);

        stay = new Button("stay");
        stay.getStyleClass().add("newbtn2");
        stay.setOnMouseClicked(e -> {
            result = game.playBlackJackRound(hands,player,1,amount);
            next();
        });
        this.add(stay, 1 , 7  ,  1, 1);
    }

}
