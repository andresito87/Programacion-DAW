package HandlerOnClickHolaMundo;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Escribir hola mundo por consola cuando se pulse el botón de la ventana.
 *
 * @author JJBH
 */
public class HolaMundo extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Crear botón
        Button btn = new Button();
        // Texto del botón
        btn.setText("Escribir 'Hola mundo'");
        // Crear manejador de evento para la acción que se debe hacer al clicar
        // sobre el botón.
        btn.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                if (t.getButton() == MouseButton.PRIMARY) {
                    System.out.println("¡Hola mundo!");
                }
            }
        });

        // Crear un panel
        StackPane root = new StackPane();
        // Añadir icono a la ventana
        primaryStage.getIcons().add(new Image(System.getProperty("user.dir") + "\\recursos\\icono.png"));
        // Añadir el botón al panel.
        root.getChildren().add(btn);
        // Crear la escena
        Scene scene = new Scene(root, 300, 250);
        // Dar título al escenario
        primaryStage.setTitle("Hola mundo.");
        // Añadir la escena al escenario
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
