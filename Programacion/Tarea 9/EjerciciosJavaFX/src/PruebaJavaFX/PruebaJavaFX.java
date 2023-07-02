package PruebaJavaFX;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author andres
 */
public class PruebaJavaFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }
//Este metodo es obligatorio

    public void start(Stage primaryStage) {
        Group root = new Group();
        //El grupo que se desea agregar, y el tamaño ancho y alto
        Scene scene = new Scene(root, 300, 300);
        //Titulo de la ventana
        primaryStage.setTitle("JavaFx");
        //Se agrega la scena
        primaryStage.setScene(scene);

        // create a label
        Label l = new Label("Por ahora no has clicado el botón...");

        // action event
        EventHandler<MouseEvent> event = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                l.setText("¡¡¡Has hecho clic con el ratón en el BOTÓN!!!");
            }
        };

        //Creacion del boton
        Button boton = new Button("JavaFX");
        boton.setDefaultButton(true);
        //Tamaño del boton
        boton.setPrefSize(100, 50);
        //Tamaño del boton
        //Posicion dle boton
        boton.setLayoutX(105);
        boton.setLayoutY(110);
        boton.setOnMouseClicked(event);

        //Se agrega el boton
        root.getChildren().add(boton);
        //Se agrega el label
        root.getChildren().add(l);
        //Para mostrar la visible, semejante al setVisible(true)
        primaryStage.show();
    }
}
