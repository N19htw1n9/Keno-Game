package Components;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainMenuBar {
    public MainMenuBar() {}

    public static MenuBar getMainMenuBar(Stage primaryStage, TextArea textBox) {
        MenuBar menu = new MenuBar();

        Menu mOne = new Menu("Menu");
        //Menu options need to be implemented to complete Step 1
        MenuItem iOne = new MenuItem("Display the rules of the game");
        iOne.setOnAction(e ->
        {
            try
            {
                textBox.clear();
                File inFile = new File("GameInstructions.txt");
                Scanner scan = new Scanner(inFile);
                while (scan.hasNextLine())
                {
                    String data = "\n" + scan.nextLine();
                    textBox.appendText(data);
                }
                scan.close();
            }

            catch (FileNotFoundException error)
            {
                System.out.println("An error occurred.");
                error.printStackTrace();
            }
        });
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
}
