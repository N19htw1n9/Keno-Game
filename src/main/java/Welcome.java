import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.*;

public class Welcome extends Application {
    private TextArea textBox; //Changed from TextField to TextArea for larger text

    public static void main(String[] args)
    {
        launch(args);
    }

    public MenuBar createMenuBar(Stage primaryStage) {
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
        iThree.setOnAction(e -> primaryStage.close());
        mOne.getItems().add(iThree); //add menu item to first menu

        menu.getMenus().addAll(mOne);

        return menu;
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Keno");

        Text message = new Text();
        message.setText("Welcome to Keno");

        Button playGame = new Button("Play game");
        playGame.setOnAction(e -> primaryStage.setScene(new GameScreen(primaryStage).getScene()));

        textBox = new TextArea();

        MenuBar menu = createMenuBar(primaryStage);

        VBox content = new VBox(
                20,
                message,
                playGame,
                textBox //Unsure of how to hide the textbox until a menu item has been selected
        );
        content.setPadding(new Insets(0, 20, 0, 20));

        Scene welcomeScreen = new Scene(
                new VBox(
                        20,
                        menu,
                        content
                ),
                1050,
                950
        );
        primaryStage.setScene(welcomeScreen); //set the scene in the stage
        primaryStage.show(); //make visible to the user
    }
}