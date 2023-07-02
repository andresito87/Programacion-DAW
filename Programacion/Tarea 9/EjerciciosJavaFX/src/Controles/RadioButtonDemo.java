package Controles;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Ejemplo en el que se añaden cuatro radiobotones. Tal y como está, pueden ser
 * seleccionados varios a la vez.
 *
 * @author JJBH
 */
public class RadioButtonDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        // T�tulo de la ventana
        primaryStage.setTitle("Canales de TV");

        // Crear cuatro radiobotones
        RadioButton radioButton1 = new RadioButton("La 1");
        RadioButton radioButton2 = new RadioButton("La 2");
        RadioButton radioButton3 = new RadioButton("Antena 3");
        RadioButton radioButton4 = new RadioButton("Cuatro");
        // Crear un layout HBox y añadirle los radiobotones
        HBox hbox = new HBox(radioButton1, radioButton2, radioButton3,
                radioButton4);

        // Establecer espaciado entre los elementos del layout en 10px
        hbox.setSpacing(10);

        // Crear un ToggleGroup
        ToggleGroup grupo = new ToggleGroup();
        // A�adir todos los readiobotnes al ToggleGroup
        grupo.getToggles().addAll(radioButton1, radioButton2, radioButton3,
                radioButton4);

        // Seleccionar el primer radiobot�n
        radioButton1.setSelected(true);

        // Crear la escena con el layout reci�n creado
        Scene scene = new Scene(hbox, 300, 100);
        // A�adir la escena al escenario
        primaryStage.setScene(scene);
        // Mostrar el escenario
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
