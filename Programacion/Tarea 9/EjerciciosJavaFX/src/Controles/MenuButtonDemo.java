package Controles;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Ejemplo de uso del control MenuButton. Se crea un control de este tipo al
 * cual se le añaden tres elementos. El elemento elegido se escribe mediante un
 * control etiqueta.
 *
 * @author Profesor
 */
public class MenuButtonDemo extends Application {

    // Crear la etiquetas
    Label msgLbl = new Label("Elige el helado");

    @Override
    public void start(Stage stage) {
        // Crear el MenuItem ford
        MenuItem choco = new MenuItem("Chocolate");
        // Añadir EventHandler al MenuItem
        choco.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                msgLbl.setText("Has seleccionado chocolate.");
            }
        });

        // Crear el MenuItem fresa
        MenuItem fresa = new MenuItem("Fresa");
        // Añadir EventHandler al MenuItem
        fresa.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                msgLbl.setText("Has elegido: Fresa");
            }
        });

        // Crear el MenuItem Vainilla
        MenuItem vainilla = new MenuItem("Vainilla");
        // Añadir EventHandler alMenuItem
        vainilla.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                msgLbl.setText("Has elegido: Vainilla");
            }
        });

        // Crear el MenuButton
        MenuButton helados = new MenuButton("Selecciona");
        // Añadir los elementos del menú al MenuButton
        helados.getItems().addAll(choco, fresa, vainilla);

        // Crear el VBox
        VBox root = new VBox();
        // Añadir los hijos al VBox
        root.getChildren().addAll(helados, msgLbl);
        // Set the Size of the VBox
        root.setMinSize(350, 250);

        //* Establecer atributos del VBoxSet
        root.setStyle("-fx-padding: 10;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 3;"
                + "-fx-border-width: 1;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 1;"
                + "-fx-border-color: red;");

        // Crear la escena
        Scene scene = new Scene(root);

        // Añadir la escena al escenario
        stage.setScene(scene);

        // Dar título al escenario
        stage.setTitle("Ejemplo de MenuButton");
        // Mostrar el escenario
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
