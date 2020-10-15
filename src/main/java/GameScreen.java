import Components.MainMenuBar;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameScreen {
    private Stage primaryStage;
    private Scene scene;
    private TextArea textBox;

    public GameScreen(Stage primaryStage) {
        this.primaryStage = primaryStage;

        createScene();
    }

    public void createScene() {
        Button b1 = new Button("You are the game...");

        textBox = new TextArea();

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        addGrid(grid);

        VBox content = new VBox(
                20,
                b1,
                textBox,
                grid
        );
        content.setPadding(new Insets(0, 20, 0, 20));

        this.scene = new Scene(
                new VBox(
                        20,
                        MainMenuBar.getMainMenuBar(primaryStage, textBox),
                        content
                ),
                800,
                800
        );
    }

    public Scene getScene() {
        return this.scene;
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
