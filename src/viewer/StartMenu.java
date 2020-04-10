package viewer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.File;
import java.util.ArrayList;

public class StartMenu {

    private Text title;
    private VBox layout;

    /**
     * Constructs the first scene in the simulation which is a start menu, giving the user options to make a new simulation or load an existing one from the
     * saved files
     */
    public StartMenu() {
       // ResourceBundle mybundle = ResourceBundle.getBundle("data.Styling.Main");
       // System.out.println(System.getProperty("user.dir"));
        Button start = new Button("New");
        Button load = new Button("Load");
        load.setId("ldbtn");
        start.setId("strbtn");
        title = new Text();
        title.setId("ttl");
        title.setText("Welcome to simulation");
        title.getStyleClass().add("txt");
        start.setOnAction(e -> {
            layout.getChildren().removeAll(start,load);
            selectionMenu("data/Configurations");
        });
        load.setOnAction(e -> {
            layout.getChildren().removeAll(start,load);
            selectionMenu("data/SaveFiles");

        });
        layout = new VBox();
        layout.setPadding(new Insets(10, 50, 50, 50));
        layout.setSpacing(25);
        start.getStyleClass().add("rect");
        load.getStyleClass().add("rect");
        layout.getChildren().addAll(title, start,load);
        layout.setAlignment(Pos.CENTER);
        layout.getStylesheets().add("Styling/Main.css");
    }

    /**
     *
     * @return returns layout of this startmenu object
     */
    public VBox getLayout() {
        return layout;
    }

    /**
     * Generates a list of available files that can be used to run a simulation. Its abstraction allows for it to be
     * used with both new file templates and also old saves.
     * @param path gives a directory from which to list out possible configs/saves to run
     */

    private void selectionMenu(String path){
        title.setText("Select a simulation to run");
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        ArrayList<HBox> files = new ArrayList<>();

        int size = listOfFiles.length;
            files.add(new HBox());
            if (size>4) {
                size=size/4;
                for (int i = 0; i <size;i++){
                    files.add(new HBox());
                }
            }
        ArrayList<Button> options = new ArrayList<>();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                String filename = file.getName();
                Button toAdd = new Button(filename.split("\\.")[0]);
                toAdd.getStyleClass().add("rect");
                toAdd.setOnAction(e -> {
                    layout.getChildren().clear();
                  //  Main.initSimulation(path+"/"+filename);
                });
                options.add(toAdd);
            }
        }
        int iter = 0;
        int total = options.size();
        int flag = 0;
        if (total%4!=0) flag = 1;
        int cont = 4;
        for(HBox row : files){
            if (flag == 1&&total<4) cont = total;
            for(int i = iter ;i < iter +cont;i++)
                row.getChildren().add(options.get(i));
            iter+=4; total-=4;
            row.setAlignment(Pos.CENTER); row.setSpacing(20);
            layout.getChildren().add(row);
        }
    }
}
