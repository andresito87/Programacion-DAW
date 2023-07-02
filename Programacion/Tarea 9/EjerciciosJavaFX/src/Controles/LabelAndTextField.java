package Controles;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Ejemplo de uso de etiquetas y campos de texto en JavaFX Se muestra también
 * cómo se puede asociar una imagen a una etiqueta
 *
 * @author JJBH
 */
public class LabelAndTextField extends Application {

    // Crear etiqueta
    Label etiqueta = new Label("Escribe tu nombre en los campos de texto.");
    // Crear etiqueta para el nombre
    Label labelNombre = new Label("Nombre:");

    @Override
    public void start(Stage primaryStage) {

        // Dar color a la etiqueta
        etiqueta.setTextFill(Color.web("#0076a3"));

        // Obtener image y asoociarla a la etiqueta.
        // (Estamos suponiendo que existe esa imagen, por lo que deberíamos
        // capturar las excepciones que puedan surgir en este punto, por si no
        // existiera, pero lo omitimos por claraida de este código.
        Image image = new Image(getClass().getResourceAsStream("../recursos/lupa.png"));
        etiqueta.setGraphic(new ImageView(image));

        // Crear campos de texto
        TextField campoNombre = new TextField();
        TextField campoApellidos = new TextField();
        // Ancho para mostraar 15 caracteres
        campoNombre.setPrefColumnCount(15);
        campoApellidos.setPrefColumnCount(15);

        // Establecer los manejadores ActionEvent para ambos campos de texto
        campoNombre.setOnAction((ActionEvent e) -> {
            etiqueta.setText("Has cambiado el nombre");
        });
        campoApellidos.setOnAction((ActionEvent e) -> {
            etiqueta.setText("Has cambiado los apellidos");
        });

        // Para la etiqueta del nombre establecemos manejadores para que se
        // haga un zoom, cuando con el ratón nos acerquemos a ella, y se quite
        // el zoom al alejarnos, al salir de ella.
        labelNombre.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                labelNombre.setScaleX(1.5);
                labelNombre.setScaleY(1.5);
            }
        });
        labelNombre.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                labelNombre.setScaleX(1);
                labelNombre.setScaleY(1);
            }
        });

        // Crear un Gridpane
        GridPane panel = new GridPane();

        // Añadir etiquetas y campos al GridPane
        panel.addRow(0, etiqueta);
        panel.addRow(1, labelNombre, campoNombre);
        panel.addRow(2, new Label("Apellidos:"), campoApellidos);

        // Establecer el tamaño del panel
        panel.setMinSize(350, 250);
        // Establecer propiedades del GridPane
        panel.setStyle("-fx-padding: 10;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: blue;");

        // Crear la escena
        Scene scene = new Scene(panel);

        // Título de la ventana
        primaryStage.setTitle("Etiquetas y campos de texto");
        // Añadir la escena al escenario
        primaryStage.setScene(scene);
        // Mostrar el escenario
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
