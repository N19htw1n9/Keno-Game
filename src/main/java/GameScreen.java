import Components.MainMenuBar;
import Objects.UserPick;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GameScreen {
    private Stage primaryStage;
    private Scene scene;
    private TextArea textBox;
    private UserPick pick;

    public GameScreen(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.pick = new UserPick();

        createScene();
    }

    public ArrayList<RadioButton> createSpots(ToggleGroup spotGroup, GridPane numbers) {
        int[] spotValues = new int[] { 1, 4, 8, 10 };
        ArrayList<RadioButton> spots = new ArrayList<>();

        for (int val : spotValues) {
            RadioButton radioBtn = new RadioButton(Integer.toString(val));
            radioBtn.setOnMouseClicked(e -> {
                this.pick.setSpots(val);
                numbers.setDisable(false);
            });
            spots.add(radioBtn);
            radioBtn.setToggleGroup(spotGroup);
        }
        return spots;
    }

    public void createScene() {
        Button b1 = new Button("You are the game...");

        GridPane numbers = new GridPane();
        numbers.setAlignment(Pos.CENTER);
        numbers.setHgap(8);
        numbers.setVgap(8);
        numbers.setDisable(true);
        addGrid(numbers);

        VBox content = new VBox(
                20,
                b1
        );

        ToggleGroup spotGroup = new ToggleGroup();
        ArrayList<RadioButton> spots = createSpots(spotGroup, numbers);

        HBox spotsHolder = new HBox();
        spotsHolder.setAlignment(Pos.CENTER);
        spotsHolder.setSpacing(25);

        // Add all radio buttons to spotsHolder Horizontal box
        for (RadioButton spot : spots)
            spotsHolder.getChildren().add(spot);

        content.getChildren().addAll(spotsHolder, numbers);
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
     * Generates a 8x10 grid and adds buttons
     * @param grid
     */
    public void addGrid(GridPane grid) {
        int counter = 1;
        for (int x = 0; x < 8; x++) {
            for (int i = 0; i < 10; i++) {
                Button b = new Button(Integer.toString(counter));
                b.setMinWidth(50);
                int finalCounter = counter;
                b.setOnAction(e -> {
                    if (this.pick.getNumbers().size() < this.pick.getSpots())
                        this.pick.setNumber(finalCounter);

                    if (this.pick.getNumbers().size() >= this.pick.getSpots())
                        grid.setDisable(true);

                    System.out.println(this.pick.getNumbers());
                });
                grid.add(b, i, x);
                counter++;
            }
        }
    }
}
