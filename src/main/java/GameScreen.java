import Components.MainMenuBar;
import Objects.DrawRandom;
import Objects.UserPick;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class GameScreen {
    private Stage primaryStage;
    private Scene scene;
    private VBox content;
    private TextArea textBox;
    private UserPick pick;
    private int matches;

    public GameScreen(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.pick = new UserPick();
        this.content = new VBox();
        this.textBox = new TextArea();

        createScene();
    }

    public void createScene() {
        this.createContentVBox();

        this.scene = new Scene(
                new VBox(
                        20,
                        MainMenuBar.getMainMenuBar(this.primaryStage, this.textBox),
                        this.content
                ),
                800,
                800
        );
    }

    public ArrayList<RadioButton> createMatchButtons(ToggleGroup matchButtonsGroup, HBox spotButtonsHolder) {
        int[] spotValues = IntStream.range(1, 5).toArray();
        ArrayList<RadioButton> matches = new ArrayList<>();

        for (int val : spotValues) {
            RadioButton radioBtn = new RadioButton(Integer.toString(val));
            radioBtn.setOnMouseClicked(e -> {
                spotButtonsHolder.setDisable(false);
                this.matches = val;
            });
            matches.add(radioBtn);
            radioBtn.setToggleGroup(matchButtonsGroup);
        }
        return matches;
    }

    public ArrayList<RadioButton> createSpotsButtons(ToggleGroup spotButtonsGroup, GridPane numbers) {
        int[] spotValues = IntStream.range(1, 11).toArray();
        ArrayList<RadioButton> spots = new ArrayList<>();

        for (int val : spotValues) {
            RadioButton radioBtn = new RadioButton(Integer.toString(val));
            radioBtn.setOnMouseClicked(e -> {
                this.pick.setSpots(val);
                numbers.setDisable(false);
            });
            spots.add(radioBtn);
            radioBtn.setToggleGroup(spotButtonsGroup);
        }
        return spots;
    }

    public void createContentVBox() {
        this.content = new VBox(20);

        Text gameText = new Text("Start playing");

        // Create grid
        GridPane numbers = new GridPane();
        numbers.setAlignment(Pos.CENTER);
        numbers.setHgap(15);
        numbers.setVgap(15);
        numbers.setDisable(true);

        // Spot buttons
        ToggleGroup spotButtonsGroup = new ToggleGroup();
        ArrayList<RadioButton> spotButtons = this.createSpotsButtons(spotButtonsGroup, numbers);

        HBox spotButtonsHolder = new HBox();
        spotButtonsHolder.setAlignment(Pos.CENTER);
        spotButtonsHolder.setSpacing(25);
        spotButtonsHolder.setDisable(true);

        // Add all spot buttons to spotsHolder Horizontal box
        for (RadioButton spot : spotButtons)
            spotButtonsHolder.getChildren().add(spot);

        // Match buttons
        ToggleGroup matchButtonGroup = new ToggleGroup();
        ArrayList<RadioButton> matchButtons = this.createMatchButtons(matchButtonGroup, spotButtonsHolder);

        HBox matchButtonsHolder = new HBox();
        matchButtonsHolder.setAlignment(Pos.CENTER);
        matchButtonsHolder.setSpacing(25);

        // Add all match buttons to matchButtonHolder Horizontal box
        for (RadioButton matchButton : matchButtons)
            matchButtonsHolder.getChildren().add(matchButton);

        Text drawStatus = new Text();
        Button drawBtn = new Button("Draw");
        this.getDrawBtn(drawStatus, spotButtonsHolder, numbers, drawBtn);
        drawBtn.setDisable(true);

        this.addGrid(numbers, spotButtonsHolder, drawBtn);

        // Add children
        this.content.getChildren().addAll(
                this.textBox,
                gameText,
                matchButtonsHolder,
                spotButtonsHolder,
                numbers,
                drawBtn,
                drawStatus
        );
        this.content.setPadding(new Insets(0, 20, 0, 20));
    }

    public void getDrawBtn(Text showDrawStatus, HBox spotButtonsHolder, GridPane numbers, Button drawBtn) {
        drawBtn.setOnAction(e -> {
            drawBtn.setDisable(true);

            DrawRandom dr = new DrawRandom(80, 20, 1);
            TreeSet<Integer> draws = dr.draw();

            System.out.println("\nComputer is drawing....");
            System.out.println(draws.toString());

            int matched = 0;
            ArrayList<Integer> userPick = this.pick.getNumbers();
            for (int pick : userPick) {
                if (draws.contains(pick))
                    matched++;
            }
            showDrawStatus.setFill(Color.rgb(212, 62, 62));
            showDrawStatus.setText(Integer.toString(matched) + " were matched!");
            renderPlayAgainBtn();


            // Render draw animation
            int counter = 1;
            numbers.setDisable(false);
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 10; j++) {
                    if (draws.contains(counter)) {
                        CheckBox newCB = createNumbersCheckbox(counter, spotButtonsHolder, numbers, drawBtn);
                        newCB.setSelected(true);

                        numbers.add(newCB, j, i);
                    }
                    counter++;
                }
            }
        });
    }

    public void renderPlayAgainBtn() {
        Button playAgain = new Button("Play again");
        playAgain.setOnAction(e -> {
            this.pick = new UserPick();
            this.createScene();
            this.primaryStage.setScene(this.scene);
        });

        this.content.getChildren().add(playAgain);
    }

    public CheckBox createNumbersCheckbox(final int counter, HBox spotButtonsHolder, GridPane grid, Button drawBtn) {
        CheckBox cb = new CheckBox(Integer.toString(counter));
        cb.setId(Integer.toString(counter));
        cb.setOnAction(e -> {
            if (cb.isSelected() && this.pick.getNumbers().size() < this.pick.getSpots()) {
                this.pick.setNumber(counter);
                spotButtonsHolder.setDisable(true);
            }

            if (!cb.isSelected())
                this.pick.getNumbers().removeIf(elem -> elem == counter);

            if (this.pick.getNumbers().size() >= this.pick.getSpots()) {
                grid.setDisable(true);
                spotButtonsHolder.setDisable(false);
                drawBtn.setDisable(false);
            }
        });
        return cb;
    }

    /**
     * Generates a 8x10 grid and adds buttons
     * @param grid
     */
    public void addGrid(GridPane grid, HBox spotButtonsHolder, Button drawBtn) {
        int counter = 1;
        for (int x = 0; x < 8; x++) {
            for (int i = 0; i < 10; i++) {
                CheckBox cb = createNumbersCheckbox(counter, spotButtonsHolder, grid, drawBtn);

                grid.add(cb, i, x);
                counter++;
            }
        }
    }

    public Scene getScene() {
        return this.scene;
    }
}
