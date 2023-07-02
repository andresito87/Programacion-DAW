package Controles;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Ejemplo de uso del control Lista (ListView)
 *
 * @author Profesor
 */
public class ListViewDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Lista de postres.");

        // Crear la lista
        ListView listView = new ListView();

        // Añadir los elementos
        listView.getItems().add("Bizcocho");
        listView.getItems().add("Tostada");
        listView.getItems().add("Helado");

        // Añadimos un botón para obtener el valor seleccionado.
        Button boton = new Button("Obtener valor seleccionado");

        //Permitimos la seleccion multiple, manteniendo las teclas SHIFT o CTRL
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // Cuando se haga click en el botón, obtendremos los datos que queremos
        boton.setOnAction(event -> {
            // Obtener el modelo, los datos guardados en la lista, y
            // concretamente los índices de los elementos con getSelectedIndices()
            ObservableList selectedIndices
                    = listView.getSelectionModel().getSelectedIndices();

            // Recorrer los elementos seleccionados y escribir el índice y
            // su clase
            for (Object o : selectedIndices) {
                System.out.println("o = " + o + " (" + o.getClass() + ")");

            }

            // También, así podemos obtener el elemento en sí
            System.out.println(listView.getSelectionModel().getSelectedItem());

        });

        // Añadir la lista al layout
        VBox vbox = new VBox(listView, boton);

        // Añadir layout a la escena
        Scene scene = new Scene(vbox, 300, 120);

        // Añadir la escena al escenario
        primaryStage.setScene(scene);

        // Mostrar el escenario
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
