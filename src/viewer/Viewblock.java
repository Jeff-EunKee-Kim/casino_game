package viewer;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import javax.swing.text.View;

public class Viewblock extends StackPane {
    Rectangle frame;
    Text value;
    public Viewblock(int size){
        this(size,"");
    }
    public Viewblock(int size, String text){
        this.getStylesheets().add("Styling/Main.css");
        frame = new Rectangle();
        frame.getStyleClass().add("roul");
        frame.setWidth(size);
        frame.setHeight(size);
        value = new Text(text);
        value.getStyleClass().add("ds");
        this.getStyleClass().add("roul");
        this.getChildren().addAll(frame, value);
    }
    public void setValue(String value) {
        this.value.setText(value);
    }

    public Text getValue() {
        return value;
    }
}
