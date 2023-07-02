package Controles;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Validar JavaFX TextField como Integer
 *
 * @author Profesor
 */
public class BotonConValidacion extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Crear etiqueta para escribir lo qeu se pide al usuario
        Label etiInfo = new Label();
        etiInfo.setText("Introduzca un número entero");

        // Crear campo de texto donde se espera que se escriba el número
        TextField textIn = new TextField();

        // Crear etiqueta donde el programa escribirá el resultado
        Label etiRespuesta = new Label();

        // Crear botón de aceptar
        Button boton = new Button("Aceptar");
        // Crear manejador de evento para el botón (empleamos notaci�n lambda)
        boton.setOnAction((ActionEvent event) -> {
            // Convertir el texto en Integer, sin salta la excepci�n ser� porque
            // el usuario no introdujo un entero.
            try {
                Integer i = Integer.parseInt(textIn.getText());
                etiRespuesta.setText("Correcto: " + i);
            } catch (NumberFormatException e) {
                etiRespuesta.setText("¡No es un entero!");
            }
        });

        // Crear un layout 
        VBox vBox = new VBox();
        // Añadir los controles al layout
        vBox.getChildren().addAll(etiInfo, textIn, boton, etiRespuesta);

        // Crear la escena                 
        Scene scene = new Scene(vBox, 290, 140);
        // Establecer el título del escenario 
        primaryStage.setTitle("Probando validaciones");
        // A�adir la escena al escenario
        primaryStage.setScene(scene);
        // Mostrar el escenario
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
