package Components;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class MainMenuBar {
    public MainMenuBar() {}

    public static MenuBar getMainMenuBar(Stage primaryStage, Text text) {
        MenuBar menu = new MenuBar();

        Menu mOne = new Menu("Menu");

        MenuItem iOne = new MenuItem("Display the rules of the game");
        iOne.setOnAction(e ->
        {
            try
            {
                text.setText("");
                File inFile = new File("GameInstructions.txt");
                Scanner scan = new Scanner(inFile);
                while (scan.hasNextLine())
                {
                    String data = "\n" + scan.nextLine();
                    text.setText(text.getText() + data);
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
        iTwo.setOnAction(e ->
        {
            try
            {
                text.setText("");
                File inFile = new File("OverallOdds.txt");
                Scanner scan = new Scanner(inFile);
                while (scan.hasNextLine())
                {
                    String data = "\n" + scan.nextLine();
                    text.setText(text.getText() + data);
                }
                scan.close();
            }

            catch (FileNotFoundException error)
            {
                System.out.println("An error occurred.");
                error.printStackTrace();
            }
        });
        mOne.getItems().add(iTwo); //add menu item to first menu

        MenuItem iThree = new MenuItem("Exit the game");
        iThree.setOnAction(e -> primaryStage.close());
        mOne.getItems().add(iThree); //add menu item to first menu

        menu.getMenus().addAll(mOne);

        return menu;
    }

    public static MenuBar getGameMainMenuBar(Stage primaryStage, Text text, VBox vb) {
        MenuBar menu = new MenuBar();

        Menu mOne = new Menu("Menu");
        MenuItem iOne = new MenuItem("Display the rules of the game");
        iOne.setOnAction(e ->
        {
            try
            {
                text.setText("");
                File inFile = new File("GameInstructions.txt");
                Scanner scan = new Scanner(inFile);
                while (scan.hasNextLine())
                {
                    String data = "\n" + scan.nextLine();
                    text.setText(text.getText() + data);
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
        iTwo.setOnAction(e ->
        {
            try
            {
                text.setText("");
                File inFile = new File("OverallOdds.txt");
                Scanner scan = new Scanner(inFile);
                while (scan.hasNextLine())
                {
                    String data = "\n" + scan.nextLine();
                    text.setText(text.getText() + data);
                }
                scan.close();
            }

            catch (FileNotFoundException error)
            {
                System.out.println("An error occurred.");
                error.printStackTrace();
            }
        });
        mOne.getItems().add(iTwo); //add menu item to first menu

        //To be implemented
        MenuItem iFour = new MenuItem("New Look");
        iFour.setOnAction(e ->
        {
            vb.setStyle("-fx-background-color: pink;");
            text.setFont(Font.font ("Cambria", 12));
            text.setFill(Color.rgb(0, 0, 225));
        });
        mOne.getItems().add(iFour); //add menu item to first menu

        MenuItem iThree = new MenuItem("Exit the game");
        iThree.setOnAction(e -> primaryStage.close());
        mOne.getItems().add(iThree); //add menu item to first menu

        menu.getMenus().addAll(mOne);

        return menu;
    }
}
