import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class GameScreen {
    private Scene scene;
    private TextArea textBox;

    public GameScreen() {
        Button b1 = new Button("You are the game...");
        textBox = new TextArea();
        GridPane grid = new GridPane();
        addGrid(grid);

        this.scene = new Scene(
                new VBox(
                        20,
                        b1,
                        textBox,
                        grid
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
