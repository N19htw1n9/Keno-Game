import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXTemplate extends Application {
    private TextArea textBox; //Changed from TextField to TextArea for larger text

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Keno");

        Button playGame = new Button("Play game");
        textBox = new TextArea();


        playGame.setOnAction(e -> textBox.setText("Message from button 1"));

        MenuBar menu = new MenuBar();
        Menu mOne = new Menu("Menu");

        //Menu options need to be implemented to complete Step 1

        MenuItem iOne = new MenuItem("Display the rules of the game");
        iOne.setOnAction(e -> textBox.setText("Instructions"));
        mOne.getItems().add(iOne); //add menu item to first menu

        MenuItem iTwo = new MenuItem("Display the odds of winning");
        iTwo.setOnAction(e -> textBox.setText("Odds:"));
        mOne.getItems().add(iTwo); //add menu item to first menu

        MenuItem iThree = new MenuItem("Exit the game");
        iThree.setOnAction(e -> textBox.setText("Exit"));
        mOne.getItems().add(iThree); //add menu item to first menu

        menu.getMenus().addAll(mOne);
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		addGrid(grid);

        Scene scene = new Scene(
                new VBox(
                        20,
                        menu,
                        playGame,
                        textBox //Unsure of how to hide the textbox until a menu item has been selected
                ),
                1050,
                950
        );
        primaryStage.setScene(scene); //set the scene in the stage
        primaryStage.show(); //make visible to the user


        //Since the scene for the game is different,
        // I commented this out until we implement the EventHandler for the 'playGame' button
        /*Scene GameScene = new Scene(
                new VBox(
                        20,
                        menu,
                        b1,
                        textBox,
                        grid
                ),
                800,
                800
        );
        primaryStage.setScene(scene); //set the scene in the stage
        primaryStage.show(); //make visible to the user*/
    }

    /**
     * Generates a 4x4 grid and adds buttons
     * @param grid
     */
    public void addGrid(GridPane grid) {
        int counter = 1;
        for (int x = 0; x < 8; x++) {
            for (int i = 0; i < 10; i++) {
                Button b = new Button(Integer.toString(counter));
                int finalX = x;
                int finalI = i;
                b.setOnAction(e -> textBox.setText("Hello from button[" + finalX + ", " + finalI + "]"));
                grid.add(b, i, x);
                counter++;
            }
        }
    }
}
