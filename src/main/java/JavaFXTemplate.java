import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXTemplate extends Application {
    private TextField t1;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello from JavaFX");

        Button b1 = new Button("button 1");
        t1 = new TextField();


        b1.setOnAction(e -> t1.setText("Message from button 1"));

        MenuBar menu = new MenuBar();
        Menu mOne = new Menu("option 1"); //a menu goes inside a menu bar
        Menu mTwo = new Menu("option 2");

        MenuItem iOne = new MenuItem("click me");
        iOne.setOnAction(e -> t1.setText("menu item was clicked"));
        mOne.getItems().add(iOne); //add menu item to first menu

        menu.getMenus().addAll(mOne, mTwo);
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		addGrid(grid);

        //new scene with root node
        Scene scene = new Scene(
                new VBox(
                        20,
                        menu,
                        b1,
                        t1,
                        grid
                ),
                700,
                700
        );
        primaryStage.setScene(scene); //set the scene in the stage
        primaryStage.show(); //make visible to the user
    }

    /**
     * Genereates a 4x4 grid and adds buttons
     * @param grid
     */
    public void addGrid(GridPane grid) {
        int counter = 1;
        for (int x = 0; x < 8; x++) {
            for (int i = 0; i < 10; i++) {
                Button b = new Button(Integer.toString(counter));
                int finalX = x;
                int finalI = i;
                b.setOnAction(e -> t1.setText("Hello from button[" + finalX + ", " + finalI + "]"));
                grid.add(b, i, x);
                counter++;
            }
        }
    }
}
