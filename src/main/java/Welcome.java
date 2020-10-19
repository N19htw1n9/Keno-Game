import Components.MainMenuBar;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.*;

public class Welcome extends Application {
    private Text text; //Changed from TextField to TextArea for larger text
    public static Scene welcomeScreen;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Keno");

        Text message = new Text();
        message.setText("Welcome to Keno");

        Button playGame = new Button("Play game");
        playGame.setOnAction(e -> primaryStage.setScene(new GameScreen(primaryStage).getScene()));

        text = new Text();

        VBox content = new VBox(
                20,
                message,
                playGame,
                text //Unsure of how to hide the textbox until a menu item has been selected
        );
        content.setPadding(new Insets(0, 20, 0, 20));

        Scene welcomeScreen = new Scene(
                new VBox(
                        20,
                        MainMenuBar.getMainMenuBar(primaryStage, text),
                        content
                ),
                700,
                500
        );
        primaryStage.setScene(welcomeScreen); //set the scene in the stage
        primaryStage.show(); //make visible to the user
    }
}