import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class KenoWelcomeScreen extends Application {
    private TextArea textBox; //Changed from TextField to TextArea for larger text

    public static void main(String[] args)
    {
        launch(args);
    }

    public MenuBar createMenuBar() {
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

        return menu;
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Keno");

        Button playGame = new Button("Play game");
        playGame.setOnAction(e -> primaryStage.setScene(new GameScreen().getScene()));

        textBox = new TextArea();

        MenuBar menu = createMenuBar();
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);

        Scene welcomeScreen = new Scene(
                new VBox(
                        20,
                        menu,
                        playGame,
                        textBox //Unsure of how to hide the textbox until a menu item has been selected
                ),
                1050,
                950
        );
        primaryStage.setScene(welcomeScreen); //set the scene in the stage
        primaryStage.show(); //make visible to the user
    }
}
