package Controles;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Ejemplo de uso de CheckBox
 *
 * @author JJBH
 */
public class CheckBoxDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crear una etiqueta
        Label etiqueta = new Label();
        // Establecer el texto de una etiqueta recien creada
        etiqueta.setText("No está seleccionado.");

        // T�tulo de la ventana.
        primaryStage.setTitle("Ejemplo CheckBox");

        // Crear checkbox
        CheckBox checkBox1 = new CheckBox("Estudiante");

        // A�adir EventHandler al checkbox
        checkBox1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (checkBox1.isSelected()) {
                    // Establecer el texto de una etiqueta
                    etiqueta.setText("Está seleccionado.");
                } else {
                    // Establecer el texto de una etiqueta
                    etiqueta.setText("No está seleccionado.");
                }

            }
        });

        // Crear layout
        VBox hbox = new VBox(checkBox1);

        // A�adir la etiqueta al layout
        hbox.getChildren().add(etiqueta);

        //A�adir layout a la escena
        Scene scene = new Scene(hbox, 250, 130);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
