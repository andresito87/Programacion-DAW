package JavaFXMLBaseDemo2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase principal del ejemplo
 * 
 * @author Profesor
 */
public class JavaFXEjemplo extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        // El contenido del archivo FXML se carga en un contenedor genérico de
        // tipo panel JavaFX, que se almacena en la variable root. Dicho 
        // contenedor será el contenedor principal de los elementos gráficos 
        // de la aplicación, y en la línea siguiente se le asigna a la escena
        // (Scene) de la ventana de la aplicación.        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}