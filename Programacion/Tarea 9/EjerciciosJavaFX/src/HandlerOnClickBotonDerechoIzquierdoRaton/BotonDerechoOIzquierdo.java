package HandlerOnClickBotonDerechoIzquierdoRaton;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author andres
 */
public class BotonDerechoOIzquierdo extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 300, 250);

        primaryStage.setScene(scene);
        primaryStage.show();

        // Detectar ratón pulsado
        scene.setOnMousePressed((MouseEvent mouseEvent) -> {
            // Insertar aquí el código a ejecutar cuando se pulse el ratón
            System.out.println("Ratón pulsado en (x, y): ("
                    + mouseEvent.getX() + ", " + mouseEvent.getY() + ")");
        });

        // Detectar ratón soltado
        scene.setOnMouseReleased((MouseEvent mouseEvent) -> {
            // Insertar aquí el código a ejecutar cuando se suelte el ratón
            System.out.println("Ratón soltado en (x, y): ("
                    + mouseEvent.getX() + ", " + mouseEvent.getY() + ")");
        });

        // Detectar clic en ratón (pulsado y soltado)
        scene.setOnMouseClicked((MouseEvent mouseEvent) -> {
            // Insertar aquí el código a ejecutar cuando se haga clic en el ratón
            System.out.println("Ratón clicado en (x, y): ("
                    + mouseEvent.getX() + ", " + mouseEvent.getY() + ")");
            // También se puede comprobar sobre qué botón se ha actuado,
            //  válido para cualquier acción (pressed, released, clicked, etc)
            if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                System.out.println("Botón principal");
            } else if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                System.out.println("Botón secundario");
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
