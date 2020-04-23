package viewer;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class RouletteViewport extends GridPane {

    public RouletteViewport(){
        this.getStylesheets().add("Styling/Main.css");
        Bet bet = new Bet();
        int count = 1;
        int size = 3;
        for (int y = 0; y < 3 ; y++){
            for(int x = 0; x < 12 ;x++){
                Rectangle node = new Rectangle();
                node.getStyleClass().add("roul");
                node.setWidth(size * 10);
                node.setHeight(size * 10);
                Text number = new Text(Integer.toString(count));
                StackPane stack = new StackPane();
                stack.getStyleClass().add("roul");
                stack.getChildren().addAll(node, number);
                stack.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        MouseButton button = event.getButton();
                        node.getStyleClass().clear();
                        stack.getStyleClass().clear();
                        if(button== MouseButton.PRIMARY){
                            node.getStyleClass().add("betted");
                            stack.getStyleClass().add("betted");
                        }else if(button==MouseButton.SECONDARY){
                            node.getStyleClass().add("roul");
                            stack.getStyleClass().add("roul");
                        }else if(button==MouseButton.MIDDLE){
                            System.out.print("MIDDLE button clicked on button");
                        }
                    }
                });



                count++;
                this.add(stack, x , y  ,  1, 1);
            }
        }

        Button submit = new Button("submit");
        submit.setOnMouseClicked(e -> {

        });
        this.add(submit, 0 , 4  ,  2, 1);

    }



}
