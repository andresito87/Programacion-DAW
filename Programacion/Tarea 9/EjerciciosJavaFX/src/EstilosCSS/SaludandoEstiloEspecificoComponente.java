package EstilosCSS;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author andres
 */
public class SaludandoEstiloEspecificoComponente extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Crear un primer botñn
        Button boton1 = new Button();
        boton1.setText("Botón con estilo por defecto");
        boton1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Primer botón pulsado!");
            }
        });

        // Definimos la cadena con los estilos para el segundo botñn
        String styles
                = "-fx-background-color: #0Ae0ff;"
                + "-fx-border-color: #FAEBD7;";
        //Creamos el segundo botñn
        Button boton2 = new Button("Botón con estilo propio");
        boton2.setStyle(styles);
        boton2.setOnAction((ActionEvent event) -> {
            System.out.println("Segundo botón pulsado!");
        });

        // Crear un tercer botñn
        Button boton3 = new Button();
        // Definimos la cadena con los estilos para el segundo botñn
        String styles3
                = "-fx-background-color: #F2eAff;"
                + "-fx-border-color: #ff1406;";
        boton3.setStyle(styles3);
        boton3.setText("Botón 3 con estilo personalizado");
        boton3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Tercer botón pulsado!");
            }
        });

        // Creamos un layout
        VBox cajaVertical = new VBox();
        //agregamos un nodo hijo de tipo Button
        cajaVertical.getChildren().add(boton1);
        //agregamos un nodo hijo de tipo Button
        cajaVertical.getChildren().add(boton2);
        //agregamos un nodo hijo de tipo Button
        cajaVertical.getChildren().add(boton3);

        //Creamos la escena y le pasamos como parñmetro nuestro layout
        Scene s = new Scene(cajaVertical, 300, 190);
        primaryStage.setTitle("CSS propio");
        primaryStage.setScene(s);
        //y mostramos la ventana
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
