package JavaFXCargandoArchivosMultimedia;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import static java.lang.System.exit;
import javafx.geometry.Pos;

/**
 * Carga un imagen y la muestra en una ventana.
 *
 * @author Profesor
 */
public class JavaFXcargaImagen extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        try {
            // Título de la ventana
            primaryStage.setTitle("Cargar imagen");
            // Ruta con la imagen a cargar
            //FileInputStream input = new FileInputStream("C:\\fotos\\mifoto.png");
            FileInputStream input = new FileInputStream(System.getProperty("user.dir") + "\\recursos\\moto.jpg");
            Image image = new Image(input);
            ImageView imageView = new ImageView(image);

            // Crear panel
            HBox hbox = new HBox(imageView);
            // Centrar el pael hbox en la ventana
            hbox.setAlignment(Pos.CENTER);

            // Crear escena
            Scene scene = new Scene(hbox, 300, 200);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (FileNotFoundException e) {
            System.err.print("Imagen no encontrada");
            exit(-1);
        }

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
