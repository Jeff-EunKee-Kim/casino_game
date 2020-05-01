package viewer;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

import java.io.File;
import java.util.ArrayList;

public class SelectionMenu extends VBox {


    public SelectionMenu(String path,int type, ooga.Main main){
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        File folder = new File("src/" + path);
        File[] listOfFiles = folder.listFiles();

        ArrayList<Button> options = new ArrayList<>();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                String filename = file.getName();
                String pname = filename.split("\\.")[0];
                Button toAdd = new Button(pname);
                toAdd.getStyleClass().add("rect");
                toAdd.setOnAction(e -> {
                    this.getChildren().clear();
                    main.buildView(path + "." + pname,type);
                });
                this.getChildren().add(toAdd);
            }
        }

    }
}
