package Controles;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

/**
 *
 * @author andres
 */
public class MenuDemo2 extends Application {

    public void start(Stage primaryStage) {

        primaryStage.setTitle("MenuBar");

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 700, 200);

        MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");
        MenuItem saveMenuItem = new MenuItem("Save");
        MenuItem exitMenuItem = new MenuItem("Exit");

        Menu editMenu = new Menu("Edit");
        MenuItem undoMenuItem = new MenuItem("Undo");
        MenuItem redoMenuItem = new MenuItem("Redo");
        MenuItem cutMenuItem = new MenuItem("Cut");

        Menu subMenuItem = new Menu("Sub");
        MenuItem sub1MenuItem = new MenuItem("Sub1");
        MenuItem sub2MenuItem = new MenuItem("Sub2");
        subMenuItem.getItems().addAll(sub1MenuItem, sub2MenuItem);

        fileMenu.getItems().addAll(newMenuItem, saveMenuItem, exitMenuItem);
        editMenu.getItems().addAll(undoMenuItem, redoMenuItem, cutMenuItem, subMenuItem);
        menuBar.getMenus().addAll(fileMenu, editMenu);

        root.setTop(menuBar);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
